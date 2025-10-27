# 🥤 Cola – Codeforces Practice

This is my solution for the **B. Cola** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

To celebrate the opening of the **Winter Computer School**, the organizers decided to buy **n liters of cola**.  
However, the store sells cola only in bottles of:

- **0.5 liters**
- **1 liter**
- **2 liters**

There are:
- `a` bottles of 0.5 L  
- `b` bottles of 1 L  
- `c` bottles of 2 L  

All bottles of the same size are **indistinguishable**, and the goal is to count **how many distinct ways** the organizers can buy **exactly n liters of cola**.

If it’s **impossible** to reach exactly `n` liters, output `0`.

---

### 🔢 Input
- A single line containing four integers:
n a b c
where  
- `n` = total liters required  
- `a` = number of 0.5 L bottles  
- `b` = number of 1 L bottles  
- `c` = number of 2 L bottles  

### 🧾 Output
- Print the **number of ways** to buy exactly `n` liters of cola.  
- If not possible, print **0**.

---

## 💡 Approach

1. **Convert All Volumes to Half-Liters:**  
 - Since 0.5 L is the smallest unit, convert all capacities to half-liters:  
   - 0.5 L → 1 unit  
   - 1 L → 2 units  
   - 2 L → 4 units  
   - Target: `n * 2` units

2. **Iterate Over Possible 2L and 1L Combinations:**
 - For every number of 2L bottles used (`i` from `0` to `c`):
   - For every number of 1L bottles used (`j` from `0` to `b`):
     - Calculate remaining half-liters needed:
       ```
       rem = target - (i * 4) - (j * 2)
       ```
     - If `rem < 0`, break (since larger `j` will only increase it).
     - If `rem <= a`, it’s a valid combination.

3. **Count Valid Combinations:**
 - Increment `count` for every valid `(i, j)` combination satisfying the requirement.

---

## 🧠 Core Idea

> Reduce the problem to counting all valid integer combinations  
> that satisfy `4*i + 2*j + 1*k = target` under bottle limits.

Since the smallest measure is 0.5 L, using **integer units** simplifies calculations and avoids floating-point errors.  
By iterating smartly and checking feasibility, we efficiently count all valid purchase combinations.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
      try (Scanner in = new Scanner(System.in)) {
          int n = in.nextInt();
          int a = in.nextInt();
          int b = in.nextInt();
          int c = in.nextInt();

          long count = 0;
          int target = n * 2; 

          for (int i = 0; i <= c; i++) {
              for (int j = 0; j <= b; j++) {
                  int rem = target - (i * 4) - (j * 2);

                  if (rem < 0) {
                      break;
                  }

                  if (rem <= a) {
                      count++;
                  }
              }
          }

          System.out.println(count);
      }
  }
}

```
---

## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`
