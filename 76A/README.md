# 🎁 A. Gift

## 📅 Codeforces Daily Problem   

---

## 🧩 Problem Overview

The kingdom of **Olympia** has:
- **N cities**
- **M bidirectional roads**

Each road has bandits demanding a **minimum number of gold and silver coins** to stop robberies.

The king wants to prepare **one single gift** (same gold & silver for all roads) such that:
- For **every pair of cities**, there exists a **safe path**
- A road is safe if  
  `gift_gold ≥ gi` **and** `gift_silver ≥ si`

Each gold coin costs **G tugriks**, and each silver coin costs **S tugriks**.

---

## 🎯 Objective

Find the **minimum possible cost** of the gift so that the graph becomes **fully connected using only safe roads**.

If it’s impossible, output `-1`.

---

## 🧠 Key Insight

- Choosing a gift `(gold, silver)` allows **only roads with requirements ≤ that gift**
- The chosen roads must form a **spanning tree**
- Total cost =  `gold * G + silver * S`
- We must **minimize the maximum gold and silver used in the spanning tree**

This is a **bi-criteria MST problem**.

---

## 🧠 Strategy

1. **Sort roads by gold requirement (`g`)**
2. Gradually include roads in increasing `g`
3. For the current set:
 - Sort by silver requirement (`s`)
 - Build MST using **DSU**
 - Track the **maximum silver used**
4. If MST is complete:
 - Compute cost
 - Update minimum answer
5. Repeat for all gold thresholds

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|------------|
| **Time Complexity** | `O(M log M)` |
| **Space Complexity** | `O(M + N)` |

Efficient enough for constraints.

---

## 💻 Java Implementation

```java
import java.io.*;
import java.util.*;

public class Main {
  
  static class Edge {
      int u, v;
      long g, s;
      
      Edge(int u, int v, long g, long s) {
          this.u = u;
          this.v = v;
          this.g = g;
          this.s = s;
      }
  }
  
  static class DSU {
      int[] parent;
      
      DSU(int n) {
          parent = new int[n + 1];
          for (int i = 1; i <= n; i++)
              parent[i] = i;
      }
      
      int find(int x) {
          if (parent[x] != x)
              parent[x] = find(parent[x]);
          return parent[x];
      }
      
      boolean union(int a, int b) {
          a = find(a);
          b = find(b);
          if (a == b) return false;
          parent[a] = b;
          return true;
      }
  }

  public static void main(String[] args) {
      FastReader sc = new FastReader();
      
      int n = sc.nextInt();
      int m = sc.nextInt();
      long G = sc.nextLong();
      long S = sc.nextLong();
      
      Edge[] edges = new Edge[m];
      for (int i = 0; i < m; i++)
          edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextLong(), sc.nextLong());
      
      Arrays.sort(edges, Comparator.comparingLong(e -> e.g));
      
      ArrayList<Edge> active = new ArrayList<>();
      long answer = -1;
      
      for (Edge e : edges) {
          active.add(e);
          active.sort(Comparator.comparingLong(x -> x.s));
          
          DSU dsu = new DSU(n);
          long maxSilver = 0;
          int used = 0;
          ArrayList<Edge> next = new ArrayList<>();
          
          for (Edge cur : active) {
              if (dsu.union(cur.u, cur.v)) {
                  next.add(cur);
                  maxSilver = Math.max(maxSilver, cur.s);
                  used++;
              }
          }
          
          active = next;
          
          if (used == n - 1) {
              long cost = e.g * G + maxSilver * S;
              if (answer == -1 || cost < answer)
                  answer = cost;
          }
      }
      
      System.out.println(answer);
  }
  
  static class FastReader {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      String next() {
          while (st == null || !st.hasMoreTokens()) {
              try {
                  String line = br.readLine();
                  if (line == null) return null;
                  st = new StringTokenizer(line);
              } catch (IOException e) {
                  return null;
              }
          }
          return st.nextToken();
      }
      
      int nextInt() { return Integer.parseInt(next()); }
      long nextLong() { return Long.parseLong(next()); }
  }
}
