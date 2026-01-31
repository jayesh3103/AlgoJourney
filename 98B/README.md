# 🪙 B. Help King — Codeforces

## 📌 Problem Summary

The King needs to choose **one knight out of `n`** using **only a fair coin**  
(each toss gives Heads/Tails with probability 1/2).

### Conditions:
- Every knight must be chosen with **equal probability = 1 / n**
- The King can use **any optimal strategy**
- The goal is to **minimize the expected number of coin tosses**
- Output the expected number of tosses as an **irreducible fraction**

---

## 📥 Input

- A single integer `n` (1 ≤ n ≤ 10⁴)

---

## 📤 Output

- Expected number of coin tosses in the form `a/b`
- The fraction must be **irreducible**
- No leading zeroes

---

## 🧠 Key Insight

This is an **optimal randomized selection** problem using a **binary coin**.

### Core idea:
- Each coin toss gives **1 bit of information**
- We simulate generating random numbers in base-2
- If `n` is not a power of two, some outcomes must be **rejected and retried**
- This creates a **recursive expected value equation**
- The optimal strategy forms a **functional graph**
- The expectation is solved using:
  - **Cycle detection**
  - **Big integer fraction arithmetic**

This is a classic **expected value + probability + graph cycle** problem.

---

## 🧮 Mathematical Model

For a state `u`:

E(u) = k + (next / 2^k) · E(next)

Where:
- `k` = number of coin tosses needed at state `u`
- `next` = next unresolved state after rejection
- Final answer is `E(1)`

The recurrence is solved by:
- Collapsing cycles
- Solving linear equations backward

---

## ⏱️ Complexity

| Aspect | Value |
|----|----|
| States | ≤ n |
| Time | O(n log n) |
| Space | O(n) |
| Precision | Exact (BigInteger) |

---

## ✅ Java Implementation

```java
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class BigFraction {
        BigInteger num, den;

        BigFraction(BigInteger n, BigInteger d) {
            if (d.signum() < 0) {
                n = n.negate();
                d = d.negate();
            }
            BigInteger g = n.gcd(d);
            num = n.divide(g);
            den = d.divide(g);
        }

        static BigFraction add(BigFraction a, BigFraction b) {
            return new BigFraction(
                a.num.multiply(b.den).add(b.num.multiply(a.den)),
                a.den.multiply(b.den)
            );
        }

        static BigFraction multiply(BigFraction a, BigFraction b) {
            return new BigFraction(
                a.num.multiply(b.num),
                a.den.multiply(b.den)
            );
        }

        public String toString() {
            return num + "/" + den;
        }
    }

    static class Edge {
        int k, next;
        BigInteger pow;
        Edge(int k, int next, BigInteger pow) {
            this.k = k;
            this.next = next;
            this.pow = pow;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println("0/1");
            return;
        }

        Edge[] edges = new Edge[n];
        for (int i = 1; i < n; i++) {
            long v = i;
            int k = 0;
            while (v < n) {
                v <<= 1;
                k++;
            }
            edges[i] = new Edge(k, (int)(v % n), BigInteger.valueOf(v));
        }

        int[] seen = new int[n];
        Arrays.fill(seen, -1);
        List<Integer> path = new ArrayList<>();

        int cur = 1, cycleStart = -1;
        while (cur != 0 && seen[cur] == -1) {
            seen[cur] = path.size();
            path.add(cur);
            cur = edges[cur].next;
        }
        if (cur != 0) cycleStart = cur;

        BigFraction E;
        if (cur == 0) {
            E = new BigFraction(BigInteger.ZERO, BigInteger.ONE);
        } else {
            int idx = seen[cycleStart];
            List<Integer> cycle = path.subList(idx, path.size());

            int K = 0;
            for (int u : cycle) K += edges[u].k;

            BigInteger sum = BigInteger.ZERO;
            int acc = 0;
            for (int u : cycle) {
                sum = sum.add(
                    BigInteger.valueOf(edges[u].k)
                        .multiply(BigInteger.valueOf(u))
                        .shiftLeft(K - acc)
                );
                acc += edges[u].k;
            }

            BigInteger denom = BigInteger.ONE.shiftLeft(K)
                .subtract(BigInteger.ONE)
                .multiply(BigInteger.valueOf(cycleStart));

            E = new BigFraction(sum, denom);
            path = path.subList(0, idx);
        }

        for (int i = path.size() - 1; i >= 0; i--) {
            int u = path.get(i);
            Edge e = edges[u];
            BigFraction base = new BigFraction(BigInteger.valueOf(e.k), BigInteger.ONE);
            BigFraction coef = new BigFraction(BigInteger.valueOf(e.next), e.pow);
            E = BigFraction.add(base, BigFraction.multiply(coef, E));
        }

        System.out.println(E);
    }
}
