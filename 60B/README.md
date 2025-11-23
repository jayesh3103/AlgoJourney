# 💧 Serial Time! – Codeforces Practice

This is my solution for the **“Serial Time!”** problem from Codeforces.  
This README explains the **problem intuition, approach, DFS logic, implementation, and complexity**.

---

## 📄 Problem Summary

Serial Guy places his dirty plate under a tap while watching a soap opera.  
The plate is a **3D grid of size `k × n × m`**, where:

- `k` = number of layers (top → bottom)  
- Each layer is an `n × m` grid  
- Cells are either:
  - `'.'` → empty (can hold water)
  - `'#'` → obstacle (blocks water)

The tap is above position **(x, y)** of the **top layer (`z = 0`)**, guaranteed to be empty.

### Water Flow Rules
- Every minute, **one unit cube of water** drops into `(x, y, 0)`.
- Water spreads to all reachable empty cells via **6-directional adjacency**:
  - Up/down between layers  
  - Left/right  
  - Forward/backward  

### 🎯 Goal
Compute the **number of minutes** until the water *fills the entire connected region* starting from `(0, x, y)`.

---

## 💡 Key Insight

This problem is essentially **counting the number of reachable empty cells** from the tap using a **DFS or BFS flood fill**.

- Each reachable empty cell gets filled in *some minute*.
- The total number of reachable cells = **time until overflow**.
- DFS is sufficient because grid size ≤ 10×10×10.

---

## 🚀 Approach

1. **Read the 3D grid** (`k` layers, each an `n×m` rectangle).
2. **Start DFS** from the tap location `(z=0, x-1, y-1)`.
3. For each visited empty cell:
   - Mark it as filled (`'#'`)
   - Increase counter
   - Recursively visit all 6 neighbors
4. Print the total number of water-filled cells.

---

## 🖥️ Java Implementation

```java
import java.util.*;

public class Main {
    static int k, n, m;
    static char[][][] grid;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();

        grid = new char[k][n][m];

        for (int z = 0; z < k; z++) {
            for (int i = 0; i < n; i++) {
                String line = sc.next();
                grid[z][i] = line.toCharArray();
            }
        }

        int startX = sc.nextInt() - 1;
        int startY = sc.nextInt() - 1;

        dfs(0, startX, startY);

        System.out.println(count);
    }

    static void dfs(int z, int x, int y) {
        if (z < 0 || z >= k || x < 0 || x >= n || y < 0 || y >= m)
            return;

        if (grid[z][x][y] == '#')
            return;

        grid[z][x][y] = '#';
        count++;

        dfs(z + 1, x, y);
        dfs(z - 1, x, y);
        dfs(z, x + 1, y);
        dfs(z, x - 1, y);
        dfs(z, x, y + 1);
        dfs(z, x, y - 1);
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(k*m*n)`
- **Space Complexity:** `O(k*m*n)`
