# 🕵️ A. Sleuth — Codeforces Daily Challenge  

Welcome to today’s challenge in **AlgoJourney**!  
Vasya’s friends have had enough of his endless detective questions — so you, the coder, must automate their answers.  
Let’s see if you can outsmart the sleuth! 🕵️‍♂️💬  

---

## 📜 Problem Description  

Vasya plays **Sleuth**, a game where his friends answer his questions **based on the last letter** of the question:  
- If the **last letter** (ignoring spaces and `?`) is a **vowel** → they say **YES**  
- If it’s a **consonant** → they say **NO**

Your task is to simulate his friends and print the appropriate response.  

---

## 💡 Approach  

1. **Ignore the Trailing Characters:**  
   - The question always ends with a `?`, possibly followed by spaces.  
   - These characters are **not** considered in determining the last letter.

2. **Find the Last Letter:**  
   - Traverse the string **backward** from the end,  
     stopping at the first **alphabetic character**.

3. **Check for Vowel:**  
   - Convert that character to **uppercase** for uniform comparison.  
   - If it belongs to the set `{A, E, I, O, U, Y}` → print **YES**, else **NO**.

---

## 🧩 Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String line = in.nextLine();
            
            char lastLetter = ' ';
            
            for (int i = line.length() - 2; i >= 0; i--) {
                char c = line.charAt(i);
                if (Character.isLetter(c)) {
                    lastLetter = Character.toUpperCase(c);
                    break;
                }
            }

            String vowels = "AEIOUY";
            if (vowels.indexOf(lastLetter) != -1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`
