# 📘 B. Petya and Square – Codeforces Practice

This is my solution for the **Petya and Square** problem from Codeforces.  
This README explains the idea, reasoning, and implementation.

---

## 📄 Problem Description

Petya has a square of size:

2n × 2n  

One cell (x, y) is marked.

We must determine whether it is possible to draw a broken line along grid lines that:

- Cuts the square into two equal parts  
- The two parts are equal up to rotation  
- The cutting line does NOT pass through the marked cell  

---

## 💡 Key Observation

To split a 2n × 2n square into two rotationally equal halves:

The cut must pass through the center of the square.

In a 2n × 2n grid, the center is the 2×2 middle block:

Rows: n and n+1  
Columns: n and n+1  

So the four central cells are:

(n, n)  
(n, n+1)  
(n+1, n)  
(n+1, n+1)

If the marked cell is inside this central block:

→ Any symmetric cut would pass through it  
→ Therefore, answer is "NO"

Otherwise:

→ A valid cut always exists  
→ Answer is "YES"

---

## ⏱ Complexity

Time Complexity: O(1)  
Space Complexity: O(1)

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int n = size / 2;

        if ((x == n || x == n + 1) && (y == n || y == n + 1)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

        sc.close();
    }
}
