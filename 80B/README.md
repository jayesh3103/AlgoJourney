# 📌 B. Depression

## 📅 Problem of the Day — Codeforces  

---

## 📝 Problem Summary

After Belle was banished, Cogsworth the mantel clock stopped showing the correct time.  
Luckily, a **digital clock** still works and shows the current time in **HH:MM** format.

The mantel clock:
- Initially shows **12:00**
- Has **hour** and **minute** hands
- Hands move **continuously and evenly**
- Hands can only be rotated **forward**
- Hands move **independently**

Your task is to calculate the **minimum angles (in degrees)** needed to rotate:
- the **hour hand**
- the **minute hand**

so that the clock shows the correct time.

---

## 🎯 Objective

Given the digital time `HH:MM`, compute:
- `x` → angle to rotate the **hour hand**
- `y` → angle to rotate the **minute hand**

Such that:
- `0 ≤ x, y < 360`
- Rotation is only **forward**
- The error must be ≤ `10⁻⁹`

---

## 🧠 Clock Mechanics

### 🕒 Hour Hand
- Moves **30° per hour**
- Moves **0.5° per minute**

Formula:

`hourAngle = (HH % 12) × 30 + MM × 0.5`

---

### 🕑 Minute Hand
- Moves **6° per minute**

Formula:

`minuteAngle = MM × 6`

---

## 🧠 Approach

1. Read time in `HH:MM` format
2. Extract hours (`HH`) and minutes (`MM`)
3. Convert hours into **12-hour format**
4. Apply the formulas for hour and minute hands
5. Print the two angles

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(1)` |
| **Space Complexity** | `O(1)` |

Only basic arithmetic is used.

---

## 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String time = br.readLine();
        if (time == null) return;
        
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        
        double hourAngle = (h % 12) * 30.0 + m * 0.5;
        double minuteAngle = m * 6.0;
        
        System.out.println(hourAngle + " " + minuteAngle);
    }
}
