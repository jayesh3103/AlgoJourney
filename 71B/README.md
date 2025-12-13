# 📊 B. Progress Bar — Codeforces Daily Solution

## 📅 Problem of the Day  
**B. Progress Bar**  
A simple simulation problem involving percentages and visualization logic.

---

## 📝 Problem Summary

You are given a progress bar with:
- **n** squares in a row
- Each square has a saturation value between **0** and **k**
- The progress is **t% completed**

Rules of the progress bar:
- Squares before the current position are **fully saturated (k)**
- Squares after are **empty (0)**
- At most **one square** can have a partial saturation (between 0 and k)

The completion percentage satisfies: 
- `(sum of all saturations) / (n × k) × 100 ≈ t`
---

## 🎯 Objective

Determine the saturation value of each square in the progress bar.

---

## 🧠 Approach & Logic

### ✔ Key Insight  
The total saturation required is: `total = (n × k × t) / 100`
We distribute this total saturation **from left to right**:
- Fill each square with `k` until the remaining total is less than `k`
- The next square gets the remaining value
- All further squares get `0`

This naturally satisfies all constraints:
- Prefix is fully filled
- At most one partial square
- Suffix is empty

---

## 🔢 Step-by-Step Algorithm

1. Read `n`, `k`, `t`
2. Compute: `total = (n * k * t) / 100`
3. For each square from `1` to `n`:
- If `total ≥ k`, print `k` and subtract `k`
- Else print `total` and set `total = 0`

---

## ⏱️ Complexity Analysis

| Type | Complexity |
|----|----|
| **Time Complexity** | `O(n)` |
| **Space Complexity** | `O(1)` |

Efficient and well within limits.

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        
        int total = (n * k * t) / 100;
        
        for (int i = 0; i < n; i++) {
            if (total >= k) {
                System.out.print(k + " ");
                total -= k;
            } else {
                System.out.print(total + " ");
                total = 0;
            }
        }
    }
}
