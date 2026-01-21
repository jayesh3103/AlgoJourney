# 🟢 A. Chips — Codeforces Problem

## 📌 Problem Summary

There are **n walruses** sitting in a circle, numbered from **1 to n** clockwise.  
A presenter has **m chips** and distributes them as follows:

- Starts from walrus **1**, moving clockwise.
- Walrus **i** receives **i chips**.
- If the presenter cannot give the required number of chips to a walrus, the process **stops immediately**, and the presenter keeps the remaining chips.

### 🎯 Objective
Determine **how many chips remain** with the presenter at the end.

---

## 🧠 Key Insight

- One **full round** of distribution costs:

  \[
  1 + 2 + 3 + \dots + n = \frac{n(n+1)}{2}
  \]

- The presenter can complete several **full rounds**.
- Only the **remaining chips after full rounds** matter.
- We simulate one final round to see where the presenter gets stuck.

---

## 🛠️ Algorithm

1. Read `n` (walruses) and `m` (chips).
2. Compute the total chips required for one full round.
3. Reduce `m` using modulo:

m = m % fullRoundCost

4. Simulate distribution from walrus `1` to `n`:
- If `m >= i`, subtract `i`
- Else, stop
5. Output remaining `m`.

---

## ⏱️ Time and Space Complexity

| Metric | Complexity |
|------|------------|
| Time | **O(n)** |
| Space | **O(1)** |

- Efficient due to small constraints (`n ≤ 50`)

---

## ✅ Java Implementation

```java
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     int n = scanner.nextInt();
     int m = scanner.nextInt();

     // Cost of one full round
     int fullRoundCost = n * (n + 1) / 2;

     // Remaining chips after full rounds
     m %= fullRoundCost;

     // Simulate the last partial round
     for (int i = 1; i <= n; i++) {
         if (m >= i) {
             m -= i;
         } else {
             break;
         }
     }

     System.out.println(m);
     scanner.close();
 }
}
