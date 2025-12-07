# ⚡ Problem of the Day — B. Energy Exchange

### 📅 Daily Codeforces Challenge  
A classic binary search + greedy simulation problem dealing with energy equalization under transfer losses.

---

## 📝 Problem Summary

We have **n accumulators**, where the *i-th* accumulator initially contains:

a[i] units of energy

When **x units** of energy are transferred from one accumulator to another:

- The sender **loses x**
- The receiver **gains x·(1 - k/100)**  
  because **k% of the energy is lost** during the transfer.

**Goal:**  
➡️ Find the **maximum possible equal energy** value **E** that can remain in **every accumulator** after performing unlimited transfers.

You must output this **maximum achievable E** with absolute/relative error ≤ 1e-6.

---

## 🔍 Key Insight

We want to check:

> "Is it possible to make the energy in all accumulators equal to some value `mid`?"

To test this:

- Accumulators with **a[i] > mid** → have **surplus**  

surplus += a[i] - mid

- Accumulators with **a[i] < mid** → have **deficit**  

deficit += mid - a[i]

But due to transfer inefficiency:

Effective surplus = surplus * (1 - k/100)

The condition to achieve `mid` is:

effective_surplus ≥ deficit

---

## ⚙️ Approach

### ✔️ Binary Search
We binary-search on the final uniform energy:

- **Left boundary = 0**
- **Right boundary = max(a[i])**

Perform ~100 iterations (enough for 1e-6 accuracy):

1. Compute `mid`
2. Compute total surplus and deficit
3. If `surplus * factor >= deficit`  
   → it is possible to achieve `mid`, so move left boundary up  
4. Otherwise  
   → lower the target

The final `l` after binary search is the answer.

---

## ⏱️ Complexity

| Type | Complexity |
|------|------------|
| **Time** | O(logn) |
| **Space** | O(n) |

Completely efficient for n ≤ 10⁴.

---

## 🧠 Java Implementation

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String s = sc.next();
        if (s == null) return;
        
        int n = Integer.parseInt(s);
        int k = sc.nextInt();
        
        double[] a = new double[n];
        double maxVal = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] > maxVal) maxVal = a[i];
        }
        
        double factor = 1.0 - k / 100.0;
        double l = 0.0;
        double r = maxVal;
        
        for (int i = 0; i < 100; i++) {
            double mid = (l + r) / 2;
            double surplus = 0;
            double deficit = 0;
            
            for (double val : a) {
                if (val > mid) {
                    surplus += (val - mid);
                } else {
                    deficit += (mid - val);
                }
            }
            
            if (surplus * factor >= deficit) {
                l = mid;
            } else {
                r = mid;
            }
        }
        
        System.out.printf("%.9f%n", l);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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
```
