# 🧮 Problem: Triangular Numbers

### 📘 Problem Statement
A **triangular number** represents the total number of dots that can form an equilateral triangle when arranged uniformly.  
Formally, the *n-th triangular number* is defined as:

Tn = (n * (n + 1)) / 2

Your task is to determine whether a given integer `n` is a triangular number or not.

---

### 🧩 Input Format
- A single integer `n` (1 ≤ n ≤ 500).

### 🧾 Output Format
- Print `"YES"` if the number is a triangular number.
- Print `"NO"` otherwise.

---
#### Explanation:
For `n = 3`,  
triangular numbers sequence = `1, 3, 6, 10, 15, ...`  
Since 3 appears in the sequence, it is a **triangular number**.

---

### 🧠 Approach
To check if `n` is triangular, we can generate triangular numbers iteratively:
1. Start with a sum of `0`.
2. Incrementally add natural numbers (`1, 2, 3, ...`) to the sum.
3. Stop once the sum reaches or exceeds `n`.
4. If at any point the sum equals `n`, it’s a triangular number.

Alternatively (mathematically),  
we could solve for integer `k` in the quadratic equation:

\[
k(k + 1)/2 = n
\]

and check if `k` is a natural number — but the iterative method is more intuitive for small limits.

---

### 💻 Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int sum = 0;
        for (int k = 1; sum < n; k++) {
            sum += k;
        }
        
        if (sum == n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        in.close();
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(√n)`
- **Space Complexity:** `O(1)`
