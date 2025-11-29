# ⚔️ Codeforces Daily Problem — B. Settlers' Training

## 📌 Problem Summary  
In the game *Settlers II*, a defense structure contains **n soldiers**, each with a rank from **1 to k**.  
You want to train them until **all soldiers reach rank k**.  

Each training session costs **1 gold coin** and works as follows:

1. Soldiers are grouped by equal rank (minimum possible number of groups).
2. In every group that contains soldiers with rank `< k`, **exactly one soldier** increases rank by 1.

Your task:  
➡️ **Compute the minimum number of training sessions required** so that *every soldier reaches rank k*.

---

## 🧠 Key Insight  
During a training session, for every rank `i < k` that has at least one soldier, **one soldier moves from rank i → i+1**.

This means **in every session, the number of soldiers with rank < k decreases by exactly the number of distinct ranks present**.

Simulation is safe because:
- `n, k ≤ 100`  
- Ranks are small  
- Transitions are deterministic  

Using a frequency array `cnt[i]` makes simulation efficient.

---

## 🔍 Approach  
- Count how many soldiers are at each rank (`cnt[1..k]`).  
- While some soldier is below rank `k`:
  - Increase session counter.
  - For ranks from `k−1` down to `1`:
    - If `cnt[i] > 0`, then:  
      - Move one soldier from rank `i` → `i+1`.

Stop when all `n` soldiers reach rank `k`.

---

## ✅ Java Implementation  

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        
        int n = fs.nextInt();
        int k = fs.nextInt();
        int[] cnt = new int[k + 1];
        
        for (int i = 0; i < n; i++) {
            cnt[fs.nextInt()]++;
        }
        
        int ans = 0;
        while (cnt[k] != n) {
            ans++;
            for (int i = k - 1; i >= 1; i--) {
                if (cnt[i] > 0) {
                    cnt[i]--;
                    cnt[i + 1]++;
                }
            }
        }
        
        out.println(ans);
        out.flush();
    }
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        
        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(k)`
- **Space Complexity:** `O(k)`
