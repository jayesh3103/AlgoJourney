# 🍀 B. Lucky Probability — Codeforces

## 📌 Problem Overview

Petya chooses a number `p` uniformly from `[pl, pr]`.  
Vasya chooses a number `v` uniformly from `[vl, vr]`.

We must compute the probability that the interval:

[min(p, v), max(p, v)]

contains **exactly `k` lucky numbers**.

A **lucky number** is a positive integer whose decimal representation contains only digits `4` and `7`.

---

## 🧠 Key Insight

- Maximum possible lucky numbers ≤ 1022 (very small).
- We can generate all lucky numbers ≤ 10⁹ using recursion.
- Sort them and add sentinels (`0` and large value).
- For each consecutive block of `k` lucky numbers:
  - Count valid `(p, v)` pairs using interval intersections.
- Divide favorable pairs by total possible pairs.

Time complexity is very small since lucky numbers are few.

---

## 💻 Java Code
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Long> lucky = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long pl = sc.nextLong();
        long pr = sc.nextLong();
        long vl = sc.nextLong();
        long vr = sc.nextLong();
        int k = sc.nextInt();

        generate(0);
        Collections.sort(lucky);

        // Add sentinel values
        lucky.add(0, 0L);
        lucky.add(2_000_000_000L);

        long favorable = 0;

        for (int i = 1; i + k < lucky.size(); i++) {

            long leftStart = lucky.get(i - 1) + 1;
            long leftEnd = lucky.get(i);

            long rightStart = lucky.get(i + k - 1);
            long rightEnd = lucky.get(i + k) - 1;

            long pLeft = intersect(pl, pr, leftStart, leftEnd);
            long vRight = intersect(vl, vr, rightStart, rightEnd);

            long vLeft = intersect(vl, vr, leftStart, leftEnd);
            long pRight = intersect(pl, pr, rightStart, rightEnd);

            favorable += pLeft * vRight;
            favorable += vLeft * pRight;

            if (k == 1) {
                long val = lucky.get(i);
                if (val >= pl && val <= pr &&
                    val >= vl && val <= vr) {
                    favorable--;
                }
            }
        }

        double total = (double)(pr - pl + 1) * (vr - vl + 1);
        System.out.printf("%.12f\n", favorable / total);

        sc.close();
    }

    static void generate(long cur) {
        if (cur > 1_000_000_000L) return;
        if (cur > 0) lucky.add(cur);

        generate(cur * 10 + 4);
        generate(cur * 10 + 7);
    }

    static long intersect(long a, long b, long x, long y) {
        long l = Math.max(a, x);
        long r = Math.min(b, y);
        return Math.max(0, r - l + 1);
    }
}
