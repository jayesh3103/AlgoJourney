# 🏐 Ball Game – Codeforces Practice

This is my solution for the **A. Ball Game** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

A kindergarten teacher, **Natalia Pavlovna**, invented a new **ball game** to help children learn counting while playing.  
Here’s how it works:

- There are `n` children standing in a **circle**, numbered from **1 to n**.
- The game starts with **child 1 holding the ball**.
- The throwing pattern works as follows:
  - **1st throw:** to the next child (i.e., +1 step).
  - **2nd throw:** to the child **2 steps ahead**.
  - **3rd throw:** to the child **3 steps ahead**, and so on.
- The counting wraps around the circle (so modulo arithmetic applies).
- The game continues for exactly **n − 1 throws**.

Your task is to determine the **child numbers** that receive the ball **after each throw**.

---

### 🔢 Input
- A single integer `n` — the number of children.  
  - (2 ≤ n ≤ 100)

### 🧾 Output
- Print `n − 1` integers separated by spaces —  
  the **numbers of children** who get the ball after each throw.

---

## 💡 Approach

1. **Initialize the Game:**
   - Start with the ball at position `0` (representing child 1).
   - Distance for the first throw is `1`.

2. **Simulate the Throws:**
   - For each throw `i` (from 1 to n−1):
     - Move the ball ahead by `i` positions.
     - Use **modulo `n`** to wrap around the circle.
     - Record which child gets the ball.

3. **Output the Sequence:**
   - Use a `StringBuilder` for efficient string concatenation.
   - Print all positions (converted to 1-based indexing).

---

## 🧠 Core Idea

> The essence of this problem is **circular movement** —  
> each throw moves ahead by an increasing step count, looping around the circle.

This naturally translates to using **modular arithmetic**,  
since `(current_position + distance) % n` ensures the index stays within bounds.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int pos = 0;
        int dist = 1;
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            pos = (pos + dist) % n;
            sb.append(pos + 1);
            if (i < n - 2) {
                sb.append(" ");
            }
            dist++;
        }

        System.out.println(sb.toString());
        in.close();
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`
