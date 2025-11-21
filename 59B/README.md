# 🍀 Fortune Telling – Codeforces Practice

This is my solution for the **Fortune Telling** problem from Codeforces.  
This README explains the **logic, reasoning, Java implementation, and complexity** of the solution.

---

## 📄 Problem Summary

Marina performs fortune-telling by plucking petals while alternating between:
Loves → Doesn’t love → Loves → Doesn’t love → …

She **always starts with “Loves”**.

- A bouquet’s total number of petals determines the final phrase.
- If the **total number of petals is odd**, the result ends on **"Loves"**.
- If it’s **even**, the result ends on **"Doesn't love"**.

Your goal is to choose a subset of flowers such that:

### 🎯 The total number of petals:
- Is **as large as possible**  
- And the final result is **"Loves"** → total **must be odd**

---

## 💡 Approach

1. **Compute the total sum** of all petals.
2. If this total is already **odd**, that’s the best possible answer.
3. If the total is **even**, we must remove **one odd-petaled flower** to make the sum odd.
   - Removing an **odd** value flips parity.
   - Removing an **even** value keeps parity even → useless.
4. Choose the **smallest odd flower** to subtract for minimal loss.
5. If **no odd flowers exist**, no odd total is possible → answer is `0`.

This greedy strategy ensures the maximal odd sum.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int sum = 0;
        int minOdd = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            sum += val;
            
            if (val % 2 != 0) {
                minOdd = Math.min(minOdd, val);
            }
        }
        
        if (sum % 2 != 0) {
            System.out.println(sum);
        } else {
            if (minOdd == Integer.MAX_VALUE) {
                System.out.println(0);
            } else {
                System.out.println(sum - minOdd);
            }
        }
    }
}
```
---
## ✅ Complexity

- **Time Complexity:** `O(n)` 
- **Space Complexity:** `O(1)`  
