# 📦 Where Are My Flakes? – Codeforces Practice

This is my solution for the **“Where Are My Flakes?”** problem from Codeforces.  
This README explains the **problem logic, thinking process, Java solution, and complexity**.

---

## 📄 Problem Summary

Cereal Guy’s roommate hid the cereal flakes inside **one of n boxes** arranged in a line.

He left **m hints**, each of the form:

- **"To the left of i"** → the flakes are in some box **strictly left** of box *i*  
- **"To the right of i"** → the flakes are in some box **strictly right** of box *i*  
- In both cases, **box i itself is NOT a candidate**

Your job:

### 🎯 Determine:
- The **minimum number of boxes that must be checked** that are consistent with all hints.
- If the hints contradict each other → print `-1`.

---

## 💡 Approach

We maintain a shrinking range **[l, r]** of possible boxes that can contain the flakes.

1. Initially:
- `l = 1`
- `r = n`
2. For each hint:
- `"To the left of i"` → flakes are in **[1, i-1]**  
  → update `r = min(r, i - 1)`
- `"To the right of i"` → flakes are in **[i+1, n]**  
  → update `l = max(l, i + 1)`

3. After processing all hints:
- If `l > r` → contradiction → answer = `-1`
- Otherwise → number of necessarily checked boxes:
  ```
  r - l + 1
  ```

This approach efficiently intersects hint constraints to find the possible region.

---

## 🖥️ Java Implementation

```java
import java.util.*;

public class Main {
 public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     
     int n = in.nextInt();
     int m = in.nextInt();
     
     int l = 1;
     int r = n;
     
     for (int k = 0; k < m; k++) {
         in.next(); 
         in.next(); 
         String dir = in.next();
         in.next(); 
         int val = in.nextInt();
         
         if (dir.equals("left")) {
             r = Math.min(r, val - 1);
         } else {
             l = Math.max(l, val + 1);
         }
     }
     
     if (l > r) {
         System.out.println("-1");
     } else {
         System.out.println(r - l + 1);
     }
 }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(m)`
- **Space Complexity:** `O(1)`
