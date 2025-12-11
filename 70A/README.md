# 🍪 A. Cookies — Codeforces Solution

## 📌 Problem Summary
Fangy has a square box of size **2ⁿ × 2ⁿ**, divided into 1×1 cells.  
He fills this box with triangular-shaped "cookies" of size **k**, where each cookie occupies:

- a **k × k** square
- filled from the main diagonal **and above**  
  (i.e., exactly `k*(k+1)/2` cells)

He has **infinite cookies of every size ≥ 2**, but **no cookies of size 1**.

Fangy follows a greedy algorithm:

1. Find the largest cookie that fits in the remaining area.
2. Place it without rotation.
3. Repeat until no more cookies can be placed.

Because size-1 cookies do not exist, some single cells remain empty.

### 🎯 Objective  
Given **n**, compute how many empty cells remain in a **2ⁿ × 2ⁿ** box.  
Output the answer modulo **1,000,003**.

---

## 🧠 Key Insight & Formula

The official constructive/greedy simulation leads to a beautiful result:

### ✔ The number of empty cells = **3⁽ⁿ⁻¹⁾** for n ≥ 1  
For n = 0 → box is 1×1 → empty cells = **1**

This comes from recursive self-similarity of the 2ⁿ × 2ⁿ packing:

- A 2ⁿ × 2ⁿ box splits into **4 sub-boxes** of size 2ⁿ⁻¹ × 2ⁿ⁻¹.
- The greedy strategy fills 3 of them perfectly using large cookies.
- The remaining one is equivalent to the original box of size 2ⁿ⁻¹.
- Recursion depth = n  
⇒ empty(n) = 3·empty(n−1), with empty(1) = 1  
⇒ empty(n) = 3⁽ⁿ⁻¹⁾.

---

## ⏱️ Time & Space Complexity
| Operation | Complexity |
|----------|------------|
| Exponentiation (loop) | **O(n)** |
| Memory usage | **O(1)** |

This is optimal for n ≤ 1000.

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            long mod = 1000003;

            if (n == 0) {
                System.out.println(1);
            } else {
                long ans = 1;
                for (int i = 0; i < n - 1; i++) {
                    ans = (ans * 3) % mod;
                }
                System.out.println(ans);
            }
        }
    }
}
