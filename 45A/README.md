# 🎮 Codecraft III – Codeforces Practice

This is my solution for the **A. Codecraft III** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

Vasya is eagerly waiting for the release of his favorite game’s sequel, **Codecraft III**.  
He knows that it will release after exactly **k months** from the **current month**.

Given:
- The **current month’s name**
- The number of months `k` until the release

You must determine the **name of the release month**.

All months are standard English names:  
`January, February, March, April, May, June, July, August, September, October, November, December.`

---

### 🔢 Input
- The first line contains a string `s` — the **current month’s name**.  
- The second line contains an integer `k` — the **number of months** until Codecraft III appears.  
  - (0 ≤ k ≤ 100)

### 🧾 Output
- Print the **name of the month** (starting with a capital letter) in which the game will release.

---

## 💡 Approach

1. **Store the Months Sequentially:**
   - Use an array to store all 12 month names in order.

2. **Find the Index of the Current Month:**
   - Loop through the array to find the position of the given month `s`.

3. **Compute the Release Month:**
   - Add `k` to the current month’s index and use **modulo 12** to handle wrapping around the year.

4. **Output the Result:**
   - Print the month name at the calculated position.

---

## 🧠 Core Idea

> When dealing with circular or repeating data like months,  
> **modular arithmetic** provides an elegant and efficient solution.

The operation `(currentIndex + k) % 12` ensures that even if `k` exceeds 12,  
the counting wraps correctly to the start of the year.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
            };
            
            String s = in.next();
            int k = in.nextInt();
            
            int start = 0;
            for (int i = 0; i < 12; i++) {
                if (months[i].equals(s)) {
                    start = i;
                    break;
                }
            }
            
            int end = (start + k) % 12;
            System.out.println(months[end]);
        }
    }
}
```
---

## ✅ Complexity
- **Time Complexity:** `O(12)`
- **Space Complexity:** `O(1)`
