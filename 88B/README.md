# ⌨️ B. Keyboard

## 🧩 Problem Summary
Vasya is learning to type using a **rectangular keyboard** of size `n × m`.  
Each key is either:
- a **lowercase letter** (`a–z`), or
- a **Shift key** (`S`) used to type uppercase letters.

### Typing Rules
- Vasya normally types with **one hand**.
- He can press **two keys with one hand** only if the **Euclidean distance** between their centers is **≤ x**.
- To type an **uppercase letter**, Vasya must press:
  - the letter key + a `Shift` key.
- If no suitable `Shift` key is close enough, he must use his **other hand**.
- If a character **cannot be typed at all**, output `-1`.

### Goal
If the text can be typed, output the **minimum number of times** Vasya needs to use his other hand.

---

## 💡 Approach Used

### 1️⃣ Store Keyboard Positions
- Store positions of each lowercase letter (`a–z`) in a list.
- Store all `Shift (S)` key positions separately.
- Treat keys as grid points `(row, column)`.

### 2️⃣ Precompute Reachability
For each letter:
- Check whether **any occurrence** of that letter is within distance `x` from **any Shift key**.
- If yes → that letter can be typed **with one hand** when uppercase.
- Use **squared distance** to avoid unnecessary square roots:

(r1 - r2)² + (c1 - c2)² ≤ x²

### 3️⃣ Process the Text
For each character in the text:
- **Lowercase letter**
- Must exist on the keyboard.
- **Uppercase letter**
- Corresponding lowercase key must exist.
- At least one Shift key must exist.
- If no Shift is reachable → use other hand (count +1).

If any character is impossible to type → output `-1`.

---

## 🧪 Key Observations
- Keyboard size is small (`≤ 30 × 30`), so brute-force distance checks are feasible.
- Text length is large (`≤ 5 × 10⁵`), so **precomputation is crucial**.
- Greedy counting works because each uppercase letter is independent.

---

## 💻 Implementation (Java)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static class Point {
      int r, c;
      Point(int r, int c) {
          this.r = r;
          this.c = c;
      }
  }

  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      
      List<Point>[] letterPositions = new ArrayList[26];
      for (int i = 0; i < 26; i++) {
          letterPositions[i] = new ArrayList<>();
      }
      List<Point> shifts = new ArrayList<>();
      
      for (int i = 0; i < n; i++) {
          String row = br.readLine();
          for (int j = 0; j < m; j++) {
              char c = row.charAt(j);
              if (c == 'S') {
                  shifts.add(new Point(i, j));
              } else {
                  letterPositions[c - 'a'].add(new Point(i, j));
              }
          }
      }
      
      int q = Integer.parseInt(br.readLine());
      String text = br.readLine();
      
      boolean[] canTypeOneHand = new boolean[26];
      int xSq = x * x;
      
      for (int i = 0; i < 26; i++) {
          if (!letterPositions[i].isEmpty() && !shifts.isEmpty()) {
              for (Point p : letterPositions[i]) {
                  for (Point s : shifts) {
                      int dr = p.r - s.r;
                      int dc = p.c - s.c;
                      if (dr * dr + dc * dc <= xSq) {
                          canTypeOneHand[i] = true;
                          break;
                      }
                  }
                  if (canTypeOneHand[i]) break;
              }
          }
      }
      
      int otherHandCount = 0;
      
      for (int i = 0; i < q; i++) {
          char c = text.charAt(i);
          
          if (Character.isLowerCase(c)) {
              if (letterPositions[c - 'a'].isEmpty()) {
                  System.out.println("-1");
                  return;
              }
          } else {
              int idx = c - 'A';
              if (letterPositions[idx].isEmpty() || shifts.isEmpty()) {
                  System.out.println("-1");
                  return;
              }
              if (!canTypeOneHand[idx]) {
                  otherHandCount++;
              }
          }
      }
      
      System.out.println(otherHandCount);
  }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n × m)`
