# 📌 B. Falling Anvils

## 📅 Problem of the Day — Codeforces  

---

## 📝 Problem Summary

In classic cartoons, anvils fall from the sky onto heroes’ heads.  
Surprisingly, hitting a hero accurately depends on **physics-like parameters**:

- `p` → height of the hero, chosen uniformly from **[0, a]**
- `q` → wind direction, chosen uniformly from **[-b, b]**

An anvil hits successfully **if a certain quadratic equation (derived from the model) has at least one real root**.

Your task is to compute the **probability** that a randomly chosen `(p, q)` pair results in a successful hit.

---

## 🎯 Objective

For each test case `(a, b)`:

- Compute the probability that the equation has **at least one real root**
- Output the probability with **absolute or relative error ≤ 10⁻⁶**

---

## 🧠 Mathematical Insight

After reducing the condition for **real roots**, the problem boils down to **measuring an area** in the `(p, q)` plane.

Key edge cases:

### 🔹 Case 1: `b = 0`
- Wind has no variation
- The equation **always** has a real root  
✅ Probability = `1`

### 🔹 Case 2: `a = 0`
- Height is fixed at zero
- Exactly **half** of wind values satisfy the condition  
✅ Probability = `0.5`

---

## 🧮 General Formula

For `a > 0` and `b > 0`:

### 📌 If `4b ≤ a`
\[
\text{Probability} = 1 - \frac{b}{a}
\]

### 📌 Otherwise (`4b > a`)
\[
\text{Probability} = \frac{1}{2} + \frac{a}{16b}
\]

These formulas come from integrating the valid region where the discriminant of the equation is non-negative.

---

## 🧠 Approach

1. Read number of test cases `t`
2. For each `(a, b)`:
   - Handle edge cases (`a = 0` or `b = 0`)
   - Apply the correct closed-form probability formula
3. Print result with sufficient precision

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(t)` |
| **Space Complexity** | `O(1)` |

Efficient enough for **10,000 test cases**.

---

## 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (b == 0) {
                out.println("1.0000000000");
            } else if (a == 0) {
                out.println("0.5000000000");
            } else {
                if (4L * b <= a) {
                    double ans = 1.0 - (double) b / a;
                    out.printf(Locale.US, "%.10f%n", ans);
                } else {
                    double ans = 0.5 + (double) a / (16.0 * b);
                    out.printf(Locale.US, "%.10f%n", ans);
                }
            }
        }
        out.flush();
    }
}
