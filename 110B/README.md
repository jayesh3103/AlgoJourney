# 🍀 B. Lucky String — Codeforces

## 📌 Problem Overview

A string of lowercase English letters is considered **lucky** if:

For every letter:
- Write down all its positions (1-based index) in increasing order.
- For every two adjacent positions in that list,  
  their absolute difference must be a **lucky number**.

A lucky number contains only digits `4` and `7`.

You must print the **lexicographically minimal lucky string** of length `n`.

Constraints:

1 ≤ n ≤ 10^5

---

## 🧠 Key Insight

Lucky differences must be:

4, 7, 44, 47, 74, 77, …

To keep things simple and lexicographically minimal:

If we repeat letters every **4 positions**, then:

positions difference = 4

Since `4` is lucky, the condition is satisfied.

The smallest lexicographical repeating pattern that works:

a b c d

So the answer is simply:

“abcdabcdabcd…”

(repeated until length n)

Why this works:

- Each letter repeats every 4 positions
- Difference = 4 (which is lucky)
- Using only 4 letters keeps string lexicographically minimal

---

## ⏱ Complexity Analysis

| Metric | Complexity |
|--------|------------|
| Time Complexity | O(n) |
| Space Complexity | O(n) |

Works efficiently up to 10^5.

---

## 💻 Java 21 (64-bit) Complete Solution

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {

            int n = sc.nextInt();

            StringBuilder result = new StringBuilder(n);
            char[] pattern = {'a', 'b', 'c', 'd'};

            for (int i = 0; i < n; i++) {
                result.append(pattern[i % 4]);
            }

            System.out.println(result.toString());
        }

        sc.close();
    }
}
