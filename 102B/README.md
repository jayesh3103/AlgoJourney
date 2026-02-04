# 🔢 B. Sum of Digits — Codeforces

## 🧙‍♂️ Problem Overview

After watching a Harry Potter movie, Gerald learns a magical spell that transforms a number into the **sum of its digits**.

Given a number **n**, Gerald repeatedly applies this spell until the number becomes **a single digit**.

Your task is to determine **how many times** the spell can be cast.

---

## 📥 Input Format

- A single integer `n`  
- `0 ≤ n ≤ 10^100000`  
- No leading zeroes  

---

## 📤 Output Format

- Print a single integer — the number of times the number can be replaced by the sum of its digits until it becomes one-digit

---

## 🧠 Key Insight

- If the number already has **one digit**, the answer is `0`
- Otherwise:
  - Replace the number by the **sum of its digits**
  - Count how many transformations are needed until the number is `< 10`

This is essentially computing the **additive persistence** of the number.
---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|------------|
| Time | **O(d × k)** |
| Space | **O(1)** |

- `d` = number of digits  
- `k` = number of transformations (very small)
- Works efficiently even for extremely large inputs because input is handled as a string

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

        // If already a single digit, no operations needed
        if (s.length() == 1) {
            System.out.println(0);
            return;
        }

        int currentSum = 0;
        for (int i = 0; i < s.length(); i++) {
            currentSum += s.charAt(i) - '0';
        }

        int count = 1;

        while (currentSum >= 10) {
            int nextSum = 0;
            int temp = currentSum;

            while (temp > 0) {
                nextSum += temp % 10;
                temp /= 10;
            }

            currentSum = nextSum;
            count++;
        }

        System.out.println(count);
    }
}
