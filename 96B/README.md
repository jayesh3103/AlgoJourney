# 🍀 B. Lucky Numbers (Easy) — Codeforces

## 📌 Problem Statement

Petya loves **lucky numbers**.

- A number is **lucky** if it contains only digits `4` and `7`.
- A lucky number is **super lucky** if it contains an **equal number of `4`s and `7`s**.

Given a positive integer `n`, find the **smallest super lucky number** that is **greater than or equal to `n`**.

---

## 🔍 Input

- One positive integer `n`
- Constraints:
  - `1 ≤ n ≤ 10^9`
  - No leading zeros

---

## 📤 Output

- Print the least super lucky number that is **≥ n**

---

## 🧠 Approach

Since:
- Super lucky numbers consist only of digits `4` and `7`
- The count of `4`s must equal the count of `7`s

We can:
1. Generate all possible lucky numbers using **DFS**
2. Track counts of `4` and `7`
3. Check:
   - `current ≥ n`
   - `count(4) == count(7)`
4. Maintain the **minimum valid number**

Because `n ≤ 10^9`, the total search space is small and manageable.

---

## ⏱️ Complexity Analysis

| Type | Complexity |
|----|----|
| Time | **O(2^k)** (k ≤ 10 digits, very small) |
| Space | **O(k)** recursion depth |

---

## ✅ Java Solution

```java
import java.util.Scanner;

public class Main {
    static long n;
    static long result = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextLong()) {
            n = sc.nextLong();
            dfs(0, 0, 0);
            System.out.println(result);
        }

        sc.close();
    }

    static void dfs(long current, int c4, int c7) {
        if (current > result || c4 + c7 > 10) {
            return;
        }

        if (current >= n && c4 == c7 && c4 > 0) {
            result = current;
        }

        dfs(current * 10 + 4, c4 + 1, c7);
        dfs(current * 10 + 7, c4, c7 + 1);
    }
}
