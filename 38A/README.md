# 🪖 Army – Codeforces Practice

This is my solution for the **Army** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

- There are **n military units**, each represented by a number.  
- The difference between adjacent units represents the **distance** between them.  
- Given integers `a` and `b`, you need to find the **total difference** (sum of distances) between the units from position `a` to position `b - 1`.

Your task is to compute:
> The **sum of all differences** between `a` and `b-1`.

---

## 💡 Approach

1. **Read input values:**  
   - The first integer `n` — number of units.  
   - The next `n-1` integers — differences between consecutive units.  
   - Finally, integers `a` and `b` — the range (1-indexed) to calculate the sum for.

2. **Compute total difference:**  
   - Initialize `sum = 0`.  
   - Loop from `i = a` to `b - 1` and accumulate `sum += d[i]`.

3. **Output the result:**  
   - Print the total sum.

> The logic is straightforward — you only sum the relevant segment of the difference array between the given indices.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] d = new int[n];
        
        for (int i = 1; i < n; i++) {
            d[i] = in.nextInt();
        }

        int a = in.nextInt();
        int b = in.nextInt();
        int sum = 0;

        for (int i = a; i < b; i++) {
            sum += d[i];
        }

        System.out.println(sum);
        in.close();
    }
}
```

---

## ✅ Complexity

- **Time Complexity:** `O(n)` 
- **Space Complexity:** `O(n)` 
