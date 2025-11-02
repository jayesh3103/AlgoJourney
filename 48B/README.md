# 🌿 Land Lot — Codeforces Problem

---

## 🧩 Problem Overview

Vasya owns a rectangular garden of size **n × m** represented as a grid.  
Each cell in the grid can either:
- `1` — contain a **tree**, or  
- `0` — be **empty**.  

He wants to build a **house** of size **a × b**, and the house can be placed **either orientation** — that is, it can occupy:
- `a × b` cells, or  
- `b × a` cells.

However, any trees growing on the selected lot must be **chopped**.  
Your mission: help Vasya choose the **optimal lot location** so that **the number of trees cut down is minimized.**

---
---

## 🧠 Core Idea

Let’s decode the logic step by step:

1. **Brute Force but Smartly Done:**  
   Try placing the house (a×b or b×a) at every possible top-left corner inside the garden.

2. **Count Trees:**  
   For each possible placement, sum the number of `1`s (trees) within the house’s area.

3. **Track Minimum:**  
   Keep track of the smallest number of trees encountered — that’s our answer.

4. **Handle Both Orientations:**  
   Since the house can rotate (a×b or b×a), evaluate both if applicable.

5. **Output the Optimal Cut:**  
   Print the smallest value obtained.

---

## 💻 Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();
            
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = in.nextInt();
                }
            }
            
            int a = in.nextInt();
            int b = in.nextInt();
            
            int minTrees = Integer.MAX_VALUE;
            
            if (a <= n && b <= m) {
                for (int r = 0; r <= n - a; r++) {
                    for (int c = 0; c <= m - b; c++) {
                        int currentTrees = 0;
                        for (int i = r; i < r + a; i++) {
                            for (int j = c; j < c + b; j++) {
                                currentTrees += grid[i][j];
                            }
                        }
                        minTrees = Math.min(minTrees, currentTrees);
                    }
                }
            }
            
            if (a != b && b <= n && a <= m) {
                for (int r = 0; r <= n - b; r++) {
                    for (int c = 0; c <= m - a; c++) {
                        int currentTrees = 0;
                        for (int i = r; i < r + b; i++) {
                            for (int j = c; j < c + a; j++) {
                                currentTrees += grid[i][j];
                            }
                        }
                        minTrees = Math.min(minTrees, currentTrees);
                    }
                }
            }
            
            System.out.println(minTrees);
        }
    }
}
```
---

## ✅ Complexity
- **Time Complexity:** `O(n × m × a × b)`
- **Space Complexity:** `O(n × m)`
