# 🥛 B. End of Exams — Codeforces Problem

## 📌 Problem Overview

After finishing exams, **m students** go to a café and order **n bottles of milk**, each bottle having volume **w**.  
They want to **distribute all the milk evenly** among themselves so that **each student gets exactly the same amount**.

⚠️ Constraint imposed by Igor:
> **Milk from each bottle can be poured into at most two different cups.**

Milk can be poured in **fractional amounts** with perfect precision.

---

## 🎯 Objective

Given `n`, `w`, and `m`:

1. Decide whether it is **possible** to distribute all the milk so that:
   - Every cup has the same volume
   - Each bottle is used in **no more than two cups**
2. If possible, **print one valid distribution**.

---

## 📥 Input

- `n` — number of bottles `(1 ≤ n ≤ 50)`
- `w` — volume of each bottle `(100 ≤ w ≤ 1000)`
- `m` — number of students `(2 ≤ m ≤ 50)`

---

## 📤 Output

- Print `"YES"` or `"NO"`
- If `"YES"`, print `m` lines:
  - Each line describes one cup
  - Format: `b v` meaning `v` units poured from bottle `b`
  - Each bottle index appears **at most twice globally**
  - Real numbers must have **at least 6 digits after decimal**

---

## 🧠 Key Insight

- **Total milk** = `n × w`
- **Milk per cup** = `(n × w) / m`
- We simulate pouring milk **sequentially bottle by bottle** into cups.
- Each bottle naturally gets split into **at most two cups**:
  - One where it starts
  - One where it finishes
- After simulation, we verify:
  - No bottle was used in more than **two cups**

---

## 🧪 Feasibility Condition

If any bottle is used in **more than 2 cups**, the answer is `"NO"`.  
Otherwise, the constructed distribution is valid.

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|------------|
| **Time** | `O(n + m)` |
| **Space** | `O(n + m)` |

---

## ✅ Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Pour {
        int bottle;
        double amount;

        Pour(int bottle, double amount) {
            this.bottle = bottle;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();   // number of bottles
        int w = fs.nextInt();   // volume per bottle
        int m = fs.nextInt();   // number of students

        double totalMilk = (double) n * w;
        double perCup = totalMilk / m;

        List<List<Pour>> cups = new ArrayList<>();
        for (int i = 0; i < m; i++) cups.add(new ArrayList<>());

        int currentBottle = 1;
        double remaining = w;
        int[] bottleUsage = new int[n + 1];

        for (int i = 0; i < m; i++) {
            double need = perCup;

            while (need > 1e-9) {
                if (remaining < 1e-9) {
                    currentBottle++;
                    remaining = w;
                }

                double take = Math.min(need, remaining);
                cups.get(i).add(new Pour(currentBottle, take));

                bottleUsage[currentBottle]++;
                need -= take;
                remaining -= take;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (bottleUsage[i] > 2) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
        for (List<Pour> cup : cups) {
            StringBuilder sb = new StringBuilder();
            for (Pour p : cup) {
                sb.append(p.bottle)
                  .append(" ")
                  .append(String.format("%.6f", p.amount))
                  .append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
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
