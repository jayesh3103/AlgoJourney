# 🧩 African Crossword (Codeforces – Problem B)

## 📌 Problem Overview

An **African crossword** is an `n × m` grid of lowercase letters.  
Your task is to **decode the hidden word** by following these rules:

### 🔍 Rules
- A letter must be **crossed out** if it appears **more than once** in:
  - its **row**, or
  - its **column**
- All repeated letters are removed **simultaneously**
- The remaining letters are read:
  - **Top to bottom**
  - **Left to right** (within the same row)

The resulting sequence of letters forms the encrypted word.

---

## 🧠 Key Insight

A letter at position `(i, j)` should be **kept** if and only if:
- It appears **exactly once** in row `i`
- It appears **exactly once** in column `j`

To achieve this efficiently:
- Count character frequencies for each **row**
- Count character frequencies for each **column**
- Append only valid letters in traversal order

---

## ✅ Approach

1. Read the grid
2. Maintain:
   - `rowCounts[n][26]`
   - `colCounts[m][26]`
3. Traverse the grid again:
   - Keep a letter if its row count and column count are both `1`
4. Build the answer using `StringBuilder`

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }

        int[][] rowCounts = new int[n][26];
        int[][] colCounts = new int[m][26];

        // Count frequencies in rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int idx = grid[i][j] - 'a';
                rowCounts[i][idx]++;
                colCounts[j][idx]++;
            }
        }

        StringBuilder result = new StringBuilder();

        // Collect valid characters
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int idx = grid[i][j] - 'a';
                if (rowCounts[i][idx] == 1 && colCounts[j][idx] == 1) {
                    result.append(grid[i][j]);
                }
            }
        }

        System.out.println(result.toString());
        sc.close();
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n × m)`
- **Space Complexity:** `O(n × 26 + m × 26)`
