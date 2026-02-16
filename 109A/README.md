# 🍀 A. Lucky Sum of Digits — Codeforces

## 📌 Problem Summary

A **lucky number** is a positive integer whose decimal representation contains **only digits 4 and 7**.

Examples:
- ✅ 4, 7, 47, 744
- ❌ 5, 17, 467

You are given an integer `n` representing the **required sum of digits**.

Your task is to print:

- The **minimum lucky number** whose digits sum to `n`
- Or `-1` if such a number does not exist

---

## 🧠 Key Insight

Let:

- `x` = number of digit **4**
- `y` = number of digit **7**

Then:

4x + 7y = n

We must:
- Find non-negative integers `x` and `y`
- Minimize the resulting number

---

## 🎯 How to Get the Minimum Lucky Number?

To get the **smallest possible number**:

1. Minimize total number of digits
2. Among equal lengths, place more `4`s first (since 4 < 7)

Strategy:

- Iterate over possible counts of `7`s (from maximum to 0)
- Check if remaining sum is divisible by 4
- When valid:
  - Use required number of `4`s
  - Then append `7`s
  - Stop immediately (guarantees minimum)

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|--------|------------|
| Time Complexity | O(n / 7) |
| Space Complexity | O(n) (for output string) |

Constraint:
- `1 ≤ n ≤ 10^6`

Efficient and safe.

---

## 💻 Java 21 (64-bit) Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Try using as many 7s as possible first
        for (int count7 = n / 7; count7 >= 0; count7--) {

            int remaining = n - count7 * 7;

            if (remaining % 4 == 0) {

                int count4 = remaining / 4;

                StringBuilder result = new StringBuilder();

                // Add all 4s first (to make number smaller)
                result.append("4".repeat(count4));

                // Then add 7s
                result.append("7".repeat(count7));

                System.out.println(result);
                sc.close();
                return;
            }
        }

        // If no combination found
        System.out.println("-1");
        sc.close();
    }
}
