# 🧩 Cutting Jigsaw Puzzle – Codeforces Practice

This is my solution for the **Cutting Jigsaw Puzzle** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

The Hedgehog wants to cut his picture of size **A × B** into small rectangular pieces of equal size **X × Y**.  
Each cut must satisfy:

1. **A is divisible by X** and **B is divisible by Y**.  
2. Every puzzle piece must be **unique**, even when rotations (90°, 180°, 270°) are considered.  
3. The goal is to find:
   - The **number of good puzzles** (valid `(X, Y)` pairs).  
   - The **smallest good puzzle piece** by area (and by height `X` in case of ties).

---

## 💡 Approach

1. **Brute-force all divisors:**  
   - Loop over all `X` that divide `A` and all `Y` that divide `B`.  
   - For each pair `(X, Y)`, check if it forms a *good puzzle*.

2. **Checking uniqueness (`isGood`):**
   - Slice the picture into tiles of size `X × Y`.  
   - Store each tile’s *canonical representation* (the smallest string among its rotations).  
   - If any two tiles match, the puzzle is **not good**.

3. **Canonical representation:**
   - Generate up to 4 rotations (0°, 90°, 180°, 270°).  
   - Pick the lexicographically smallest string as the tile’s canonical form.

4. **Track best puzzle:**
   - Count total valid puzzles.
   - Track the smallest `(X, Y)` by **area**, and by **height** if areas are equal.

---

## 🖥️ Implementation (Java)

```java
import java.util.*;
public class Main {
    static char[][] grid;
    static int A, B;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            A = in.nextInt();
            B = in.nextInt();
            grid = new char[A][B];
            for (int i = 0; i < A; i++) grid[i] = in.next().toCharArray();

            int count = 0, minX = A, minY = B, minArea = Integer.MAX_VALUE;

            for (int x = 1; x <= A; x++) {
                if (A % x != 0) continue;
                for (int y = 1; y <= B; y++) {
                    if (B % y != 0) continue;
                    if (isGood(x, y)) {
                        count++;
                        int area = x * y;
                        if (area < minArea || (area == minArea && x < minX)) {
                            minArea = area;
                            minX = x;
                            minY = y;
                        }
                    }
                }
            }

            System.out.println(count);
            System.out.println(minX + " " + minY);
        }
    }

    private static boolean isGood(int x, int y) {
        Set<String> pieces = new HashSet<>();
        for (int i = 0; i < A; i += x)
            for (int j = 0; j < B; j += y) {
                char[][] piece = new char[x][y];
                for (int r = 0; r < x; r++)
                    for (int c = 0; c < y; c++)
                        piece[r][c] = grid[i + r][j + c];
                if (!pieces.add(getCanonical(piece, x, y))) return false;
            }
        return true;
    }

    private static String getCanonical(char[][] p, int h, int w) {
        String[] rots = new String[4];
        rots[0] = stringify(p, h);
        rots[1] = stringify(rotate180(p, h, w), h);
        if (h == w) {
            rots[2] = stringify(rotate90(p, h, w), w);
            rots[3] = stringify(rotate180(rotate90(p, h, w), w, h), w);
        } else {
            rots[2] = rots[3] = "~";
        }
        Arrays.sort(rots);
        return rots[0];
    }

    private static String stringify(char[][] g, int h) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < h; r++) sb.append(g[r]);
        return sb.toString();
    }

    private static char[][] rotate90(char[][] g, int h, int w) {
        char[][] res = new char[w][h];
        for (int r = 0; r < h; r++)
            for (int c = 0; c < w; c++)
                res[c][h - 1 - r] = g[r][c];
        return res;
    }

    private static char[][] rotate180(char[][] g, int h, int w) {
        char[][] res = new char[h][w];
        for (int r = 0; r < h; r++)
            for (int c = 0; c < w; c++)
                res[h - 1 - r][w - 1 - c] = g[r][c];
        return res;
    }
}
```
---
## ✅ Complexity

- **Time Complexity:** `O((A * B) * D(A) * D(B))`
  - Where `D(A)` and `D(B)` are the number of divisors of A and B.
  - Efficient since `A, B ≤ 20`. 
- **Space Complexity:** `O(A * B)`
  - For storing the grid and temporary puzzle pieces.    
