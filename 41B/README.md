# 💰 B. Martian Dollar – Codeforces Practice

This is my solution for the **B. Martian Dollar** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

Vasya knows the **exchange rate of the Martian dollar** for the next `n` days.  
On day `i`, the **buying** and **selling** prices of one dollar are the same and equal to `a[i]`.

Vasya starts with **b bourles** and can:
- **Buy** an integer number of dollars on one day.
- **Sell** all the dollars on another day (or not sell at all).
- Perform **at most one buy and one sell** transaction.

Your task is to determine the **maximum number of bourles** Vasya can have by the end of day `n`.

---

## 💡 Approach

1. **Track Minimum Price:**
   - Maintain the lowest price seen so far (`minPrice`).
   - This represents the best possible day to buy before any given day.

2. **Simulate Potential Sale:**
   - For each day’s price `price`:
     - Assume Vasya bought at `minPrice` and sells at `price`.
     - Compute the number of dollars he can buy:
       ```
       dollars = b / minPrice
       leftover = b % minPrice
       ```
     - If sold on that day:
       ```
       total = dollars * price + leftover
       ```
     - Keep track of the **maximum** of all possible totals.

3. **Edge Case:**
   - If prices only fall or stay constant, Vasya should **not trade** at all (keep his original `b`).

---

## 🧠 Core Idea

> To maximize Vasya’s profit, he should always buy at the **lowest price seen so far** and sell later at the **highest price** that follows.

This is a **greedy approach**, solved efficiently in a single pass.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int b = in.nextInt();
            
            int maxMoney = b;       // Best total found so far
            int minPrice = 2001;    // Initialize with a large number

            for (int i = 0; i < n; i++) {
                int price = in.nextInt();
                minPrice = Math.min(minPrice, price);
                
                int dollars = b / minPrice;
                int leftover = b % minPrice;
                int currentTotal = dollars * price + leftover;
                
                maxMoney = Math.max(maxMoney, currentTotal);
            }

            System.out.println(maxMoney);
        }
    }
}
```
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`
