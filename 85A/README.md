# 🧩 A. Domino — 4×n Tiling with Constraints

## 📌 Problem Statement

You are given a **4 × n** rectangular grid. Your task is to tile it completely using **1 × 2 dominoes** (dominoes can be rotated).

### Constraints:
- Every cell must be covered by **exactly one domino**
- Dominoes must **not overlap**
- Each of the **n − 1 vertical cuts** between columns must intersect **at least one domino**
- Dominoes are colored using **lowercase letters (`a`–`z`)**
- Dominoes with the **same color must not be side-adjacent**
- Use **at most 26 colors**
- If no valid tiling exists, print `-1`

---

## 🧠 Key Insight

- A valid tiling **always exists for all `n ≥ 1`**
- The challenge is ensuring that **every vertical cut breaks at least one domino**
- This is achieved by:
  - Mixing **horizontal** and **vertical** placements
  - Carefully handling **odd and even values of `n`**
- Coloring is handled as a **graph coloring problem**, ensuring adjacent dominoes never share the same color

---

## 🛠️ Approach

### 1. Domino Placement Strategy
- Assign each domino a unique **ID**
- Handle **even `n`** and **odd `n`** separately:
  - Use horizontal dominoes in upper rows
  - Use vertical dominoes at strategic columns
- This guarantees:
  - Full coverage
  - Every vertical cut intersects at least one domino

### 2. Coloring Strategy
- Each domino is treated as a node
- Adjacent dominoes form edges
- Assign the **smallest available color** not used by neighbors
- This greedy coloring works since:
  - Each domino has limited neighbors
  - 26 colors are more than sufficient

---

## 💻 Implementation (Java)

```java
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            int[][] ids = new int[4][n];
            int currentId = 1;
            
            if (n % 2 == 0) {
                for (int r = 0; r <= 1; r++) {
                    for (int c = 0; c < n; c += 2) {
                        ids[r][c] = ids[r][c+1] = currentId++;
                    }
                }
                ids[2][0] = ids[3][0] = currentId++;
                ids[2][n-1] = ids[3][n-1] = currentId++;
                
                for (int c = 1; c < n - 1; c += 2) {
                    ids[2][c] = ids[2][c+1] = currentId++;
                    ids[3][c] = ids[3][c+1] = currentId++;
                }
            } else {
                ids[0][n-1] = ids[1][n-1] = currentId++; 
                for (int c = 0; c < n - 1; c += 2) {
                    ids[0][c] = ids[0][c+1] = currentId++;
                    ids[1][c] = ids[1][c+1] = currentId++;
                }
                
                ids[2][0] = ids[3][0] = currentId++; 
                for (int c = 1; c < n; c += 2) {
                    ids[2][c] = ids[2][c+1] = currentId++;
                    ids[3][c] = ids[3][c+1] = currentId++;
                }
            }
            
            char[][] result = new char[4][n];
            char[] idColor = new char[currentId]; 
            Arrays.fill(idColor, ' ');
            
            int[] dr = {0, 0, 1, -1};
            int[] dc = {1, -1, 0, 0};
            
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < n; c++) {
                    int id = ids[r][c];
                    if (idColor[id] == ' ') {
                        Set<Character> usedColors = new HashSet<>();
                        
                        for (int r2 = 0; r2 < 4; r2++) {
                            for (int c2 = 0; c2 < n; c2++) {
                                if (ids[r2][c2] == id) {
                                    for (int k = 0; k < 4; k++) {
                                        int nr = r2 + dr[k];
                                        int nc = c2 + dc[k];
                                        if (nr >= 0 && nr < 4 && nc >= 0 && nc < n) {
                                            int nid = ids[nr][nc];
                                            if (nid != id && idColor[nid] != ' ') {
                                                usedColors.add(idColor[nid]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        
                        char color = 'a';
                        while (usedColors.contains(color)) {
                            color++;
                        }
                        idColor[id] = color;
                    }
                    result[r][c] = idColor[id];
                }
            }
            
            for (int r = 0; r < 4; r++) {
                System.out.println(new String(result[r]));
            }
        }
    }
}
```
---

## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`
