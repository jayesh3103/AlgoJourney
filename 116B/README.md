# 📘 B. Little Pigs and Wolves – Codeforces

## 📝 Problem Summary

We are given an `n × m` grid:

- `"."` → empty cell  
- `"P"` → little pig  
- `"W"` → wolf  

Rules:

- A pig and wolf are **adjacent** if they share a side (up, down, left, right).
- Each pig has **at most one wolf adjacent** to it.
- Each wolf can eat **at most one pig**.
- Once a pig is eaten, it disappears.

---

## 🎯 Task

Find the **maximum number of pigs** that can be eaten.

---

## 💡 Key Insight

Since:

- Each pig has **at most one adjacent wolf**
- Each wolf can eat **only one pig**

We can greedily let every wolf:

- Check its 4 neighboring cells
- If it finds a pig → eat it
- Mark the pig as removed (`.`)
- Stop searching further

This greedy approach works because:
- No pig can be contested by multiple wolves
- The constraint guarantees no conflicts

---

## 🚀 Approach

1. Read `n` and `m`
2. Store grid
3. For each cell:
   - If it's a wolf:
     - Check 4 directions
     - If adjacent pig found:
       - Increase counter
       - Remove pig
       - Break (wolf eats only one)
4. Print total eaten pigs

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

        int eaten = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 'W') {

                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];

                        if (ni >= 0 && ni < n &&
                            nj >= 0 && nj < m &&
                            grid[ni][nj] == 'P') {

                            eaten++;
                            grid[ni][nj] = '.'; // Pig gets eaten
                            break; // Wolf eats only one pig
                        }
                    }
                }
            }
        }

        System.out.println(eaten);

        sc.close();
    }
}
