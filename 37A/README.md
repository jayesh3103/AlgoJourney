# 🏗️ Towers – Codeforces Practice

This is my solution for the **Towers** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

- Vasya has **N wooden bars**, each with a certain length.  
- Bars can be stacked on top of each other **only if their lengths are equal**.  
- Vasya wants to build:
  - The **minimal number of towers**, and  
  - Find the **height of the tallest tower**.  

Your task is to determine:
1. The **maximum height** (number of bars in the tallest tower).  
2. The **total number of towers** built using all bars.

---

## 💡 Approach

1. **Count frequencies:**  
   - Use an integer array `counts[1001]` to count how many bars have each possible length.  

2. **Determine results:**  
   - The **tallest tower height** = maximum frequency among all lengths.  
   - The **number of towers** = count of distinct lengths (i.e., lengths that appear at least once).  

3. **Output the results:**  
   - Print:  
     ```
     <max height> <number of towers>
     ```

> This approach leverages frequency counting — a simple yet powerful technique for aggregation-based problems.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] counts = new int[1001];

        for (int i = 0; i < n; i++) {
            counts[in.nextInt()]++;
        }

        int maxH = 0;
        int towers = 0;

        for (int c : counts) {
            if (c > 0) {
                towers++;
                maxH = Math.max(maxH, c);
            }
        }

        System.out.println(maxH + " " + towers);
        in.close();
    }
}

```

---

## ✅ Complexity

- **Time Complexity:** `O(n+k)` 
- **Space Complexity:** `O(k)`  
