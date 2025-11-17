# 🟥 B. Martian Architecture – Codeforces Practice

This is my solution for the **Martian Architecture** problem from Codeforces.  
This README explains the **problem logic, insights, and full Java implementation**.

---

## 📄 Problem Summary

A Martian "Road to the Sun" is described by multiple **stairway constructions**, each defined by:

- `a` — starting cell  
- `b` — ending cell  
- `c` — number of stones added at cell `a`  

A stairway adds stones as follows:

- Cell `a` gets **c** stones  
- Cell `a + 1` gets **c + 1** stones  
- Cell `a + 2` gets **c + 2** stones  
- …  
- Cell `b` gets **c + (b − a)** stones  

If the cell already had stones before, they **do not matter**. We only accumulate the contributions of all stairways.

We are given `k` specific cells of interest.  
Our goal → **Compute the total number of stones across all queried cells**.

---

## 💡 Approach

Since:

- `m ≤ 100,000`  
- `k ≤ 100`  

We can efficiently evaluate each queried cell by scanning all stairways.

### 🔑 For each query cell:

For every road `(a, b, c)`:

- If `a ≤ cell ≤ b`, it contributes  
  `c + (cell - a)` stones.

So the solution is:

- for each query cell:
- for each stairway:
- if within range → accumulate stones
- sum all results

This results in at most `100 × 100000 = 10^7` operations — perfect for the time limit.

---

## 🖥️ Implementation (Java)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    static class Road {
        int a, b, c;

        public Road(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        Road[] roads = new Road[m];
        for (int i = 0; i < m; i++) {
            roads[i] = new Road(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        long totalStonesSum = 0;

        for (int i = 0; i < k; i++) {
            int queryCell = sc.nextInt();
            long stonesInThisCell = 0;

            for (int j = 0; j < m; j++) {
                Road road = roads[j];
                if (queryCell >= road.a && queryCell <= road.b) {
                    stonesInThisCell += (road.c + queryCell - road.a);
                }
            }
            totalStonesSum += stonesInThisCell;
        }

        out.println(totalStonesSum);
        out.flush();
        out.close();
    }

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(m × k)`
- **Space Complexity:** `O(m)`
