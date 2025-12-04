# 🍬 Problem of the Day — Partial Teacher

### 📅 Daily Codeforces Problem  
**A. Partial Teacher**  
A greedy two-pass evaluation problem that simulates how a partial teacher distributes toffees based on student marks comparison.

---

## 📝 Problem Summary  

A teacher has **n students** standing in a line. Between each pair of adjacent students, you're given a character:

- **'L'** → Left student has higher marks  
- **'R'** → Right student has higher marks  
- **'='** → Both students have equal marks  

Rules for toffee distribution:

- Every student gets **at least 1 toffee**.
- If student A has higher marks than student B  
  → Toffees(A) > Toffees(B)
- If marks are equal  
  → Toffees(A) = Toffees(B)

Your goal:  
Assign toffees to all students such that **all conditions are satisfied** and the **total number of toffees is minimum**.

---

## ⚙️ Approach  

We use a **two-pass greedy strategy**:

### 1️⃣ Left-to-right pass
Handles `'R'` and `'='` constraints:

- If `R`, then `toffees[i+1] = toffees[i] + 1`
- If `=`, then `toffees[i+1] = toffees[i]`

### 2️⃣ Right-to-left pass
Fixes `'L'` constraints:

- If `L`, then  
  `toffees[i] = max(toffees[i], toffees[i+1] + 1)`

This ensures all inequalities are satisfied while keeping the total minimized.

---

## 🧠 Code Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) ans[i] = 1;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == 'R') {
                ans[i + 1] = ans[i] + 1;
            } else if (s.charAt(i) == '=') {
                ans[i + 1] = ans[i];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == 'L') {
                ans[i] = Math.max(ans[i], ans[i + 1] + 1);
            } else if (s.charAt(i) == '=') {
                ans[i] = ans[i + 1];
            }
        }

        for (int i = 0; i < n; i++) System.out.print(ans[i] + " ");
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`
