# 📌 B. Colorful Field

## 📅 Problem of the Day — Codeforces  

---

## 📝 Problem Summary

Fox Ciel observes a large **n × m** field divided into unit cells.  
Each cell is either:

- **Waste**
- Or contains one of the crops:
  - 🌱 Carrots
  - 🥝 Kiwis
  - 🍇 Grapes

### 🌾 Planting Rules

1. Cells are processed **row-wise** from `(1,1)` to `(n,m)`
2. **Waste cells are skipped**
3. Crops are planted cyclically in cultivated cells:

Carrots → Kiwis → Grapes → Carrots → …

You are given:
- Positions of all **waste cells**
- Multiple **queries**, each asking what is planted at a given cell

---

## 🎯 Objective

For each query cell:
- Print **`Waste`** if the cell is wasteland
- Otherwise, print:
- `Carrots`
- `Kiwis`
- `Grapes`

---

## 🧠 Key Observations

- The planting order is based on **linear indexing**
- Waste cells **shift the crop cycle**
- For a cell `(r, c)`:
- Linear index = `(r - 1) * m + c`
- Effective index = `linear index - number of waste cells before it`
- Crop type depends on `effectiveIndex % 3`

---

## 🧠 Approach

1. Store all waste cells
2. For each query:
- Check if the cell is waste
- Count how many waste cells appear **before** this cell in row-major order
3. Compute:

effectiveIndex = linearIndex - wasteCount

4. Determine crop:
- `1 → Carrots`
- `2 → Kiwis`
- `0 → Grapes`

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(n × t)` |
| **Space Complexity** | `O(n)` |

Where:
- `n ≤ 1000` waste cells
- `t ≤ 1000` queries

This comfortably fits within constraints.

---

## 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st = new StringTokenizer(br.readLine());
     
     int n = Integer.parseInt(st.nextToken());
     int m = Integer.parseInt(st.nextToken());
     int k = Integer.parseInt(st.nextToken());
     int t = Integer.parseInt(st.nextToken());
     
     int[] wasteR = new int[k];
     int[] wasteC = new int[k];
     
     for (int i = 0; i < k; i++) {
         st = new StringTokenizer(br.readLine());
         wasteR[i] = Integer.parseInt(st.nextToken());
         wasteC[i] = Integer.parseInt(st.nextToken());
     }
     
     StringBuilder sb = new StringBuilder();
     
     while (t-- > 0) {
         st = new StringTokenizer(br.readLine());
         int r = Integer.parseInt(st.nextToken());
         int c = Integer.parseInt(st.nextToken());
         
         boolean isWaste = false;
         int wasteCount = 0;
         
         for (int i = 0; i < k; i++) {
             if (wasteR[i] == r && wasteC[i] == c) {
                 isWaste = true;
                 break;
             }
             if (wasteR[i] < r || (wasteR[i] == r && wasteC[i] < c)) {
                 wasteCount++;
             }
         }
         
         if (isWaste) {
             sb.append("Waste\n");
         } else {
             int linearPos = (r - 1) * m + c;
             int effectiveIndex = linearPos - wasteCount;
             int type = effectiveIndex % 3;
             
             if (type == 1) sb.append("Carrots\n");
             else if (type == 2) sb.append("Kiwis\n");
             else sb.append("Grapes\n");
         }
     }
     
     System.out.print(sb);
 }
}
