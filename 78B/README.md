# 📌 B. Easter Eggs

## 📅 Problem of the Day — Codeforces  

---

## 📝 Problem Summary

The Easter Rabbit has placed **n eggs in a circle** and wants to paint them using **exactly 7 colors**:

**Red (R), Orange (O), Yellow (Y), Green (G), Blue (B), Indigo (I), Violet (V)**

However, there are two important constraints:

1. **Each of the 7 colors must appear at least once**
2. **Any four consecutive eggs must all have different colors**

You are guaranteed that a solution always exists.

---

## 🎯 Objective

Given an integer `n (7 ≤ n ≤ 100)`:
- Output a string of length `n`
- Each character represents the color of an egg
- The arrangement must satisfy both constraints

If multiple solutions exist, **any valid one is acceptable**.

---

## 🧠 Key Observations

- The sequence **"ROYGBIV"** already:
  - Uses all 7 colors exactly once
  - Has no repeated colors in any window of 4 eggs
- After placing these 7 eggs:
  - We can safely repeat only the last **4-color cycle**: `"GBIV"`
  - This avoids violating the “4 consecutive different colors” rule
- Since the eggs are in a **circle**, the pattern must remain valid across boundaries — which this construction guarantees

---

## 🧠 Approach

1. Start with the base sequence:
- `ROYGBIV`
2. If `n > 7`, repeatedly append characters from:
- `GBIV`
3. Continue until the total length becomes `n`
4. Print the final sequence

This guarantees:
- All 7 colors appear at least once
- No 4 adjacent eggs share a color

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(n)` |
| **Space Complexity** | `O(n)` |

---

## 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
     String line = br.readLine();
     if (line == null) return;
     int n = Integer.parseInt(line.trim());
     
     StringBuilder sb = new StringBuilder();
     
     String base = "ROYGBIV";
     String cycle = "GBIV";
     
     sb.append(base);
     
     for (int i = 7; i < n; i++) {
         sb.append(cycle.charAt((i - 7) % 4));
     }
     
     System.out.println(sb.toString());
 }
}
