# 🎁 Presents – Codeforces Practice

This is my solution for the **Presents** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

The Hedgehog loves both **giving and receiving presents**.  
He received one today, but now he wonders — how many more will he receive over the next **N days**?

He follows two rules:
1. On every **holiday day**, he **definitely receives a present**.  
2. He receives a present **at least once every K days** — meaning if he got one on day `i`, the next must come no later than day `i + K`.

Your task is to compute the **minimum number of presents** he will receive in the next `N` days,  
**excluding today’s present**.

---

## 💡 Approach

1. **Input parsing:**
   - Read integers `N` (number of days) and `K` (max gap between presents).
   - Read the number of holidays `C` and their respective day numbers.

2. **Mark holiday days:**
   - Create an array `holidays[]` of size `N + 1` where `holidays[i] = 1` if day `i` is a holiday.

3. **Iterate through days:**
   - Keep track of the last day a present was received (`lastDay`).
   - For each day:
     - If it’s a **holiday**, he receives a present.  
     - Otherwise, if `day - lastDay == K`, he must get a present to satisfy the “every K days” rule.
   - Increment `presents` accordingly.

4. **Output:**
   - Print the total number of presents received during the next `N` days.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();
            int c = in.nextInt();
            
            int[] holidays = new int[n + 1];
            for (int i = 0; i < c; i++) {
                holidays[in.nextInt()] = 1;
            }
            
            int presents = 0;
            int lastDay = 0; 
            
            for (int day = 1; day <= n; day++) {
                if (holidays[day] == 1) {
                    presents++;
                    lastDay = day;
                } else if (day - lastDay == k) {
                    presents++;
                    lastDay = day;
                }
            }
            
            System.out.println(presents);
        }
    }
}
```
---
## ✅ Complexity

- **Time Complexity:** `O(n)` 
- **Space Complexity:** `O(n)`  
