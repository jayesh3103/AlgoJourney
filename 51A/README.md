# 🧿 Cheaterius’s Problem – Codeforces Practice

This is my solution for the **Cheaterius’s Problem** from Codeforces.  
This README explains my **approach, reasoning, and implementation** behind the solution.

---

## 📄 Problem Description

Cheaterius, a cunning magician and self-proclaimed inventor, creates **amulets** — each represented as a 2×2 square divided into quarters.  
Each quarter contains a number between **1 and 6** (representing dots).

Two amulets are considered **similar** if one can be **rotated** by 90°, 180°, or 270° so that their corresponding positions match exactly.  
(Flipping or mirroring is **not allowed**.)

Your task is to determine how many **unique piles** of similar amulets exist.

---

## 💡 Approach

1. **Representation of each amulet:**  
   - Read the two lines of digits representing the 2×2 structure:
     ```
     a b
     c d
     ```
     These are stored as a 4-character string `"abcd"`.

2. **Generate all rotations:**  
   To account for similarity under rotation, generate four possible configurations:
   - 0° rotation: `abcd`  
   - 90° rotation: `cadb`  
   - 180° rotation: `dcba`  
   - 270° rotation: `bdac`  

3. **Canonical form:**  
   - Sort all four rotations lexicographically.  
   - Use the **smallest** string as the unique representative form of that amulet.

4. **Store unique forms:**  
   - Use a `HashSet` to store the canonical representations.
   - The final number of piles = size of the `HashSet`.

---

## 🖥️ Implementation (Java)

```java
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            Set<String> piles = new HashSet<>();
            
            for (int i = 0; i < n; i++) {
                String r1 = in.next();
                String r2 = in.next();
                
                char a = r1.charAt(0);
                char b = r1.charAt(1);
                char c = r2.charAt(0);
                char d = r2.charAt(1);
                
                String s1 = "" + a + b + c + d;
                String s2 = "" + c + a + d + b;  
                String s3 = "" + d + c + b + a;  
                String s4 = "" + b + d + a + c;  
                
                String[] rotations = {s1, s2, s3, s4};
                Arrays.sort(rotations);
                
                piles.add(rotations[0]);
                
                if (i < n - 1) {
                    in.next(); 
                }
            }
            
            System.out.println(piles.size());
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`
