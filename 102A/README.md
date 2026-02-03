# 👕 A. Clothes — Codeforces

## 🧩 Problem Overview

Gerald wants to buy **exactly three clothing items** from a shop such that:

- Every pair among the three items **matches each other**
- The **total price is minimum**
- If no such triple exists, output `-1`

The shop provides:
- `n` clothing items
- `m` matching pairs
- Each item has a price

Matching is **pairwise** — for three items `(a, b, c)` to be valid, all of the following must hold:
- `a` matches `b`
- `b` matches `c`
- `a` matches `c`

---

## 📥 Input Format

1. Two integers `n` and `m` — number of items and matching pairs  
2. `n` integers — prices of the clothing items  
3. `m` lines — each line contains a pair `(u, v)` indicating that item `u` matches item `v`

---

## 📤 Output Format

- Print the **minimum possible sum** of prices of three mutually matching items  
- If no such triple exists, print:

-1

---

## 🔍 Key Observations

- The problem reduces to finding a **triangle** in an undirected graph
- Each node = clothing item
- Each edge = matching relation
- Triangle `(u, v, w)` exists if:
  - `(u, v)`, `(v, w)`, `(u, w)` are all edges
- Among all such triangles, choose the one with **minimum price sum**

---

## 🧠 Approach

1. Store prices in an array
2. Use a boolean adjacency matrix to store matching relations
3. Iterate over all matching pairs `(u, v)`
4. For each third item `w`, check:
   - `u` matches `w`
   - `v` matches `w`
5. Track the minimum sum found

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|------------|
| Time | **O(m · n)** |
| Space | **O(n²)** |

- `n ≤ 100` in original constraints → adjacency matrix is acceptable

---

## ✅ Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] prices = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prices[i] = scanner.nextInt();
        }

        boolean[][] isConnected = new boolean[n + 1][n + 1];
        int[] uArr = new int[m];
        int[] vArr = new int[m];

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            isConnected[u][v] = true;
            isConnected[v][u] = true;
            uArr[i] = u;
            vArr[i] = v;
        }

        int minSum = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < m; i++) {
            int u = uArr[i];
            int v = vArr[i];

            for (int w = 1; w <= n; w++) {
                if (w == u || w == v) continue;
                if (isConnected[u][w] && isConnected[v][w]) {
                    int sum = prices[u] + prices[v] + prices[w];
                    minSum = Math.min(minSum, sum);
                    found = true;
                }
            }
        }

        System.out.println(found ? minSum : -1);
        scanner.close();
    }
}
