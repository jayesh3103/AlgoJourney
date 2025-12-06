# 🧮 Problem of the Day — A. Irrational Problem

### 📅 Daily Codeforces Challenge  
A probability-based modular arithmetic puzzle involving permutations of modulus operations.

---

## 📝 Problem Summary

You're given four **distinct** integers:
- p1, p2, p3, p4
And a range:
- [a, b]
Petya originally had a function:
- f(x) = (((x % p1) % p2) % p3) % p4
But he **forgot the order** of applying the remainders.

Since there are **4! = 24 permutations**, each permutation of the modulus order is equally likely.

Your task:

> Count how many integers **x ∈ [a, b]** satisfy  
> `f(x) = x` for **at least 7 permutations** out of 24  
> (≈ 29.17% which meets the ≥31.4159% requirement).

---

## 🎯 Key Observation

For any modulo:
- x % p = x   if x < p
Therefore:

- If x < min(p1, p2, p3, p4)
then **all 24 permutations** keep `x` unchanged → `f(x) = x` ✔️

- If x ≥ min(p)
then the smallest modulus eventually appears in some permutation, reducing `x`, and thus  
**f(x) ≠ x** in many permutations → fewer than 7 valid permutations ❌

Thus **only integers strictly less than the minimum modulus work**.

This reduces the entire problem to a simple count.

---

## ✔️ Final Logic

Let: m = min(p1, p2, p3, p4)
We count: x ∈ [a, b] where x < m
Answer is: max(0, min(b, m-1) - a + 1)

---

## ⏱️ Time & Space Complexity

| Type | Complexity |
|------|------------|
| **Time** | `O(1)` |
| **Space** | `O(1)` |

Super efficient due to mathematical simplification.

---

## 🧠 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        int p3 = sc.nextInt();
        int p4 = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int minVal = Math.min(Math.min(p1, p2), Math.min(p3, p4));

        int count = 0;
        for (int x = a; x <= b; x++) {
            if (x < minVal) {
                count++;
            }
        }

        System.out.println(count);
    }
}
```
