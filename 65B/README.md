# **Harry Potter and the History of Magic**  
### *Chronology Correction Under One-Digit Mutation Constraint*

---

## 📌 Problem Summary

Ron must rewrite Harry’s lecture notes which contain **N four-digit dates** (`1000–9999`).  
The dates are corrupted and may:

- be unordered  
- contain future dates (> 2011)  
- contain too old dates (< 1000)

Ron can modify **at most one digit per date**, and must produce a new list:

- each date `zi` must lie in `[1000, 2011]`
- sequence must be **non-decreasing**
- each `zi` differs from `yi` in **≤ 1 digit**
- no leading zeros allowed
- if no valid sequence exists → print **"No solution"**

---

## 🧠 Strategy Adopted

For each date `yi`, maintain a variable `last` — the minimum acceptable value for the current position.

To choose the corrected date `zi`, we check:

### **1. Direct acceptance**  
If `yi` is already valid and `yi ≥ last`, choose it.

### **2. Try changing exactly one digit**  
For each of the four digits:

- try replacing it with digits `0–9`
- rebuild the number
- accept if:
  - `newVal ∈ [last, 2011]`
  - only one digit changed  
  - no leading zero  
- pick the **minimum possible** valid value (`best`)

If after all tries, no valid number exists → **No solution**.

---

## 🚀 Final Algorithm (Your Implementation)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] ans = new int[n];
        int last = 1000;

        for (int i = 0; i < n; i++) {
            int current = arr[i];
            int best = 10000;

            if (current >= last && current <= 2011) {
                best = current;
            }
            int[] digits = new int[4];
            digits[0] = current / 1000;
            digits[1] = (current / 100) % 10;
            digits[2] = (current / 10) % 10;
            digits[3] = current % 10;

            for (int j = 0; j < 4; j++) {
                int original = digits[j];
                for (int k = 0; k <= 9; k++) {
                    digits[j] = k;
                    int val = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];

                    if (val >= last && val <= 2011) {
                        if (val < best) {
                            best = val;
                        }
                    }
                }
                digits[j] = original;
            }

            if (best == 10000) {
                System.out.println("No solution");
                return;
            }

            ans[i] = best;
            last = best;
        }

        for (int x : ans) {
            System.out.println(x);
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`
