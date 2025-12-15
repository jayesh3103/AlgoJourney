# 🏎️ B. Need For Brake

## 📅 Problem of the Day — Codeforces  
**Difficulty:** Hard  
**Category:** Greedy, Sorting, Simulation  

---

## 📝 Problem Summary

Vasya is participating in a racing championship with **n racers**.  
Each racer already has some points, and **only one race remains**.

### 🏁 Race Rules

- Racers are ranked after the final race
- Only the **top `m` racers** receive bonus points
- Bonus points for position `i` is `b[i]`
- Final ranking is:
  1. Higher total points
  2. Lexicographically smaller name (if points tie)

Vasya wants to know:

> **What is the best and worst possible final position he can achieve?**

---

## 🎯 Objective

Determine:
- **Highest (best) possible rank**
- **Lowest (worst) possible rank**

assuming all outcomes of the last race are optimally (or pessimistically) arranged.

---

## 🧠 Key Observations

- Vasya can receive **any one of the bonus scores**
- Other racers can also receive bonus points
- We must:
  - Maximize Vasya’s rank (others stay below him)
  - Minimize Vasya’s rank (others push above him)

---

## ⚙️ Approach

### 🔹 Preparation
1. Store racers’ names and scores
2. Sort bonus points (pad with zeros if `m < n`)

---

### 🟢 Best Possible Rank

- Give Vasya the **maximum bonus**
- Try to give other racers **small bonuses** so they **don’t surpass Vasya**
- Lexicographical tie-breaking is handled carefully

---

### 🔴 Worst Possible Rank

- Give Vasya the **minimum bonus**
- Give other racers **large bonuses** to push them above Vasya
- Again, name ordering is considered for ties

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(n log n)` |
| **Space Complexity** | `O(n)` |

Efficient enough for `n ≤ 10⁵`.

---

## 💻 Java Implementation

```java
import java.io.*;
import java.util.*;

public class Main {
    static class Racer {
        String name;
        int score;

        public Racer(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String line = sc.next();
        if (line == null) return;
        
        int n = Integer.parseInt(line);
        Racer[] racers = new Racer[n];
        
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            racers[i] = new Racer(name, score);
        }

        int m = sc.nextInt();
        ArrayList<Integer> points = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            points.add(sc.nextInt());
        }
        
        while (points.size() < n) {
            points.add(0);
        }
        Collections.sort(points);

        String vasyaName = sc.next();
        int vIdx = -1;
        for (int i = 0; i < n; i++) {
            if (racers[i].name.equals(vasyaName)) {
                vIdx = i;
                break;
            }
        }

        int maxPoints = points.get(n - 1);
        int vBestScore = racers[vIdx].score + maxPoints;
        ArrayList<Integer> limits = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (i == vIdx) continue;
            int diff = vBestScore - racers[i].score;
            if (vasyaName.compareTo(racers[i].name) > 0) {
                diff--;
            }
            limits.add(diff);
        }
        Collections.sort(limits);

        int keptBelow = 0;
        int pPtr = 0;
        int lPtr = 0;
        
        while (pPtr < n - 1 && lPtr < limits.size()) {
            if (points.get(pPtr) <= limits.get(lPtr)) {
                keptBelow++;
                pPtr++;
                lPtr++;
            } else {
                lPtr++;
            }
        }
        int bestRank = n - keptBelow;

        int minPoints = points.get(0);
        int vWorstScore = racers[vIdx].score + minPoints;
        ArrayList<Integer> needs = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (i == vIdx) continue;
            int need = vWorstScore - racers[i].score;
            if (vasyaName.compareTo(racers[i].name) > 0) {
                
            } else {
                need++;
            }
            needs.add(Math.max(0, need));
        }
        Collections.sort(needs);

        int pushedAbove = 0;
        pPtr = 1;
        int nPtr = 0;
        
        while (pPtr < n && nPtr < needs.size()) {
            if (points.get(pPtr) >= needs.get(nPtr)) {
                pushedAbove++;
                pPtr++;
                nPtr++;
            } else {
                pPtr++;
            }
        }
        int worstRank = 1 + pushedAbove;

        System.out.println(bestRank + " " + worstRank);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
