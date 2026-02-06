# 🐙 B. Cthulhu — Codeforces

## 🌊 Story Background

From space, **Cthulhu** looks like:
- A **simple cycle** (the body)
- With **trees attached** to some or all cycle vertices (the tentacles)
- The cycle must contain **at least 3 vertices**

Formally, the graph must be:
- **Connected**
- **Undirected**
- Contain **exactly one simple cycle**
- No self-loops or multiple edges

---

## 🎯 Problem Objective

Given an undirected graph with:
- `n` vertices
- `m` edges

Determine whether the graph can be considered **Cthulhu**.

### Output
- `"FHTAGN!"` → if the graph **is** Cthulhu  
- `"NO"` → otherwise

---

## 🔍 Key Observations

For a connected undirected graph:
- A **tree** has `n - 1` edges
- A graph with **exactly one cycle** has `n` edges

So, a graph is **Cthulhu** if and only if:
1. `m == n` → exactly one cycle
2. The graph is **connected**

No further checks are needed because:
- Trees can freely hang off the cycle
- The problem guarantees no multi-edges or self-loops

---

## 🧠 Strategy

1. Read `n` and `m`
2. If `m != n` → print `"NO"`
3. Build adjacency list
4. Run DFS from any node
5. If all nodes are visited → `"FHTAGN!"`
6. Otherwise → `"NO"`

---

## 📥 Input Format

- Two integers `n`, `m`
- Followed by `m` edges `u v`

---

## 📤 Output Format

- `"FHTAGN!"` if the graph is Cthulhu
- `"NO"` otherwise

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| Time | **O(n + m)** |
| Space | **O(n + m)** |

Efficient for `n ≤ 100`.

---

## ✅ Java Implementation

```java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // Cthulhu must have exactly one cycle
        if (m != n) {
            System.out.println("NO");
            return;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(1, adj, visited);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("FHTAGN!");
    }

    private static void dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
}
