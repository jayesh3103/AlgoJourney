# 🔤 Word – Codeforces Practice

This is my solution for the **Word** problem from Codeforces.  
This README outlines the **problem understanding, approach, implementation, and complexity** in a clean and structured manner.

---

## 📄 Problem Description

Vasya dislikes words that mix **uppercase** and **lowercase** letters.  
To fix this, he wants to convert a given word into:

- **ALL lowercase**, or  
- **ALL uppercase**

…while changing **as few characters as possible**.

Rules:

- If a word has **more uppercase letters**, convert the entire word to **UPPERCASE**.  
- Otherwise (including a tie), convert it to **lowercase**.

---

## 💡 Approach

1. **Count uppercase and lowercase letters**:
   - Iterate through the string.
   - Track `upperCount` and `lowerCount`.

2. **Choose the better transformation**:
   - If `upperCount > lowerCount`: convert whole word to **uppercase**.
   - Else: convert whole word to **lowercase**.

3. **Output** the corrected word.

This greedy approach works because:
- Changing all letters to one consistent case minimizes modifications.
- The rule directly depends on which group is larger.

---

## 🖥️ Implementation (Java)

```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String s = sc.next();
        
        int upperCount = 0;
        int lowerCount = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            } else {
                lowerCount++;
            }
        }
        
        if (upperCount > lowerCount) {
            out.println(s.toUpperCase());
        } else {
            out.println(s.toLowerCase());
        }
        
        out.flush();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
```
---
## ✅ Complexity

- **Time Complexity:** `O(n)` 
- **Space Complexity:** `O(1)`  
