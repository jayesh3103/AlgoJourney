# 🔤 Choosing Symbol Pairs – Codeforces Practice

This is my solution for the **Choosing Symbol Pairs** problem from Codeforces.  
This README explains my **approach, reasoning, and implementation** behind the solution.

---

## 📄 Problem Description

You are given a string **S** consisting of lowercase Latin letters and digits.  
Your task is to find the total number of **ordered pairs** `(i, j)` such that:

1. `1 ≤ i, j ≤ N`  
2. `S[i] = S[j]`

That means, for every position `i` and `j`, if the characters are the same, we count it as one valid pair.  
Note that `(x, y)` and `(y, x)` are **counted as different pairs**.

---

## 💡 Approach

1. **Frequency Counting:**  
   - Each character can pair with itself and every other occurrence of the same character.  
   - If a character appears `f` times, it contributes `f × f` ordered pairs (including pairs where `i = j`).

2. **Summation:**  
   - Calculate the total by summing `f²` over all distinct characters.

3. **Mathematical Intuition:**  
   - The formula for total valid pairs is:  
     ```
     Total = Σ (count[c])²  for every unique character c
     ```

> This elegant observation allows us to avoid the naive `O(n²)` double-loop approach and solve the problem efficiently.

---

## 🖥️ Implementation (Java)

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            
            Map<Character, Integer> counts = new HashMap<>();
            
            for (char c : s.toCharArray()) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
            
            long total = 0;
            for (int count : counts.values()) {
                total += (long)count * count;
            }
            
            System.out.println(total);
        }
    }
}
```
---
## ✅ Complexity

- **Time Complexity:** `O(n)` 
- **Space Complexity:** `O(k)`  
