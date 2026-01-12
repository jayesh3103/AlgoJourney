# 🚠 A. Cableway

## 📘 Problem Description
A group of university students wants to reach the top of a mountain using a cableway system.

The cableway has cablecars that:
- Arrive **every minute**
- Are painted cyclically in the order: **Red → Green → Blue → Red → ...**
- The **first cablecar at time 0 is Red**
- Each cablecar can carry **at most 2 students**
- Each ride takes **exactly 30 minutes**

The students are divided into three groups:
- `r` students will ride **only Red** cablecars
- `g` students will ride **only Green** cablecars
- `b` students will ride **only Blue** cablecars

A student never rides a cablecar of another color.

### 🎯 Objective
Determine the **minimum time** required for **all students** to reach the top of the mountain.

---

## 🧠 Key Observations
- Cablecars of the same color arrive every **3 minutes**
- Since each cablecar can carry **2 students**, the number of required trips for a color is:

trips = ceil(students / 2)

- The **last student of each color** determines the total time
- Final answer is the **maximum arrival time** among all colors

---

## 🧮 Time Calculation Per Color
| Color  | First Arrival | Pattern |
|------|---------------|---------|
| Red   | 0             | 0, 3, 6, ... |
| Green | 1             | 1, 4, 7, ... |
| Blue  | 2             | 2, 5, 8, ... |

Last departure time:

(time of last trip) = (trips - 1) × 3 + offset

Add **30 minutes** travel time.

---

## 💡 Algorithm
1. Read `r`, `g`, `b`
2. Compute trips needed for each color
3. Compute last arrival time for each color
4. Output the maximum of these times

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int g = scanner.nextInt();
        int b = scanner.nextInt();

        long tripsR = (r + 1) / 2;
        long tripsG = (g + 1) / 2;
        long tripsB = (b + 1) / 2;

        long maxTime = 0;

        if (tripsR > 0) {
            long timeR = (tripsR - 1) * 3 + 30;
            maxTime = Math.max(maxTime, timeR);
        }

        if (tripsG > 0) {
            long timeG = (tripsG - 1) * 3 + 1 + 30;
            maxTime = Math.max(maxTime, timeG);
        }

        if (tripsB > 0) {
            long timeB = (tripsB - 1) * 3 + 2 + 30;
            maxTime = Math.max(maxTime, timeB);
        }

        System.out.println(maxTime);
        scanner.close();
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`
