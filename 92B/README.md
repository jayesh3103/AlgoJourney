# 🔵 B. Binary Number — Codeforces Problem

## 📌 Problem Summary

Little walrus Fangy starts with a **positive integer `x` given in binary form** and wants to reduce it to **1** using the following rules:

- If `x` is **odd** → add `1` to it  
- If `x` is **even** → divide it by `2`

Each operation counts as **one action**.

💡 It is guaranteed that this process always finishes.

---

## 🎯 Objective

Given a **binary number `x` (up to 10⁶ bits!)**, determine **how many actions** are required to transform it into `1`.

---

## 🚧 Challenges

- The number is **too large** to convert into a numeric type.
- We must operate **directly on the binary representation**.
- Efficient processing is required due to large input size.

---

## 🧠 Key Idea

We simulate the process **from right to left** (least significant bit to most significant bit):

- Division by `2` → right shift (1 operation)
- If the number is odd (`...1`) → add `1`, which causes a **carry** (2 operations: +1 then /2)

A `carry` variable is used to track binary overflow caused by addition.

---

## 🛠️ Algorithm

1. Read the binary string.
2. Traverse from **right to left**, excluding the most significant bit.
3. For each bit:
   - If `(bit + carry == 1)` → odd → `+2` steps, keep carry
   - Else → even → `+1` step
4. After traversal, if carry remains → add one final step.
5. Output total steps.

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|------------|
| **Time** | `O(n)` |
| **Space** | `O(1)` |

Where `n` is the number of bits in the binary string.

---

## ✅ Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        if (s == null) return;

        int n = s.length();
        int steps = 0;
        int carry = 0;

        // Process from least significant bit to the second most significant bit
        for (int i = n - 1; i > 0; i--) {
            int digit = s.charAt(i) - '0';

            if (digit + carry == 1) {
                // Odd: add 1 (carry) and divide by 2
                steps += 2;
                carry = 1;
            } else {
                // Even: just divide by 2
                steps += 1;
            }
        }

        // If carry remains, one extra step is needed
        if (carry == 1) {
            steps++;
        }

        System.out.println(steps);
    }
}
