# ✉️ B. Text Messaging — Codeforces Daily Solution

## 📌 Problem Summary
Fangy sends text messages, but long texts get automatically split into fixed-size messages of **n characters**.  
He dislikes when **sentences get broken across messages**, so he wants to manually split the text into the *minimum number of messages* such that:

- **Each message contains whole sentences only**.
- Sentences may have spaces between them, but these spaces are **ignored across message boundaries**.
- If a single sentence exceeds size **n**, the task becomes **Impossible**.

A **sentence** ends with one of: `.`, `?`, `!`.

### 🎯 Goal  
Given a text and message size **n**, compute the **minimum number of messages** required, or print **Impossible** if any sentence is too long.

---

## 🧠 Approach & Logic

### ✔ Step 1 — Identify Sentences  
We iterate through the string and detect sentence boundaries at:
`‘.’  ‘?’  ‘!’`
Each detected sentence has length:
`len = (end_index - start_index + 1)`

If: `len > n → Impossible`

### ✔ Step 2 — Greedy Packing of Sentences  
We keep adding sentences into the current message as long as:
`currentLength + 1 (space) + nextSentenceLength <= n`
If not, we:

- finalize current message
- start a new message

Special handling:

- The first sentence in a message **does not need a preceding space**.
- When switching messages, the space between sentences is ignored.

### ✔ Step 3 — Count Messages  
`ans` stores the number of messages, incremented whenever a new message starts.

---

## ⏱️ Time & Space Complexity

| Complexity | Value |
|-----------|--------|
| **Time** | `O(n)` |
| **Space** | `O(1)` |

---

## 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String line1 = reader.readLine();
        if (line1 == null) return;
        int n = Integer.parseInt(line1);
        
        String text = reader.readLine();
        if (text == null) return;
        
        int ans = 0;
        int currentLen = 0;
        int lastStart = 0;
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            
            if (c == '.' || c == '?' || c == '!') {
                int len = i - lastStart + 1;
                
                if (len > n) {
                    System.out.println("Impossible");
                    return;
                }
                
                if (ans == 0) {
                    ans = 1;
                    currentLen = len;
                } else {
                    if (currentLen + 1 + len <= n) {
                        currentLen += 1 + len;
                    } else {
                        ans++;
                        currentLen = len;
                    }
                }
                
                lastStart = i + 2; // skip space after punctuation
                i++;
            }
        }
        
        System.out.println(ans);
    }
}
