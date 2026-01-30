---

## 🧮 Algorithm Outline

1. Count occurrences of each color
2. Generate all **24 cube rotations** as permutations
3. For each permutation:
 - Decompose into **cycles**
 - Assign colors to cycles respecting available counts
4. Sum valid assignments
5. Divide by **24**

---

## ⏱️ Complexity

| Aspect | Value |
|----|----|
| Rotations | 24 |
| Faces | 6 |
| Time | O(24 × small backtracking) |
| Space | O(1) |

Efficient and well within constraints.

---

## ✅ Java Implementation

```java
import java.util.*;
import java.io.*;

public class Main {
  static List<int[]> perms = new ArrayList<>();
  static int n = 6;

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      if (!sc.hasNext()) return;
      String s = sc.next();

      Map<Character, Integer> map = new HashMap<>();
      for (char c : s.toCharArray()) {
          map.put(c, map.getOrDefault(c, 0) + 1);
      }

      int[] counts = new int[map.size()];
      int idx = 0;
      for (int v : map.values()) counts[idx++] = v;

      generatePermutations();

      long total = 0;
      for (int[] p : perms) {
          List<Integer> cycles = getCycles(p);
          total += solve(0, cycles, counts);
      }

      System.out.println(total / 24);
  }

  static long solve(int idx, List<Integer> cycles, int[] counts) {
      if (idx == cycles.size()) return 1;
      long res = 0;
      int len = cycles.get(idx);

      for (int i = 0; i < counts.length; i++) {
          if (counts[i] >= len) {
              counts[i] -= len;
              res += solve(idx + 1, cycles, counts);
              counts[i] += len;
          }
      }
      return res;
  }

  static List<Integer> getCycles(int[] p) {
      boolean[] vis = new boolean[n];
      List<Integer> res = new ArrayList<>();
      for (int i = 0; i < n; i++) {
          if (!vis[i]) {
              int cur = i, len = 0;
              while (!vis[cur]) {
                  vis[cur] = true;
                  cur = p[cur];
                  len++;
              }
              res.add(len);
          }
      }
      return res;
  }

  static void generatePermutations() {
      int[] id = {0,1,2,3,4,5};
      perms.add(id);

      int[] rX = {0,1,5,4,2,3};
      int[] rY = {4,5,2,3,1,0};

      Queue<int[]> q = new LinkedList<>();
      q.add(id);

      Set<String> seen = new HashSet<>();
      seen.add(Arrays.toString(id));

      int[][] bases = {rX, rY};

      while (!q.isEmpty()) {
          int[] cur = q.poll();
          for (int[] b : bases) {
              int[] next = new int[n];
              for (int i = 0; i < n; i++) next[i] = cur[b[i]];
              String key = Arrays.toString(next);
              if (seen.add(key)) {
                  perms.add(next);
                  q.add(next);
              }
          }
      }
  }
}
