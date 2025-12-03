# 🌧️ Problem of the Day — Petya and Countryside

### 📅 Daily Codeforces Problem  
**B. Petya and Countryside**  
A simulation problem involving water flow on a line of garden sections.

---

## 📝 Problem Summary  

Petya's grandmother has a garden represented as a **1 × n** strip, where each section has a fixed **height**.

When artificial rain is created over **one section**, the water can flow:

- **Left** while each next section is **not higher** than the previous one  
- **Right** under the same rule  

Your task:  
👉 For each section, simulate how far water can spread.  
👉 Return the **maximum number** of sections that can be watered when choosing the best starting point.

---

## 📌 Example  
Garden heights: `4 2 3 3 2`  
Rain on a section with height `3` spreads to all except the `4`, so result = **4**.

---

## ⚙️ Approach  

For every index `i`:

1. Count `1` for the starting section.
2. Move **left** from `i`, and keep counting while:
   - `h[j] <= h[j + 1]`
3. Move **right** from `i`, and keep counting while:
   - `h[j] <= h[j - 1]`
4. Track the **maximum** across all positions.

This works because the water spreads monotonically until blocked by a strictly higher height.

⏱ **Time Complexity:**  
- O(n²) worst case  
- n ≤ 1000, so this is efficient enough  

---

## 🧠 Code Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] h = new int[n];
        
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        
        int maxCount = 0;
        
        for (int i = 0; i < n; i++) {
            int count = 1;
            
            for (int j = i - 1; j >= 0; j--) {
                if (h[j] <= h[j + 1]) {
                    count++;
                } else {
                    break;
                }
            }
            
            for (int j = i + 1; j < n; j++) {
                if (h[j] <= h[j - 1]) {
                    count++;
                } else {
                    break;
                }
            }
            
            if (count > maxCount) {
                maxCount = count;
            }
        }
        System.out.println(maxCount);
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n²)`
- **Space Complexity:** `O(1)`
