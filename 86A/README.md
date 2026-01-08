# 🔍 A. Reflection

## 📌 Problem Overview

For any positive integer `n`, define its **reflection** `ψ(n)` as follows:

- Replace every digit `a` in `n` with `(9 - a)`
- Remove any leading zeros

### Examples
- `ψ(192) = 807`
- `ψ(9) = 0`
- `ψ(91) = 8`

The **weight** of a number is defined as:

weight(n) = n × ψ(n)

---

## 🎯 Objective

Given a range `[l, r]`, find the **maximum weight** among all integers `n` such that:

l ≤ n ≤ r

---

## 🧠 Key Observations

1. For numbers with the **same number of digits** `d`, reflection behaves as:

ψ(n) = (10^d - 1) - n

2. Therefore, weight becomes:

weight(n) = n × (K - n)
where K = 10^d - 1

3. This is a **concave quadratic function**, which achieves its maximum near:

n ≈ K / 2

4. Since the valid interval is restricted to `[l, r]`, we only need to check:
- `low`
- `high`
- `mid`
- `mid + 1`

This avoids brute force and keeps the solution efficient.

---

## 🛠️ Algorithm

1. Determine the digit length of `l` and `r`
2. For each digit length in that range:
- Compute `K = 10^d - 1`
- Restrict the range to valid `[low, high]`
- Evaluate the weight at critical points
3. Track the maximum weight encountered

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     
     long l = scanner.nextLong();
     long r = scanner.nextLong();
     
     long maxWeight = 0;
     
     int lenL = String.valueOf(l).length();
     int lenR = String.valueOf(r).length();
     
     long start = 1;
     for (int i = 1; i < lenL; i++) start *= 10;
     
     for (int len = lenL; len <= lenR; len++) {
         long K = start * 10 - 1;
         
         long low = Math.max(l, start);
         long high = Math.min(r, K);
         
         if (low <= high) {
             long mid = K / 2;
             
             maxWeight = Math.max(maxWeight, low * (K - low));
             maxWeight = Math.max(maxWeight, high * (K - high));
             
             if (mid >= low && mid <= high)
                 maxWeight = Math.max(maxWeight, mid * (K - mid));
             
             if (mid + 1 >= low && mid + 1 <= high)
                 maxWeight = Math.max(maxWeight, (mid + 1) * (K - (mid + 1)));
         }
         
         start *= 10;
     }
     
     System.out.println(maxWeight);
     scanner.close();
 }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(log₁₀ r)`
- **Space Complexity:** `O(1)`
