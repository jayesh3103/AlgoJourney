# 🧮 B. Datatypes — Codeforces

## 📌 Problem Overview

Tuftuf is learning programming in a language called **Gava**, which has `n` unsigned integer datatypes.  
Each datatype has a size of `a[i]` bits.

An unsigned integer with `a` bits can represent values in the range:

0 to (2^a - 1)

Tuftuf will stop using Gava if:

There exist two datatypes `i` and `j` such that:

- `a[i] < a[j]`
- There exists an integer `x` that fits in `a[i]` bits
- But `x²` does NOT fit in `a[j]` bits

Your task is to determine whether Tuftuf will stop using Gava.

---

## 🧩 Approach

1. Read input
2. Sort the array of datatype sizes
3. Check adjacent distinct elements
4. If condition holds → print `"YES"`
5. Otherwise → print `"NO"`

Why adjacent works?

Because in sorted order:
- If condition fails for the closest larger value,
- It will also fail for any even larger value.

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|--------|------------|
| Time Complexity | O(n log n) |
| Space Complexity | O(n) |

Constraints:
- `2 ≤ n ≤ 10^5`
- `1 ≤ a[i] ≤ 10^9`

---

## 💻 Java 21 (64-bit) Solution

```java
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            Arrays.sort(a);

            boolean stopUsingGava = false;

            for (int i = 0; i < n - 1; i++) {
                if (a[i] < a[i + 1] && 2 * a[i] > a[i + 1]) {
                    stopUsingGava = true;
                    break;
                }
            }

            if (stopUsingGava) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
