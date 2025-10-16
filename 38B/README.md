# ♞ Chess – Codeforces Practice

This is my solution for the **Chess** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

- A standard **8×8 chessboard** contains:
  - One **rook** 🏰 and  
  - One **knight** 🐴 — placed in known positions.  
- It is guaranteed that **neither of them attacks the other**.

You must determine how many ways a **new knight** can be placed on the board such that:
- None of the **three pieces** attack each other.
- The new knight must be placed on an **empty, non-attacked square**.

---

## 💡 Approach

1. **Map chess positions to indices:**
   - Columns `a–h` → indices `0–7`.
   - Rows `1–8` → indices `0–7`.

2. **Mark unsafe squares:**
   - Mark the rook’s position and the knight’s position as unsafe.  
   - For the rook:
     - Mark all cells in its **row and column**.  
   - For each knight:
     - Mark all cells that can be attacked using the **knight’s L-shaped moves**.

3. **Count valid cells:**
   - Traverse the 8×8 grid.
   - Count all cells that remain **unmarked** (i.e., safe for the new knight).

---

## 🧠 Key Idea

This problem is purely **simulation-based**.  
By iterating through all cells and marking attacked squares, we can easily count the safe positions.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {

    static final int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.next();
        int rR = s1.charAt(1) - '1';
        int rC = s1.charAt(0) - 'a';

        String s2 = in.next();
        int kR = s2.charAt(1) - '1';
        int kC = s2.charAt(0) - 'a';

        boolean[][] bad = new boolean[8][8];

        // Mark the positions of the rook and knight
        bad[rR][rC] = true;
        bad[kR][kC] = true;

        // Mark rook's attack path
        for (int i = 0; i < 8; i++) {
            bad[rR][i] = true;
            bad[i][rC] = true;
        }

        // Mark knight attack paths
        markKnight(bad, rR, rC);
        markKnight(bad, kR, kC);

        // Count all safe cells
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!bad[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
        in.close();
    }

    private static void markKnight(boolean[][] grid, int r, int c) {
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) {
                grid[nr][nc] = true;
            }
        }
    }
}
```

## ✅ Complexity

- **Time Complexity:** O(64) 
- **Space Complexity:** O(64)  
