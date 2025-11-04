# 🔢 Sum – Codeforces Practice

This is my solution for the **Sum** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

- Vasya studies **positional numeral systems** but often forgets to note the **base** of the numbers.  
- Given two numbers `a` and `b`, he wants to find the **length of the longest possible value of (a + b)**  
  when interpreted in **any valid base**.

A base `p` is **valid** only if **all digits in both numbers are strictly less than `p`**.  
You must determine how long (in digits) the **largest possible representation** of their sum can be.

---

## 💡 Approach

1. **Find the minimum valid base:**  
   - Scan all digits in both `a` and `b`.  
   - The base must be **greater than the maximum digit** found.  
     ```
     base = maxDigit + 1
     ```

2. **Convert numbers to decimal:**  
   - Use Java’s `Long.parseLong(value, base)` to interpret both numbers in the chosen base.

3. **Calculate the sum:**  
   - Compute `valA + valB` in decimal.

4. **Convert the sum back to the same base:**  
   - Use `Long.toString(sum, base)` to get its representation in that base.

5. **Output the length:**  
   - The answer is simply the **number of characters** in this result.

> This approach combines numeral system basics with string operations for accurate base conversion.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String a = in.next();
            String b = in.next();

            int maxDigit = 0;
            for (char c : (a + b).toCharArray()) {
                maxDigit = Math.max(maxDigit, c - '0');
            }

            int base = maxDigit + 1;

            long valA = Long.parseLong(a, base);
            long valB = Long.parseLong(b, base);

            long sum = valA + valB;

            String result = Long.toString(sum, base);
            System.out.println(result.length());
        }
    }
}
```
---
## ✅ Complexity

- **Time Complexity:** `O(n)` 
- **Space Complexity:** `O(1)`
