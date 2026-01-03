# 📌 B. Doctor

## 📅 Problem of the Day — Codeforces  

---

## 📝 Problem Summary

There are **n animals** standing in a queue to visit **Dr. Dolittle**.

- Animal `i` must visit the doctor exactly `a[i]` times.
- The animal at the front is examined:
  - If it still needs more visits, it goes to the **end of the queue**
  - Otherwise, it goes **home**
- Each examination takes a long time, so animals are processed **one by one**
- The doctor will stop working **after exactly `k` examinations**

Your task is to determine **what the queue looks like after `k` examinations**.

---

## 🎯 Objective

- If the **total required examinations < k**, print `-1`
- Otherwise, print the **remaining animals in queue order** after `k` examinations
- The output sequence may be empty

---

## 🧠 Key Insight

Direct simulation is impossible because:
- `k` can be as large as **10¹⁴**
- `n` can be **10⁵**

Instead, we observe:
- Each animal `i` contributes `min(a[i], x)` visits after `x` full rounds
- We can **binary search** on the number of full rounds completed

---

## 🧠 Strategy

1. Let `sum = Σ a[i]`
   - If `sum < k` → output `-1`
2. Binary search the **maximum full rounds `L`** such that:

Σ min(a[i], L) ≤ k

3. After `L` rounds:
- Remaining examinations = `k - Σ min(a[i], L)`
4. Build a list of animals with `a[i] > L`
5. Rotate the queue by the remaining examinations to get the final order

---

## 🧠 Why Binary Search Works

- The function

f(x) = Σ min(a[i], x)

is **monotonic**
- Binary search efficiently finds the largest valid `x`
- This avoids simulating each examination individually

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(n log max(a))` |
| **Space Complexity** | `O(n)` |

Efficient for large constraints.

---

## 💻 Java Implementation

```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
      FastScanner fs = new FastScanner();
      PrintWriter out = new PrintWriter(System.out);

      int n = fs.nextInt();
      long k = fs.nextLong();
      long[] a = new long[n];
      long sum = 0;

      for (int i = 0; i < n; i++) {
          a[i] = fs.nextLong();
          sum += a[i];
      }

      if (sum < k) {
          out.println("-1");
          out.flush();
          return;
      }

      long low = 0, high = 2_000_000_000L;
      long L = 0;

      while (low <= high) {
          long mid = (low + high) / 2;
          if (getSum(a, mid) <= k) {
              L = mid;
              low = mid + 1;
          } else {
              high = mid - 1;
          }
      }

      long used = getSum(a, L);
      long remaining = k - used;

      List<Integer> alive = new ArrayList<>();
      for (int i = 0; i < n; i++) {
          if (a[i] > L) {
              alive.add(i + 1);
          }
      }

      int sz = alive.size();
      for (int i = (int) remaining; i < sz; i++) {
          out.print(alive.get(i) + " ");
      }
      for (int i = 0; i < remaining; i++) {
          if (a[alive.get(i) - 1] > L + 1) {
              out.print(alive.get(i) + " ");
          }
      }

      out.flush();
  }

  static long getSum(long[] a, long limit) {
      long total = 0;
      for (long v : a) {
          total += Math.min(v, limit);
      }
      return total;
  }

  static class FastScanner {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer("");

      String next() {
          while (!st.hasMoreTokens()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  return null;
              }
          }
          return st.nextToken();
      }

      int nextInt() { return Integer.parseInt(next()); }
      long nextLong() { return Long.parseLong(next()); }
  }
}
