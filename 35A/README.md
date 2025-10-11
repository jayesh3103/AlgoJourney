# 🐚 Shell Game – Codeforces Practice

This is my solution for the **Shell Game** problem from Codeforces. This README explains my approach, implementation, and reasoning behind the solution.  

---

## 📄 Problem Description

- There are **3 cups**, numbered 1, 2, and 3.  
- A **ball is placed under one cup**.  
- The performer performs **3 shuffles**, each swapping two cups.  
- After the shuffles, we need to find **which cup contains the ball**.  
- Cups are renumbered left-to-right after each shuffle.

---

## 💡 Approach

1. **Track the position of the ball** using a variable (`pos`).  
2. For each shuffle:  
   - Read the two cup indices that are swapped (`a` and `b`).  
   - If the ball is under **cup `a`**, move it to `b`.  
   - If the ball is under **cup `b`**, move it to `a`.  
   - If the ball is under any other cup, it **remains in the same position**.  
3. After all 3 shuffles, `pos` holds the **final position of the ball**.  

> This approach works because the ball **only moves if it is under a cup that is being swapped**, otherwise its position does not change.

---

## 🖥️ Implementation (Java)

```java
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {
            
            int pos = in.nextInt(); // Initial position of the ball
 
            for (int i = 0; i < 3; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
 
                if (pos == a) {
                    pos = b;
                } else if (pos == b) {
                    pos = a;
                }
            }
 
            out.println(pos); // Final position of the ball
        }
    }
}
```

---

## ✅ Complexity

- **Time Complexity:** `O(1)` — only 3 shuffles, fixed number of operations.  
- **Space Complexity:** `O(1)` — uses just a single variable to store the ball position.  

