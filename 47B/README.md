# 💰 B. Coins — Codeforces Practice

This is my solution for the **B. Coins** problem from Codeforces.  
This README explains the **approach, thought process, and final implementation** in detail.

---

## 📄 Problem Description

Vasya found **three mysterious coins** 💰 — `A`, `B`, and `C`.  
He didn’t know their denominations, but he assumed that **heavier coins are worth more**.

He used a **pan balance** and performed **three weighings**, one for every pair of coins.  
Each result is written as:

> `A>B` → means **A is heavier than B**  
> `A<B` → means **A is lighter than B**

Your task is to determine:
- The **increasing order of coin weights**, or  
- Print **"Impossible"** if the results are **contradictory** (i.e., logically inconsistent).

---

## 💡 Approach

1. **Assign Scores to Each Coin**
 - Each coin gets a "score" that represents how many other coins it is heavier than.
 - For example:
   - If `A > B`, increment A’s score.
   - If `A < B`, increment B’s score.

2. **After All Comparisons**
 - The coin with the **lowest score** is the **lightest**.
 - The coin with the **highest score** is the **heaviest**.

3. **Check for Contradictions**
 - If two coins end up with the **same score**, then the results are **impossible**, because no two coins can have equal weights.

4. **Form the Result**
 - Based on scores (0 → lightest, 1 → middle, 2 → heaviest), build the final string order.

---

## 🧠 Core Idea

> “Comparisons define relative rank — the score acts as a measure of weight dominance.”

By tracking how many coins each coin is heavier than,  
we can infer the complete ordering, unless contradictions exist.

---

## 🖥️ Java Implementation

```java
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
      try (Scanner in = new Scanner(System.in)) {
          Map<Character, Integer> scores = new HashMap<>();
          scores.put('A', 0);
          scores.put('B', 0);
          scores.put('C', 0);

          for (int i = 0; i < 3; i++) {
              String s = in.next();
              char c1 = s.charAt(0);
              char op = s.charAt(1);
              char c2 = s.charAt(2);

              if (op == '>') {
                  scores.put(c1, scores.get(c1) + 1);
              } else {
                  scores.put(c2, scores.get(c2) + 1);
              }
          }

          int scoreA = scores.get('A');
          int scoreB = scores.get('B');
          int scoreC = scores.get('C');

          if (scoreA == scoreB || scoreB == scoreC || scoreA == scoreC) {
              System.out.println("Impossible");
          } else {
              char[] res = new char[3];
              res[scoreA] = 'A';
              res[scoreB] = 'B';
              res[scoreC] = 'C';
              System.out.println(new String(res));
          }
      }
  }
}
```
---
## ✅Complexity
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`
