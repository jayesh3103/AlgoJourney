# 🏀 B. Basketball Team — Codeforces

## 📌 Problem Summary

Herr Wafa is guaranteed a spot on the basketball team.

The team must consist of **n players** chosen from all basketball-playing students across **m departments**.

Each department `i` has `s[i]` students.  
Herr Wafa belongs to department `h`, and `s[h]` includes him.

We must compute:

> The probability that **at least one of his teammates** is from his department.

All teams containing Herr Wafa are **equally likely**.

If there are not enough total players to form the team → print `-1`.

---

## 🧠 Key Idea

Since Herr Wafa is guaranteed on the team:

We need to choose **n − 1 teammates** from the remaining players.

Let:

- `totalPlayers` = sum of all `s[i]`
- `poolTotal = totalPlayers − 1` (excluding Wafa)
- `k = n − 1`
- `poolOther = totalPlayers − s[h]` (players not in Wafa's department)

We calculate:

### Probability that NONE of his teammates are from his department

This means selecting all `k` players from `poolOther`.

\[
P(\text{none}) =
\prod_{i=0}^{k-1}
\frac{poolOther - i}{poolTotal - i}
\]

Then:

\[
P(\text{at least one}) = 1 - P(\text{none})
\]

---

## ⚠️ Edge Cases

1. If `totalPlayers < n` → Not enough players → print `-1`
2. If `poolOther < k` → Impossible to avoid choosing from his department → print `1`

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|--------|------------|
| Time Complexity | **O(n)** |
| Space Complexity | **O(m)** |

Constraints are small:
- `n ≤ 100`
- `m ≤ 1000`
- `s[i] ≤ 100`

---

## 💻 Java 21 (64-bit) Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int h = sc.nextInt();

            int[] s = new int[m + 1];
            int totalPlayers = 0;

            for (int i = 1; i <= m; i++) {
                s[i] = sc.nextInt();
                totalPlayers += s[i];
            }

            // Not enough players
            if (totalPlayers < n) {
                System.out.println("-1");
                sc.close();
                return;
            }

            int k = n - 1;                 // teammates to choose
            int poolTotal = totalPlayers - 1; 
            int poolOther = totalPlayers - s[h];

            // Impossible to avoid choosing from his department
            if (poolOther < k) {
                System.out.println("1");
            } else {
                double probNone = 1.0;

                for (int i = 0; i < k; i++) {
                    probNone *= (double) (poolOther - i) 
                               / (poolTotal - i);
                }

                double result = 1.0 - probNone;
                System.out.printf("%.9f\n", result);
            }
        }

        sc.close();
    }
}
