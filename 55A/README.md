# 🪰 Flea Travel – Codeforces Practice

This is my solution for the **Flea Travel** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

A flea is sitting on one of **n hassocks** arranged in a circle.

- After minute **k**, the flea jumps **k−1 hassocks clockwise**.  
- Example:  
  - Minute 1 → jump 0 hassocks → moves to next  
  - Minute 2 → jump 1 hassock  
  - Minute 3 → jump 2 hassocks  
  - … and so on  

The flea keeps jumping **forever**, and we must determine:

### ❓ Will the flea visit **all** hassocks eventually?

Your task is to output:

- `"YES"` — if every hassock will be visited  
- `"NO"` — otherwise  

---

## 💡 Approach

The flea lands on positions determined by:
- sum = 1 + 2 + 3 + … + k  =  k(k+1)/2
- position = sum mod n

A classical number theory result shows:

### 👉 The flea visits all hassocks **iff** `n` is a power of 2.

Reason:

- If `n` has any **odd divisor**, the sequence `k(k+1)/2 mod n` enters a cycle early and can't reach all positions.
- If `n` is a **power of 2**, the sequence cycles through *all* residues — meaning it covers the entire circle.

### ✔️ So the check becomes:

Keep dividing `n` by 2 while it's even.  
If the final value becomes `1`, then `n` was a power of 2 → answer is `"YES"`.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        while (n > 1 && n % 2 == 0) {
            n /= 2;
        }
        
        if (n == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        in.close();
    }
}
```
---

## ✅ Complexity

- **Time Complexity:** `O(log n)` 
- **Space Complexity:** `O(1)`
