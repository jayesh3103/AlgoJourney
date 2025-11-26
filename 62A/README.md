# 🌙 A. A Student's Dream — Finger Arrangement Logic  
### 📅 Daily Codeforces Challenge — AlgoJourney

Today’s dream realm takes us into a **whimsical combinatorics puzzle** involving extraterrestrial anatomy, hand-holding etiquette, and the impending doom of a mathematical analysis exam.

---

## 🧩 Problem Summary  

A Venusian girl has:  
- `al` fingers on her **left** hand  
- `ar` fingers on her **right** hand  

A Martian boy has:  
- `bl` fingers on his **left** hand  
- `br` fingers on his **right** hand

When holding hands, they want to be **comfortable**, which means:

### 👩 Venusian girl’s constraint  
Between **any two of her fingers**, there must be **a boy’s finger**.  
This means:
- `girl_fingers ≤ boy_fingers + 1`
(Because g fingers require g−1 gaps → each gap must contain a boy’s finger.)

---

### 👦 Martian boy’s constraint  
No **three consecutive boy fingers** should touch.  
This creates:

- `boy_fingers ≤ 2 * girl_fingers + 2`
---

### 🔄 Orientation Doesn’t Matter  
Either:
- Girl-left + Boy-right ⟶ (al, br)  
- Girl-right + Boy-left ⟶ (ar, bl)

If **either** pairing satisfies the comfort constraints, the answer is **YES**.

---

## 🧠 Approach

Define a helper `check(g, b)` that verifies:

- `g ≤ b + 1`  
- `b ≤ 2g + 2`  

Test both valid orientations:
- (al, br)
- (ar, bl)

If any pass, print `YES`.

---

## 💻 Code Implementation (Java)

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int al = sc.nextInt();
        int ar = sc.nextInt();
        int bl = sc.nextInt();
        int br = sc.nextInt();
        
        if (check(al, br) || check(ar, bl)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    
    static boolean check(int g, int b) {
        return g <= b + 1 && b <= 2 * g + 2;
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`
