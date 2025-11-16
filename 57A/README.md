# 🟦 A. Square Earth? – Codeforces Practice

This is my solution for the **Square Earth?** problem from Codeforces.  
This README explains the **logic, reasoning, and Java implementation** behind the solution.

---

## 📄 Problem Summary

Meg models the Earth as a **square of side `n`**.  
Two points lie **somewhere on the boundary** of this square.

Your task:  
👉 **Compute the shortest boundary distance** between these two points.

Square corners:  
- (0, 0), (n, 0), (0, n), (n, n)

Points can lie anywhere on the **square’s edges**.

---

## 💡 Key Insight

Walking along the boundary of a square is equivalent to walking on a **1-D loop** of length `4n`.

### 🔑 Steps:

1. **Convert each 2-D boundary coordinate** into its corresponding **1-D perimeter position**:
   - Bottom edge → `x`
   - Right edge → `n + y`
   - Top edge → `2n + (n - x)`
   - Left edge → `3n + (n - y)`

2. Once both points are mapped to positions `pos1` and `pos2`:
   - Direct distance: `|pos1 - pos2|`
   - Wrap-around distance: `4n - |pos1 - pos2|`
   - **Shortest distance = minimum of these two**

This elegantly transforms the geometry problem into a perimeter-walking problem.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    
    private static int getPos(int n, int x, int y) {
        if (y == 0) return x;                     
        if (x == n) return n + y;                  
        if (y == n) return 2*n + (n - x);          
        if (x == 0) return 3*n + (n - y);          
        return 0;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            
            int pos1 = getPos(n, x1, y1);
            int pos2 = getPos(n, x2, y2);
            
            int dist = Math.abs(pos1 - pos2);
            
            System.out.println(Math.min(dist, 4 * n - dist));
        }
    }
}
```
---
## ✅ Complexity:
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`
