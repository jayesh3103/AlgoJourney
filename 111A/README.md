# 📘 A. Petya and Inequations – Codeforces Practice

This is my solution for the **Petya and Inequations** problem from Codeforces.  
This README explains my approach, reasoning, and implementation.

---

## 📄 Problem Description

We need to find **n positive integers**:

a1, a2, ..., an  

Such that:

1) a1² + a2² + ... + an² ≥ x  
2) a1 + a2 + ... + an ≤ y  

If it is impossible, print:

-1

If multiple solutions exist, print any.

---

## 💡 Approach

- The minimum possible sum of n positive integers is **n** (all ones).
- If y < n → impossible.

To maximize the sum of squares while keeping the total sum small:

- Set (n - 1) numbers to 1
- Put the remaining value into the last number

Let:

lastNumber = y - (n - 1)

Then:

Sum = y  
Sum of squares = (n - 1) + lastNumber²  

If:

(n - 1) + lastNumber² ≥ x  

→ valid solution  
Otherwise → print -1

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = sc.nextLong();
        long x = sc.nextLong();
        long y = sc.nextLong();

        // Minimum possible sum is n (all ones)
        if (y < n) {
            System.out.println("-1");
            return;
        }

        long lastNumber = y - (n - 1);
        long sumOfSquares = (n - 1) + lastNumber * lastNumber;

        if (sumOfSquares >= x) {
            for (int i = 0; i < n - 1; i++) {
                out.println(1);
            }
            out.println(lastNumber);
        } else {
            out.println("-1");
        }

        out.flush();
        out.close();
    }
}
