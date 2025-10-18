# 📈 Company Income Growth – Codeforces Practice

This is my solution for the **Company Income Growth** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

Petya, a PR manager at **BerSoft**, needs to demonstrate the company’s income growth from 2001 to the current year.  
He knows the company’s real incomes for each year, but he wants to show a **perfectly linear growth** —  
where income in year 2001 is **1 billion bourles**, in 2002 is **2 billion**, and so on.

However, the real data may not follow this perfect pattern (and may even include **negative values**).  
So, Petya decides to **ignore** some years and keep only a **subsequence** of years that fits the perfect growth rule.

Your task is to determine the **longest subsequence** of years where:
- income in year y1 = 1
- income in year y2 = 2
- income in year y3 = 3

and print the corresponding years.

If no such subsequence exists, print `0`.

---

## 💡 Approach

1. **Initialize the expected income:**  
   - Start with `target = 1`, representing the income expected for the first year in the perfect sequence.

2. **Iterate through all years:**  
   - For each year `(2001 + i)`:
     - If the income equals `target`, include that year in the subsequence.
     - Increment `target` by 1.

3. **Store and print results:**  
   - Keep a list of all years that match the growing sequence.  
   - Output:
     - The length of the subsequence (`k`).
     - The actual list of years.

> This is a **greedy sequential matching** approach — once a year satisfies the current expected income, it’s added, and we move to the next expected income value.

---

## 🖥️ Implementation (Java)

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int target = 1;
        List<Integer> years = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int income = in.nextInt();
            int year = 2001 + i;

            if (income == target) {
                years.add(year);
                target++;
            }
        }

        System.out.println(years.size());
        
        if (!years.isEmpty()) {
            for (int i = 0; i < years.size(); i++) {
                System.out.print(years.get(i));
                if (i < years.size() - 1) System.out.print(" ");
            }
        }
        
        in.close();
    }
}

```
---

## ✅ Complexity

- **Time Complexity:** O(n) 
- **Space Complexity:** O(k)
