# ➕ A. Life Without Zeros

## 📅 Problem of the Day — Codeforces 

---

## 📝 Problem Summary

You are given two positive integers **a** and **b**.

- Compute `c = a + b`
- Remove **all zero digits** from `a`, `b`, and `c`
- Check whether the equation still holds after removing zeros:
`removeZeros(a) + removeZeros(b) == removeZeros(a + b)`
---

## 🎯 Goal

Print:
- `"YES"` → if the equation remains correct
- `"NO"` → otherwise

---

## 🔍 Key Insight

Removing zeros can **change the numerical value** of a number.

Instead of working digit by digit mathematically, the simplest and safest way is:
1. Convert numbers to strings
2. Remove `'0'` characters
3. Convert back to integers
4. Compare the equation

This avoids edge cases and keeps the solution clean.

---

## 🧠 Approach

1. Read integers `a` and `b`
2. Compute `c = a + b`
3. Define a helper function to:
   - Convert number to string
   - Remove all `'0'`
   - Convert back to integer
4. Compare:
`removeZeros(a) + removeZeros(b) == removeZeros(c)`
5. Print result accordingly

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(d)` |
| **Space Complexity** | `O(d)` |

Where `d` is the number of digits (≤ 10).

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     int a = sc.nextInt();
     int b = sc.nextInt();
     int c = a + b;

     int aa = removeZeros(a);
     int bb = removeZeros(b);
     int cc = removeZeros(c);

     if (aa + bb == cc) {
         System.out.println("YES");
     } else {
         System.out.println("NO");
     }
 }

 public static int removeZeros(int n) {
     String s = String.valueOf(n);
     String res = s.replace("0", "");
     return Integer.parseInt(res);
 }
}
