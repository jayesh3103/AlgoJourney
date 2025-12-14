# 🧟‍♂️ A. The Elder Trolls IV: Oblivon

## 📅 Problem of the Day — Codeforces 

---

## 📝 Problem Summary

Vasya is fighting the **Unkillable Slug**, a monster shaped like a rectangular parallelepiped of size:
`x × y × z`
The monster consists of `1 × 1 × 1` indestructible cells.

### ⚔️ Cutting Rules

- Vasya can make **at most `k` cuts**
- Each cut is a **plane parallel to one of the faces**
- One cut can slice **multiple existing parts at once**
- Pieces remain in their positions
- The sword is infinitely thin and long

---

## 🎯 Goal

Find the **maximum number of pieces** the monster can be divided into using **no more than `k` cuts**.

---

## 🧠 Key Insight

If Vasya makes:
- `a` cuts along **x**
- `b` cuts along **y**
- `c` cuts along **z**

Then the number of resulting pieces is:
`(a + 1) × (b + 1) × (c + 1)`
Let:
- A = a + 1
- B = b + 1
- C = c + 1

### Constraints

- Total cuts:
(A - 1) + (B - 1) + (C - 1) ≤ k
⇒ A + B + C ≤ k + 3

- Dimension limits: 
A ≤ x,   B ≤ y,   C ≤ z

---

## ⚙️ Approach

1. Sort the dimensions `x, y, z`
2. Distribute `k + 3` as evenly as possible among `A, B, C`
3. Clamp each value so it does not exceed its dimension
4. Compute:
`maximum pieces = A × B × C`
This greedy balancing maximizes the product.

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(1)` |
| **Space Complexity** | `O(1)` |

Only constant-time calculations are used.

---

## 💻 Java Implementation

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        long x = sc.nextLong();
        long y = sc.nextLong();
        long z = sc.nextLong();
        long k = sc.nextLong();

        long[] dims = {x, y, z};
        Arrays.sort(dims);

        long sum = k + 3;

        long a = sum / 3;
        long b = (sum - a) / 2;
        long c = sum - a - b;

        if (a > dims[0]) {
            a = dims[0];
            long rem = sum - a;
            b = rem / 2;
            c = rem - b;
        }

        if (b > dims[1]) {
            b = dims[1];
            c = sum - a - b;
        }

        if (c > dims[2]) {
            c = dims[2];
        }

        System.out.println(a * b * c);
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
