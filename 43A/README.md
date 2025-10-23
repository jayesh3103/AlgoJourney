# ⚽ A. Football – Codeforces Practice

This is my solution for the **A. Football** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

Vasya came across the results of the **Berland 1910 Football Championship** finals.  
Unfortunately, he didn’t find the final score — only a detailed description of which team scored each goal.

You are given:
- An integer `n` (1 ≤ n ≤ 100) — the number of goals.
- Then `n` lines, each containing the **name of the team** that scored a goal.

It is guaranteed that:
- The match did **not** end in a draw.
- The description contains **no more than two different teams**.

### 🏁 Output
Print the **name of the team that won**, i.e., the one that scored the most goals.

---

## 💡 Approach

1. **Read the Input:**
   - Read the integer `n`, the number of goals scored.
   - Read each goal’s team name and count how many times each team scored.

2. **Track Two Teams:**
   - Initialize the first team name (`team1`) and set its score.
   - If another team name appears, store it as `team2` and count separately.

3. **Determine the Winner:**
   - After processing all goals:
     - If `score1 > score2`, `team1` is the winner.
     - Otherwise, `team2` wins.

4. **Edge Case:**
   - If all goals are by the same team, it automatically wins.

---

## 🧠 Core Idea

> Since the game involves at most two teams, the problem reduces to simple counting.  
Whichever team name appears **more times** in the goal list is the winner.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();

            String team1 = in.next();
            int score1 = 1;

            String team2 = "";
            int score2 = 0;

            for (int i = 1; i < n; i++) {
                String team = in.next();
                if (team.equals(team1)) {
                    score1++;
                } else {
                    team2 = team;
                    score2++;
                }
            }

            if (score1 > score2) {
                System.out.println(team1);
            } else {
                System.out.println(team2);
            }
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`
