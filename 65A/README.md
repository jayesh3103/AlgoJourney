# 🪄 A. Harry Potter and Three Spells

## 📌 Problem Summary  
Harry has three spells:

1. Convert **a grams of sand → b grams of lead**
2. Convert **c grams of lead → d grams of gold**
3. Convert **e grams of gold → f grams of sand**

Ron thinks:  
> “If we cycle these transformations, we can make infinite gold!”

Hermione thinks:  
> “Impossible. Conservation of matter prevents infinite mass.”

We must decide:  
➡️ Is it possible to start with *some finite amount of sand* and generate **arbitrarily large gold**?

Output **"Ron"** if infinite gold is possible, otherwise **"Hermione"**.

---

## 🧠 Key Insight  
This is a **cycle efficiency problem**.

Consider the **full cycle**:

> sand → lead → gold → sand


If this gain > 1 ⇒ each full cycle produces more sand than before ⇒ we can repeat indefinitely ⇒ **infinite gold** is possible.

### But edge cases matter:

- If any spell requires input that is zero, the cycle may "get sand/lead/gold from nothing".
- If **any spell produces something without consuming**, infinite mass is also possible.
- If certain steps have zero output, the entire chain may break.

Thus the logic is not only about gain > 1, but also about **degenerate spells**:
- A conversion like `x = 0 → y > 0` means mass creation from nothing.

---

## ✔️ Mathematical Condition for Infinite Gold  

### Infinite generation is possible **if any of these are true**:

1. **Lead → gold spell creates gold from nothing:**  
   - `c == 0 and d > 0` ⇒ produces gold without lead ⇒ infinite gold immediately.

2. **Gold → sand spell creates sand from nothing:**  
   - `e == 0 and f > 0`  
   - From infinite sand, produce lead/gold cycles → infinite gold possible.

3. **Sand → lead spell creates lead from nothing:**  
   - `a == 0 and b > 0`


If yes ⇒ **Ron**, else **Hermione**.

Your implementation covers all these cases perfectly.

---


## 🚀 Java Implementation  

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        if (d == 0) {
            System.out.println("Hermione");
        } else if (c == 0) {
            System.out.println("Ron");
        } else if (a == 0) {
            System.out.println(b > 0 ? "Ron" : "Hermione");
        } else if (e == 0) {
            System.out.println(f > 0 && b > 0 ? "Ron" : "Hermione");
        } else {
            if ((long)b * d * f > (long)a * c * e) {
                System.out.println("Ron");
            } else {
                System.out.println("Hermione");
            }
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`
