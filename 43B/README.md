# ✉️ Letter – Codeforces Practice

This is my solution for the **B. Letter** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

Vasya wants to write an **anonymous letter** using letters cut out from a **newspaper heading**.

You are given:
- A string `s1` — representing the **heading** of the newspaper.
- A string `s2` — representing the **text** of the anonymous letter Vasya wants to compose.

Vasya can:
- Use each **letter from the heading at most once**.
- **Ignore spaces** in the heading (he doesn’t need to cut them).
- Treat **uppercase and lowercase letters as different**.

You must determine if Vasya can compose the letter using letters from the heading.

---

## 💡 Approach

1. **Count the Available Letters:**
   - Iterate over each character in the heading `s1`.
   - If it’s **not a space**, record its count in a frequency map (`HashMap<Character, Integer>`).

2. **Verify the Letter Text (`s2`):**
   - For every character in `s2`:
     - Skip spaces.
     - Check if that character exists in the frequency map with a count > 0.
     - If yes → decrement its count (since it’s used once).
     - If no → impossible to form the letter → print `"NO"` and exit.

3. **Final Result:**
   - If all letters are available in sufficient quantity, print `"YES"`.

---

## 🧠 Core Idea

> The problem is essentially a **frequency matching task**.  
> Each character in the heading represents a limited resource.  
> Vasya can form the letter only if, for every character in `s2`, there’s at least one available copy in `s1`.

This approach ensures **O(n)** time complexity using a **single hash map** to store and update counts efficiently.

---

## 🖥️ Implementation (Java)

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String heading = in.nextLine();
            String letter = in.nextLine();

            Map<Character, Integer> counts = new HashMap<>();
            for (char c : heading.toCharArray()) {
                if (c != ' ') {
                    counts.put(c, counts.getOrDefault(c, 0) + 1);
                }
            }

            boolean ok = true;
            for (char c : letter.toCharArray()) {
                if (c == ' ') continue;

                int count = counts.getOrDefault(c, 0);
                if (count > 0) {
                    counts.put(c, count - 1);
                } else {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}
```
---
## ✅ Complexity
-**Time Complexity:** `O(n1+n2)`
-**Space Complexity:** `O(1)`
