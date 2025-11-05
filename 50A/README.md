# 🎲 Domino Piling – Codeforces Practice

This is my solution for the **Domino Piling** problem from Codeforces.  
This README explains my **approach, reasoning, and implementation** behind the solution.

---

## 📄 Problem Description

You are given a rectangular board of **M × N** squares and an unlimited number of **2 × 1** dominoes.  
Your goal is to place as many dominoes as possible such that:

1. Each domino covers exactly two squares.  
2. No two dominoes overlap.  
3. Each domino lies entirely within the board (touching edges is allowed).

You need to find the **maximum number of dominoes** that can be placed under these conditions.

---

## 💡 Approach

1. Each domino covers **2 squares**.  
2. The total number of squares on the board = `M × N`.  
3. Therefore, the **maximum number of dominoes** = ⌊(M × N) / 2⌋  
   - This is simply **integer division** in Java.  
   - The result automatically accounts for odd-sized boards.

### Example Intuition:
- For a 2 × 4 board → 8 squares → 8 / 2 = 4 dominoes  
- For a 3 × 3 board → 9 squares → 9 / 2 = 4 dominoes (since half a domino isn’t possible)

> This problem beautifully demonstrates how **mathematical reasoning** can simplify what first appears to be a combinatorial placement puzzle.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        System.out.println(m * n / 2);
    }
}
```
---
## ✅ Complexity

- **Time Complexity:** `O(1)` 
- **Space Complexity:** `O(1)`  
