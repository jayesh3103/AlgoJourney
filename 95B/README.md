# 🍀 B. Lucky Numbers — Codeforces

## 📌 Problem Statement

A **lucky number** contains only digits `4` and `7`.

A **super lucky number**:
- Contains only digits `4` and `7`
- Has an **equal number of `4`s and `7`s**

Given a positive integer `n`, find the **smallest super lucky number ≥ n**.

---

## 🔍 Key Observations

- A super lucky number must have **even length**
- If `len(n)` is odd → answer must have **greater even length**
- If `len(n)` is even:
  - Try to construct a valid super lucky number of the **same length**
  - If impossible, move to the **next even length**

---

## 🧠 Approach

1. Let `len = length of n`
2. If `len` is odd:
   - Directly print the smallest super lucky number of length `len + 1`
3. Otherwise:
   - Traverse `n` from left to right
   - Track counts of `4` and `7`
   - Try to increment digits greedily (`4 → 7`)
   - Fill remaining positions with minimum lexicographic digits
4. If no valid number can be formed:
   - Print the smallest super lucky number of length `len + 2`

---

## ⏱️ Complexity Analysis

| Type | Complexity |
|-----|-----------|
| Time | **O(len(n))** |
| Space | **O(len(n))** |

Efficient even for very large numbers (`len(n) ≤ 10⁷`).

---

## ✅ Java Solution

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int len = n.length();

        // If length is odd, answer must have length + 1
        if (len % 2 != 0) {
            printSmallest(len + 1);
            return;
        }

        int count4 = 0, count7 = 0;
        int limit = len / 2;
        int prefix = 0;

        // Try to match prefix
        for (int i = 0; i < len; i++) {
            char c = n.charAt(i);
            if (c == '4' && count4 + 1 <= limit) {
                count4++;
                prefix++;
            } else if (c == '7' && count7 + 1 <= limit) {
                count7++;
                prefix++;
            } else {
                break;
            }
        }

        // Already super lucky
        if (prefix == len && count4 == limit && count7 == limit) {
            System.out.println(n);
            return;
        }

        // Try backtracking
        for (int i = prefix; i >= 0; i--) {
            if (i < len && n.charAt(i) < '4' && count4 + 1 <= limit) {
                buildResult(n, i, '4', count4, count7, limit);
                return;
            }
            if (i < len && n.charAt(i) < '7' && count7 + 1 <= limit) {
                buildResult(n, i, '7', count4, count7, limit);
                return;
            }

            if (i > 0) {
                char prev = n.charAt(i - 1);
                if (prev == '4') count4--;
                else if (prev == '7') count7--;
            }
        }

        // No valid number of same length
        printSmallest(len + 2);
    }

    private static void printSmallest(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length / 2; i++) sb.append('4');
        for (int i = 0; i < length / 2; i++) sb.append('7');
        System.out.println(sb);
    }

    private static void buildResult(String n, int idx, char digit,
                                    int c4, int c7, int limit) {
        StringBuilder sb = new StringBuilder();
        sb.append(n, 0, idx);
        sb.append(digit);

        if (digit == '4') c4++;
        else c7++;

        for (int i = 0; i < limit - c4; i++) sb.append('4');
        for (int i = 0; i < limit - c7; i++) sb.append('7');

        System.out.println(sb);
    }
}
