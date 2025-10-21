# 🎨 Repaintings – Codeforces Practice

This is my solution for the **Repaintings** problem from Codeforces.  
This README explains my **approach, reasoning, and implementation** for solving it efficiently.

---

## 📄 Problem Description

You are given an **n × m chessboard**, where the **top-left square is black**.  
At **minute 0**, all **black squares** are painted **color 0**.

Then, for every minute `i ≥ 1`:
- We **repaint** to color `i` all **initially black squares** that have **exactly four corner-adjacent squares** painted `(i-1)`.

This process continues infinitely.  
You must determine **how many squares will be repainted exactly `x` times**.

Two squares are *corner-adjacent* if they share exactly one corner (diagonal adjacency).

---

## 🧩 Example Illustration

For a `3 × 3` chessboard:

| Step | Painted Cells (Black Squares Only) | Explanation |
|------|-------------------------------------|--------------|
| 0 | 5 black squares painted color 0 | Normal chessboard pattern |
| 1 | 4 black squares repainted | The central 4 black squares now have 4 diagonal neighbors |
| 2 | 1 black square repainted | The very center is painted again |
| 3 | No further repainting | Process stops |

---

## 💡 Approach

1. **Understanding the pattern:**
   - At each minute `i`, repainting occurs only on **initially black squares** inside a shrinking board.
   - Each new layer of repainting is **offset inward by 2 cells** on each side.

2. **Mathematical observation:**
   - The board shrinks by `2 × (x - 1)` cells for the x-th iteration.
   - Compute how many **initially black squares** remain inside this reduced region.

3. **Count of black squares:**
   - For any rectangular region of size `h × w`,  
     the number of black squares depends on the parity of `(row + column)` of the top-left corner.
   - Formula:
     ```
     if (r + c) % 2 == 0 → (total + 1) / 2
     else → total / 2
     ```
     where `total = h × w`.

4. **Compute difference:**
   - Squares repainted **exactly x times** =  
     Black squares in the `(x-1)` layer − Black squares in the `x` layer.

5. **Edge cases:**
   - When board dimensions become ≤ 0 → no further repainting possible.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {

    private static long countBlack(long h, long w, long r, long c) {
        if (h <= 0 || w <= 0) {
            return 0;
        }
        long total = h * w;
        if ((r + c) % 2 == 0) {
            return (total + 1) / 2;
        } else {
            return total / 2;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        long x = in.nextLong();

        long h1 = n - 2 * (x - 1);
        long w1 = m - 2 * (x - 1);
        long count1 = countBlack(h1, w1, x - 1, x - 1);

        long h2 = n - 2 * x;
        long w2 = m - 2 * x;
        long count2 = countBlack(h2, w2, x, x);

        System.out.println(count1 - count2);
        in.close();
    }
}

```
---

## ✅ Complexity

- **Time Complexity:** `O(1)` 
- **Space Complexity:** `O(1)`
