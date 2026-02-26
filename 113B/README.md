# 📘 B. Petr# – Codeforces Practice

This is my solution for the **Petr#** problem from Codeforces.  
This README explains the idea, optimization, and implementation details.

---

## 📄 Problem Description

We are given:

- A string `t`
- A string `sbegin`
- A string `send`

We must count how many **different substrings** of `t`:

- Start with `sbegin`
- End with `send`
- Are continuous
- Are counted uniquely by content (positions do NOT matter)

Two substrings are different **only if their content differs**.

Constraints:

- |t| ≤ 2000
- |sbegin| ≤ 2000
- |send| ≤ 2000

---

## 💡 Key Idea

### Step 1️⃣ Find all valid start positions

For every index `i`:
- If `t.startsWith(sbegin, i)` → store `i`

### Step 2️⃣ Find all valid end positions

For every index `j`:
- If `t.startsWith(send, j)` → store `j`

---

### Step 3️⃣ Generate valid substrings

For every pair `(i, j)`:

We check if:
- `j >= i`
- Substring length is valid

The substring becomes:

t[i … j + send.length() - 1]

Then:

- Sort hashes
- Count unique values

---

## 🚀 Why Rolling Hash?

Without hashing:
- Comparing substrings directly would be too slow.

With hashing:
- Substring comparison becomes O(1)
- Total solution runs efficiently in 2 seconds.

---

## ⏱ Complexity

- Finding starts: O(n)
- Finding ends: O(n)
- Pair checking: O(n²) worst case
- Sorting hashes: O(n² log n)

Since n ≤ 2000 → acceptable.

---

## 🖥️ Implementation (Java)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        if (t == null) return;
        String sbegin = br.readLine();
        String send = br.readLine();

        int n = t.length();
        int n1 = sbegin.length();
        int n2 = send.length();

        List<Integer> starts = new ArrayList<>();
        for (int i = 0; i <= n - n1; i++) {
            if (t.startsWith(sbegin, i)) {
                starts.add(i);
            }
        }

        List<Integer> ends = new ArrayList<>();
        for (int i = 0; i <= n - n2; i++) {
            if (t.startsWith(send, i)) {
                ends.add(i);
            }
        }

        long P1 = 313, M1 = 1000000007L;
        long P2 = 317, M2 = 1000000009L;

        long[] H1 = new long[n + 1];
        long[] H2 = new long[n + 1];
        long[] P1_pow = new long[n + 1];
        long[] P2_pow = new long[n + 1];

        P1_pow[0] = 1;
        P2_pow[0] = 1;

        for (int i = 1; i <= n; i++) {
            H1[i] = (H1[i - 1] * P1 + t.charAt(i - 1)) % M1;
            H2[i] = (H2[i - 1] * P2 + t.charAt(i - 1)) % M2;
            P1_pow[i] = (P1_pow[i - 1] * P1) % M1;
            P2_pow[i] = (P2_pow[i - 1] * P2) % M2;
        }

        long[] hashes = new long[starts.size() * ends.size()];
        int count = 0;

        for (int i : starts) {
            for (int j : ends) {
                if (j >= i && j + n2 - i >= n1) {
                    int L = i + 1;
                    int R = j + n2;

                    long h1 = (H1[R] - (H1[L - 1] * P1_pow[R - L + 1]) % M1 + M1) % M1;
                    long h2 = (H2[R] - (H2[L - 1] * P2_pow[R - L + 1]) % M2 + M2) % M2;

                    hashes[count++] = (h1 << 32) | h2;
                }
            }
        }

        Arrays.sort(hashes, 0, count);

        int unique = 0;
        for (int k = 0; k < count; k++) {
            if (k == 0 || hashes[k] != hashes[k - 1]) {
                unique++;
            }
        }

        System.out.println(unique);
    }
}
