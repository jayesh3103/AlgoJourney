# 🔢 Problem of the Day — Restoration of the Permutation

### 📅 Daily Codeforces Problem  
**B. Restoration of the Permutation**  
A constructive + greedy problem that requires rebuilding a permutation from constraints.

---

## 📝 Problem Summary

You're given:

- A permutation **A** of size **n**.
- A number **k**.
- An array **B**, where  
  **bᵢ = number of elements aⱼ to the left of aᵢ such that aⱼ ≥ (i + k)**.

Your task:

➡️ Construct the **lexicographically smallest** valid permutation **A** that satisfies all constraints of **B**.

The problem guarantees that at least one solution exists.

---

## ⚙️ Approach

To build the permutation lexicographically smallest:

### ✔️ Key Insight  
For each position, we must choose the **smallest valid number** that does **not violate** the `b[i]` condition.  
This requires tracking, for each candidate value `j`, how many already chosen numbers would "count" for its required `b[j]`.

### ✔️ Steps  
1. Maintain:  
   - `used[j]`: whether number `j` is already used  
   - `counts[j]`: how many qualifying elements (≥ j+k) have appeared before

2. For each position `i` (0 to n–1):
   - Try smallest number `j` from 1 to n.
   - If `j` is not used AND `counts[j] == b[j]`, choose it.
   - Mark it used.
   - Update `counts[p]` for all `p` such that this newly placed `j` affects their condition:
     ```
     if j ≥ p + k → counts[p]++
     ```

3. Continue until all positions are filled.

This greedy strategy ensures lexicographically smallest output.

---

## ⏱️ Complexity

- **Time Complexity:**  
  **O(n²)** — We try numbers from 1..n for each of n positions.  
  n ≤ 1000 → fully acceptable.

- **Space Complexity:**  
  **O(n)** — arrays `used`, `counts`, `b`, and `ans`.

---

## 🧠 Code Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        
        int[] counts = new int[n + 1];
        boolean[] used = new boolean[n + 1];
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!used[j] && counts[j] == b[j]) {
                    ans[i] = j;
                    used[j] = true;
                    
                    for (int p = 1; p <= n; p++) {
                        if (!used[p] && j >= p + k) {
                            counts[p]++;
                        }
                    }
                    break;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`
