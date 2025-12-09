# 🏅 B. Bets — Codeforces Solution

## 📌 Problem Summary
In a biathlon race with **n sections** and **m athletes**, each athlete:

- Starts at section `lᵢ`
- Finishes at section `rᵢ`
- Runs each section in `tᵢ` time units
- Gives a profit of `cᵢ` roubles **per section won**

An athlete participates only in sections from `lᵢ` to `rᵢ`.

### 🥇 Winner of a Section
A section’s winner is determined **independently**:

1. Athlete with **minimum time `tᵢ`** among all participants of that section.
2. If tie → athlete with **smaller index** wins.
3. If no athlete runs that section → no winner.

### 🎯 Objective
Nikita can place **at most one bet per section**, selecting one participating athlete.  
Find the **maximum total profit** achievable.

---

## 🧠 Approach

For every section from `1` to `n`:

1. Check which athletes participate in the current section.
2. Among them, find the one with:
   - Minimum time `tᵢ`
   - Tie-breaking by lowest index
3. Add the corresponding profit `cᵢ` to the total.

This greedy approach is correct because:
- Each section is **independent**.
- Profit is linear: winning a section by athlete *i* contributes exactly **+cᵢ**, with no future impact.
- So the optimal solution is simply selecting the best athlete for each section individually.

---

## ⏱️ Time & Space Complexity

### **Time Complexity: O(n × m)**
- For each of the `n` sections, we check all `m` athletes.
- Constraints (n, m ≤ 100) make this totally efficient.

### **Space Complexity: O(m)**
- We store 4 arrays of size `m` (`l`, `r`, `t`, `c`).
- No additional complex data structures required.

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] l = new int[m + 1];
        int[] r = new int[m + 1];
        int[] t = new int[m + 1];
        int[] c = new int[m + 1];

        for (int i = 1; i <= m; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
            t[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        int totalProfit = 0;

        for (int section = 1; section <= n; section++) {
            int bestTime = 1001; 
            int winnerId = -1;

            for (int i = 1; i <= m; i++) {
                if (section >= l[i] && section
