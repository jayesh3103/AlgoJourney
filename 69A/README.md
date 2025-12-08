# 🧪 A. Young Physicist — Solution

## 📌 Problem Summary
Vasya forgot to complete his physics homework. His teacher gives him a task:  
Determine whether a body at the origin `(0, 0, 0)` is in **equilibrium** after applying **n** force vectors.

A body is in equilibrium **iff** the sum of all x-components, y-components, and z-components is **zero**:

If all three sums are zero, print **"YES"**, otherwise print **"NO"**.

---

## 🏗️ Approach

The idea is straightforward:

1. Read `n`, the number of force vectors.
2. Maintain three running sums:  
   - `x` = total x-components  
   - `y` = total y-components  
   - `z` = total z-components  
3. Loop through all vectors and update the sums.
4. After processing all inputs:
   - If `x == 0 && y == 0 && z == 0` → **Equilibrium → print "YES"**
   - Else → **Not in equilibrium → print "NO"**

This solution works because equilibrium means the **resultant force vector is zero**, meaning no movement.

---

## ⏱️ Time Complexity

### **Time Complexity: O(n)**
- We process each of the `n` vectors exactly once.
- Each iteration performs a constant amount of work.

### **Space Complexity: O(1)**
- We only store three integers (`x`, `y`, `z`) regardless of input size.
- No additional arrays or data structures are used.

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int x = 0;
        int y = 0;
        int z = 0;
        
        for (int i = 0; i < n; i++) {
            x += sc.nextInt();
            y += sc.nextInt();
            z += sc.nextInt();
        }
        
        if (x == 0 && y == 0 && z == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
