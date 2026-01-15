# 🦭 Queue (Codeforces – Problem B)

## 📌 Problem Summary

There are **n walruses** standing in a queue at an airport.

- Walruses are numbered **from tail to head**:
  - `1` → end of the queue  
  - `n` → front of the queue
- Each walrus has an **age** `a[i]`

### 😠 Displeasure Rule

The **i-th walrus becomes displeased** if:
- There exists a walrus **in front of him** (`j > i`)
- That walrus is **strictly younger** (`a[j] < a[i]`)

The **displeasure value** is:
> The number of walruses **between i and the furthest younger walrus ahead**

If **no younger walrus exists ahead**, output `-1`.

---

## 🧠 Key Insight

For each walrus `i`, we need to find:
- The **furthest index `j > i`** such that `a[j] < a[i]`

Efficient handling is required because:
- `n` can be up to **100,000**

---

## 💡 Optimized Approach

### Step 1: Suffix Minimum Array
Build an array `s[]` where:

s[i] = minimum age from index i to n-1

This allows us to quickly check:
- Whether **any younger walrus exists ahead**

---

### Step 2: Binary Search
For each walrus `i`:
- Binary search on range `(i+1 ... n-1)`
- Find the **largest index j** such that `s[j] < a[i]`

This gives the **furthest younger walrus**.

---

### Step 3: Output
- If found → print `j - i - 1`
- Else → print `-1`

---

## ✅ Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        // Build suffix minimum array
        int[] s = new int[n];
        s[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            s[i] = Math.min(a[i], s[i + 1]);
        }

        // Process each walrus
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                out.print("-1 ");
                continue;
            }

            int low = i + 1;
            int high = n - 1;
            int bestJ = -1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (s[mid] < a[i]) {
                    bestJ = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (bestJ != -1) {
                out.print((bestJ - i - 1) + " ");
            } else {
                out.print("-1 ");
            }
        }

        out.println();
        out.flush();
    }

    // Fast input reader
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String s = br.readLine();
                    if (s == null) return null;
                    st = new StringTokenizer(s);
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
- **Time Complexity:** `O(n log n)`
- **Space Complexity:** `O(n)`
