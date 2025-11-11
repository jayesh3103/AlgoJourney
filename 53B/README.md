# 🖼️ Blog Photo – Codeforces Practice

This is my solution for the **Blog Photo** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

A blogging site automatically **crops uploaded photos** according to specific rules:

1. The **height-to-width ratio** must be between **0.8 and 1.25** (inclusive).  
2. At least one side (either height or width) must be a **power of 2** (`2^x` for some integer x).  
3. Among all valid cropped areas:
   - Choose the one with the **maximum area**.
   - If multiple areas have the same area, choose the one with the **maximum height**.  
4. Both height and width of the cut must be integers.  

Given the original **height (h)** and **width (w)** of the photo, find the dimensions of the cropped area.

---

## 💡 Approach

1. **Iterate over possible powers of 2** for both height and width:
   - For every power of 2 ≤ `h`, treat it as a potential height (`ch`).
   - For every power of 2 ≤ `w`, treat it as a potential width (`cw`).

2. **Determine the valid range** for the other dimension:
   - If height = `ch`, then valid width `cw` must satisfy:  
     `0.8 × cw ≤ ch ≤ 1.25 × cw`
   - Rewritten as:  
     ```
     minW = ceil(0.8 × ch)
     maxW = floor(1.25 × ch)
     ```
   - Similarly when width = `cw`.

3. **Check bounds** within the original photo’s dimensions (`h`, `w`).  
   Choose the largest valid area `area = ch × cw`.  

4. **Update the best crop**:
   - Prefer **larger area**, and  
   - In case of a tie, prefer **greater height**.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            long h = in.nextLong();
            long w = in.nextLong();

            long bestH = 0;
            long bestW = 0;
            long bestArea = -1; 

            for (long ch = 1; ch <= h; ch *= 2) {
                long minW = (ch * 4 + 4) / 5;  
                long maxW = (ch * 5) / 4;      
                long cw = Math.min(w, maxW);

                if (cw >= minW) {
                    long area = ch * cw;
                    if (area > bestArea || (area == bestArea && ch > bestH)) {
                        bestArea = area;
                        bestH = ch;
                        bestW = cw;
                    }
                }
            }

            for (long cw = 1; cw <= w; cw *= 2) {
                long minH = (cw * 4 + 4) / 5;
                long maxH = (cw * 5) / 4;
                long ch = Math.min(h, maxH);

                if (ch >= minH) {
                    long area = ch * cw;
                    if (area > bestArea || (area == bestArea && ch > bestH)) {
                        bestArea = area;
                        bestH = ch;
                        bestW = cw;
                    }
                }
            }

            System.out.println(bestH + " " + bestW);
        }
    }
}
```
---
## ✅ Complexity

- **Time Complexity:** `O(log(h) + log(w))`
  - Since we only iterate over powers of 2 for height and width. 
- **Space Complexity:** `O(1)` 
