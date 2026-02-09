# 🏛️ B. Dark Assembly — Codeforces

## 🧩 Problem Overview

The **Dark Assembly** consists of `n` senators. Each senator has:

- **Level** `b[i]` → strength (used if the player must fight them)
- **Loyalty** `l[i]` → probability (in %) that they vote **YES**

A proposal is approved if:
- **Strictly more than half** of the senators vote YES  
OR
- The player **kills all NO-voters** after a failed vote

The player:
- Has total power `A`
- Can bring at most `k` candies
- Each candy increases a senator’s loyalty by **+10%** (up to 100%)
- Candies must be distributed **before voting**

Your goal:  
➡️ **Distribute candies optimally** to **maximize the probability** that the proposal is approved.

---

## 🧪 Strategy

Because `n ≤ 8`, we can brute-force safely:

### Step 1: Precompute Voting Outcomes
- Enumerate all `2ⁿ` vote combinations (bitmasks)
- For each:
  - If YES > n/2 → probability = 1
  - Else → appeal probability based on NO-voters’ levels

### Step 2: Try All Candy Distributions
- DFS over senators
- Assign `0..(remaining candies)` to each senator
- Update loyalties accordingly

### Step 3: Compute Expected Probability
For each candy configuration:

Σ (probability of vote mask × outcome of that mask)

Take the **maximum** over all distributions.

---

## ⏱️ Complexity

| Aspect | Complexity |
|-----|------------|
| Candy distributions | ≤ 9⁸ |
| Vote masks | 2⁸ = 256 |
| Total | Acceptable within limits |

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    static int n, k, A;
    static int[] b;
    static int[] l;
    static double maxP = -1.0;
    static double[] outcomes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        
        n = sc.nextInt();
        k = sc.nextInt();
        A = sc.nextInt();
        
        b = new int[n];
        l = new int[n];
        
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            l[i] = sc.nextInt();
        }
        
        int limit = 1 << n;
        outcomes = new double[limit];
        
        // Precompute outcomes for all voting masks
        for (int mask = 0; mask < limit; mask++) {
            int yes = Integer.bitCount(mask);
            if (yes > n / 2) {
                outcomes[mask] = 1.0;
            } else {
                long sumB = 0;
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) == 0) {
                        sumB += b[i];
                    }
                }
                outcomes[mask] = (double) A / (A + sumB);
            }
        }
        
        solve(0, k);
        System.out.printf("%.10f\n", maxP);
    }

    static void solve(int idx, int rem) {
        if (idx == n) {
            double cur = 0.0;
            double[] p = new double[n];
            for (int i = 0; i < n; i++) p[i] = l[i] / 100.0;
            
            for (int mask = 0; mask < outcomes.length; mask++) {
                double prob = 1.0;
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        prob *= p[i];
                    } else {
                        prob *= (1.0 - p[i]);
                    }
                }
                cur += prob * outcomes[mask];
            }
            maxP = Math.max(maxP, cur);
            return;
        }

        int currentL = l[idx];
        int maxAdd = (100 - currentL) / 10;
        int bound = Math.min(rem, maxAdd);

        for (int i = 0; i <= bound; i++) {
            l[idx] = currentL + i * 10;
            solve(idx + 1, rem - i);
        }
        l[idx] = currentL;
    }
}
