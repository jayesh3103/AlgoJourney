# 📐 Right Triangles – Codeforces Practice

This is my solution for the **Right Triangles** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

- You are given an **n × m** grid consisting of:
  - `'*'` (representing marked cells)
  - `'.'` (representing empty cells)
- You need to **count the number of right triangles** whose:
  - Vertices are at the centers of `'*'` cells.
  - Two sides are **parallel to the grid sides**.

Each triangle must have one **right angle** formed by the intersection of horizontal and vertical sides.

---

## 💡 Approach

1. **Precompute counts:**  
   - Maintain two arrays:
     - `rowCounts[r]` = number of `'*'` in row `r`
     - `colCounts[c]` = number of `'*'` in column `c`

2. **Iterate through every cell:**  
   - For each cell `(r, c)` containing a `'*'`, it can serve as a **right angle vertex**.

3. **Count triangles for each `'*'`:**  
   - Possible horizontal extensions = `rowCounts[r] - 1`
   - Possible vertical extensions = `colCounts[c] - 1`
   - Number of right triangles with this vertex = `(rowCounts[r] - 1) × (colCounts[c] - 1)`

4. **Sum up results:**  
   - Total number of right triangles = Σ over all `'*'` cells of `(rowCounts[r] - 1) × (colCounts[c] - 1)`

> This approach efficiently counts triangles using precomputation — reducing the problem to a clean combinatorial formula.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();
            
            char[][] grid = new char[n][m];
            int[] rowCounts = new int[n];
            int[] colCounts = new int[m];
            
            for (int r = 0; r < n; r++) {
                String line = in.next();
                for (int c = 0; c < m; c++) {
                    grid[r][c] = line.charAt(c);
                    if (grid[r][c] == '*') {
                        rowCounts[r]++;
                        colCounts[c]++;
                    }
                }
            }
            
            long total = 0;
            
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (grid[r][c] == '*') {
                        long inRow = rowCounts[r] - 1;
                        long inCol = colCounts[c] - 1;
                        total += inRow * inCol;
                    }
                }
            }
            
            System.out.println(total);
        }
    }
}
```
---
## ✅ Complexity

- **Time Complexity:** `O(n × m)` 
- **Space Complexity:** `O(n + m)`  
