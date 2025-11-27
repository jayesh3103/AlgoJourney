# 🔍 B. Tyndex.Brome — Error Function Matching Engine  
### 📅 Daily Codeforces Challenge — AlgoJourney

Today’s challenge dives into the heart of **Tyndex.Brome**, the futuristic browser that auto-corrects mistyped URLs by computing a special **error function F** for each potential address. Your task is to simulate this scoring engine with high efficiency — and you nailed it flawlessly.

---

## 🧩 Problem Summary

You are given:

- `s`: the address typed by the user (length = `k`)
- `n`: number of potential addresses
- For each potential address `cᵢ`, compute an **error value F**

### 🔎 How Error Function F Works

For each character `c[i]` in the potential address:

1. Find all positions `j` in `s` where `s[j] == c[i]`
2. Use the **closest** such `j`
3. Add `|i - j|` to the score

If the character **does not appear** anywhere in `s`:
- |c|   (length of c)

  Finally, output the computed F for each potential address.

---

## ⚙️ Key Observations

- Preprocessing matters.  
  We store the positions of each letter in `s` → `pos[26]`.
- For each letter in `c`:
  - Binary search to find the closest index.
  - Efficient due to sorted positions.
- Total input length ≤ 2×10⁵ → solution must be O(total_length × log k)

---

## 🧠 Approach Summary

1. Precompute index lists for characters in `s`.
2. For each potential address:
   - For every character, retrieve its positions in `s`.
   - If empty → add `len(c)`
   - Else → binary search nearest position
3. Sum all differences → output final F.

---

## 💻 Java Implementation

```java
import java.io.*;
import java.util.*;

public class TyndexBrome {
    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();

        List<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        while (n-- > 0) {
            String c = in.next();
            long ans = 0;
            int len = c.length();

            for (int i = 0; i < len; i++) {
                int u = c.charAt(i) - 'a';
                List<Integer> list = pos[u];

                if (list.isEmpty()) {
                    ans += len;
                } else {
                    int idx = Collections.binarySearch(list, i);
                    if (idx >= 0) continue;

                    idx = -idx - 1;
                    int cur = Integer.MAX_VALUE;

                    if (idx < list.size()) cur = Math.min(cur, Math.abs(i - list.get(idx)));
                    if (idx > 0) cur = Math.min(cur, Math.abs(i - list.get(idx - 1)));

                    ans += cur;
                }
            }
            out.println(ans);
        }
        out.flush();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(total_length × log k)`
- **Space Complexity:** `O(k)`
