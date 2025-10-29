

# 👕 T-shirts from Sponsor – Codeforces Practice

This is my solution for the **B. T-shirts from Sponsor** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

A sponsor decided to give every participant of a programming contest a **T-shirt** 🎽.  
The problem? They only have a **limited number of T-shirts** in five sizes:
> S, M, L, XL, XXL

Each participant:
- Has a **desired size**, and
- Chooses the **closest available size** if their preferred one is out of stock.  
  If there’s a tie between smaller and larger sizes, they pick the **larger one**.

Your task is to determine which **T-shirt size each participant receives**, based on:
- The stock of each size.
- The order in which participants arrive.
- Their desired sizes.

---

### 🔢 Input

1. Five integers — the stock counts of T-shirts in order:  
   `NS NM NL NXL NXXL`
2. Integer `K` — the number of participants.  
3. Then `K` lines, each containing a participant’s **preferred size** (`S`, `M`, `L`, `XL`, or `XXL`).

### 🧾 Output

- For each participant, print a line showing the **T-shirt size** they actually receive.

---

## 💡 Approach

1. **Represent Sizes as Indices:**
   - Map sizes to indices for easy processing:  
     `S → 0, M → 1, L → 2, XL → 3, XXL → 4`

2. **Simulate Each Participant:**
   - For every participant:
     - Determine the **index** of their desired size.
     - Search outward (in both directions) for the nearest available T-shirt.
     - If two options are equally distant, choose the **larger size** (higher index).

3. **Update Inventory:**
   - When a T-shirt is given, decrease the corresponding count in the `counts[]` array.

4. **Print Assigned Sizes:**
   - Convert the index back to its string representation and print.

---

## 🧠 Core Idea

> The essence of the problem is **nearest-available selection with preference toward larger sizes**.

By mapping T-shirt sizes to numeric indices,  
we can easily manage **distance-based searching** and ensure that  
participants always get the most suitable remaining size.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    
    static int[] counts = new int[5];

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            
            for (int i = 0; i < 5; i++) {
                counts[i] = in.nextInt();
            }
            
            int k = in.nextInt();
            
            for (int i = 0; i < k; i++) {
                String s = in.next();
                int idx = 0;
                
                if (s.equals("M")) idx = 1;
                else if (s.equals("L")) idx = 2;
                else if (s.equals("XL")) idx = 3;
                else if (s.equals("XXL")) idx = 4;
                
                System.out.println(findShirt(idx));
            }
        }
    }

    private static String findShirt(int idx) {
        for (int dist = 0; dist < 5; dist++) {
            int high = idx + dist;
            int low = idx - dist;
            
            if (high < 5 && counts[high] > 0) {
                counts[high]--;
                return toSize(high);
            }
            if (low >= 0 && low != high && counts[low] > 0) {
                counts[low]--;
                return toSize(low);
            }
        }
        return ""; 
    }

    private static String toSize(int idx) {
        if (idx == 0) return "S";
        if (idx == 1) return "M";
        if (idx == 2) return "L";
        if (idx == 3) return "XL";
        return "XXL";
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(k)`
- **Space Complexity:** `O(1)`
