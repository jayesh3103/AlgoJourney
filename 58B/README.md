# 🪙 Coins – Codeforces Practice

This is my solution for the **Coins** problem from Codeforces.  
This README explains my **approach, logic, and implementation** clearly and concisely.

---

## 📄 Problem Description

You are given the denomination `n` of the **most expensive coin** in Berland.

You must design a full coin system such that:

- The **largest coin is exactly `n`**.
- Every coin's value must be **divisible by any cheaper coin**.
- All coin denominations must be **distinct**.
- The chosen system must contain the **maximum possible number of coins**.

You must output the list of coin denominations in **decreasing order**.

---

## 💡 Approach

To maximize the number of coins, we need to generate the **longest chain**:
- `n → n/div1 → (n/div1)/div2 → … → 1`
Where each next coin is the result of dividing the previous coin by its **smallest divisor** (other than 1).

### Why smallest divisor?
- Dividing by the *smallest divisor* creates the **largest possible sequence**.
- This guarantees the chain ends at **1**, producing maximum coins.
- The divisibility condition automatically holds because each next coin divides the previous one.

### Steps followed:

1. **Print `n` first** (largest coin).
2. While `n > 1`:
   - Find the **smallest divisor** of `n`.  
   - Divide `n` by this divisor.
   - Print the result.
3. Stop when the sequence reaches `1`.

This greedy approach ensures:
- Valid divisibility constraints.
- Maximum chain length.
- Fully descending order by construction.

---

## 🖥️ Implementation (Java)

```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        out.print(n);

        while (n > 1) {
            int div = n;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    div = i;
                    break;
                }
            }
            n /= div;
            out.print(" " + n);
        }
        
        out.println();
        out.flush();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
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
- **Time Complexity:** `O( √n * log n )`
- **Space Complexity:** `O(1)`
