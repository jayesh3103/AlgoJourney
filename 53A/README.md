# ⚙️ Autocomplete – Codeforces Practice

This is my solution for the **Autocomplete** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

- Vasya is developing an **autocomplete feature** for the browser “BERowser”.  
- The browser remembers the **last `n` visited pages** and a user input prefix `s`.  
- The goal is to complete `s` to one of the visited pages such that:
  - The completed address **starts with `s`**, and  
  - It is **lexicographically smallest** among all possible completions.  

If no page starts with `s`, print `s` itself.

---

## 💡 Approach

1. **Input reading:**  
   - Read the prefix `s` and the number of visited pages `n`.  

2. **Filter candidates:**  
   - Check each page using `startsWith(s)` and collect all matching pages in a list.  

3. **Find lexicographically smallest:**  
   - Sort the list using `Collections.sort()` and take the **first element** as the answer.  

4. **Output:**  
   - If no matches exist → print `s`.  
   - Otherwise → print the first (smallest) page.

---

## 🖥️ Implementation (Java)

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            int n = in.nextInt();

            List<String> matches = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String page = in.next();
                if (page.startsWith(s)) {
                    matches.add(page);
                }
            }

            if (matches.isEmpty()) {
                System.out.println(s);
            } else {
                Collections.sort(matches);
                System.out.println(matches.get(0));
            }
        }
    }
}
```
---
## ✅ Complexity

- **Time Complexity:** `O(n * L + k log k)`
  - where L = average string length and k = number of matches. 
- **Space Complexity:** `O(k)`
