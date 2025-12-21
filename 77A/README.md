# 📌 A. Heroes

## 📅 Problem of the Day — Codeforces  

---

## 📝 Problem Summary

Seven legendary heroes must defeat **three megabosses** in the year 2012:

- **Mephisto** → experience `a`
- **Diablo** → experience `b`
- **Baal** → experience `c`

The heroes must split into **exactly three non-empty teams**, each team fighting one megaboss.

Each hero in a team of size `y` that defeats a boss with experience `x` receives: `⌊ x / y ⌋  (integer division)`

Additionally, heroes may **like** other heroes.  
If hero `p` likes hero `q` and both are in the same team, it contributes **+1 liking**  
(Liking is **directed**, mutual liking counts twice).

---

## 🎯 Objective

You must determine a team division such that:

1. **The difference between the maximum and minimum experience received by any hero is minimized**
2. Among all such optimal divisions, **the total amount of liking within teams is maximized**

---

## 🧠 Key Observations

- There are only **7 heroes**
- Each hero can join **one of 3 teams**
- Total possible team assignments: `3⁷ = 2187`
- This allows a **complete brute-force solution**
- A team is valid only if **all three teams are non-empty**
- Liking is **directional** and must be counted carefully

---

## 🧠 Approach

1. Assign each hero to one of the three teams using **backtracking**
2. For every complete assignment:
 - Ensure all three teams are non-empty
 - Compute experience received by heroes in each team
 - Calculate:
   ```
   difference = maxExperience − minExperience
   ```
 - Count total liking inside teams using an adjacency matrix
3. Track:
 - Minimum experience difference
 - Maximum liking for that difference

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(3⁷ × 7²)` |
| **Space Complexity** | `O(1)` |

> All values are constants, making the solution extremely fast.

---

## 💻 Java Implementation

```java
import java.util.*;

public class Main {
  static Map<String, Integer> map = new HashMap<>();
  static boolean[][] adj = new boolean[7][7];
  static int[] teams = new int[7];
  static long A, B, C;
  static long minDiff = Long.MAX_VALUE;
  static int maxLiking = -1;

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      String[] names = {
          "Anka", "Chapay", "Cleo",
          "Troll", "Dracul", "Snowy", "Hexadecimal"
      };

      for (int i = 0; i < 7; i++) {
          map.put(names[i], i);
      }

      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
          String u = sc.next();
          sc.next(); // "likes"
          String v = sc.next();
          adj[map.get(u)][map.get(v)] = true;
      }

      A = sc.nextLong();
      B = sc.nextLong();
      C = sc.nextLong();

      dfs(0);

      System.out.println(minDiff + " " + maxLiking);
  }

  static void dfs(int idx) {
      if (idx == 7) {
          int[] cnt = new int[3];
          for (int t : teams) cnt[t]++;

          if (cnt[0] == 0 || cnt[1] == 0 || cnt[2] == 0) return;

          long e0 = A / cnt[0];
          long e1 = B / cnt[1];
          long e2 = C / cnt[2];

          long max = Math.max(e0, Math.max(e1, e2));
          long min = Math.min(e0, Math.min(e1, e2));
          long diff = max - min;

          int liking = 0;
          for (int i = 0; i < 7; i++) {
              for (int j = 0; j < 7; j++) {
                  if (i != j && teams[i] == teams[j] && adj[i][j]) {
                      liking++;
                  }
              }
          }

          if (diff < minDiff) {
              minDiff = diff;
              maxLiking = liking;
          } else if (diff == minDiff) {
              maxLiking = Math.max(maxLiking, liking);
          }
          return;
      }

      for (int i = 0; i < 3; i++) {
          teams[idx] = i;
          dfs(idx + 1);
      }
  }
}  
