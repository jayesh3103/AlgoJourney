# 🟦 Codeforces Problem: B. Squares

## 📌 Problem Summary

You are given an infinite 2D grid and need to move from point **(x₁, y₁)** to **(x₂, y₂)**. Movement is allowed in four directions (up, down, left, right).

Some cells are marked as **bad** if they satisfy either of the following:

- |x + y| ≡ 0 (mod 2a)
- |x − y| ≡ 0 (mod 2b)

Your goal is to find the **minimum number of bad cells** you must pass through on any path from the start to the destination.

---

## 💡 Key Insight

Instead of simulating paths (which is infeasible due to large constraints), we:

1. Transform coordinates:
   - `u = x + y`
   - `v = x - y`

2. Bad cells appear periodically:
   - Along `u` every `2a`
   - Along `v` every `2b`

3. Count how many "bad lines" are crossed between start and end:
   - Compute divisions using floor division
   - Take absolute difference

4. Final answer is:
# 🟦 Codeforces Problem: B. Squares

## 📌 Problem Summary

You are given an infinite 2D grid and need to move from point **(x₁, y₁)** to **(x₂, y₂)**. Movement is allowed in four directions (up, down, left, right).

Some cells are marked as **bad** if they satisfy either of the following:

- |x + y| ≡ 0 (mod 2a)
- |x − y| ≡ 0 (mod 2b)

Your goal is to find the **minimum number of bad cells** you must pass through on any path from the start to the destination.

---

## 💡 Key Insight

Instead of simulating paths (which is infeasible due to large constraints), we:

1. Transform coordinates:
   - `u = x + y`
   - `v = x - y`

2. Bad cells appear periodically:
   - Along `u` every `2a`
   - Along `v` every `2b`

3. Count how many "bad lines" are crossed between start and end:
   - Compute divisions using floor division
   - Take absolute difference

4. Final answer is:

max(bad crossings in u, bad crossings in v)


---

## 🚀 Approach

- Convert both points to `(u, v)` space
- Count how many multiples of `2a` and `2b` lie between them
- Answer = `max(count_u, count_v)`

---

## 🧠 Complexity

- Time Complexity: **O(1)**
- Space Complexity: **O(1)**

---

## ✅ Java Implementation

```java
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     
     if (sc.hasNextLong()) {
         long a = sc.nextLong();
         long b = sc.nextLong();
         long x1 = sc.nextLong();
         long y1 = sc.nextLong();
         long x2 = sc.nextLong();
         long y2 = sc.nextLong();
         
         // Transform coordinates
         long u1 = x1 + y1;
         long v1 = x1 - y1;
         long u2 = x2 + y2;
         long v2 = x2 - y2;
         
         long periodA = 2 * a;
         long periodB = 2 * b;
         
         // Count bad crossings
         long bu = Math.abs(Math.floorDiv(u1, periodA) - Math.floorDiv(u2, periodA));
         long bv = Math.abs(Math.floorDiv(v1, periodB) - Math.floorDiv(v2, periodB));
         
         // Minimum bad cells encountered
         System.out.println(Math.max(bu, bv));
     }
     
     sc.close();
 }
}
