# 💻 B. Choosing Laptop — Codeforces

## 🛒 Problem Summary

Vasya is buying a laptop.  
He only cares about three properties:

- ⚡ **Processor Speed**
- 🧠 **RAM**
- 💾 **HDD**

A laptop is considered **outdated** if there exists **another laptop** whose:

- speed is strictly greater  
- RAM is strictly greater  
- HDD is strictly greater  

If a laptop is outdated, Vasya ignores it.

Among all **non-outdated laptops**, Vasya chooses the **cheapest one**.

All laptop prices are distinct.

---

## 🧩 Algorithm

1. Read input
2. Store all laptop properties
3. For each laptop:
- Check if it is outdated
4. Among non-outdated laptops:
- Track minimum cost
- Store its index
5. Print index (1-based)

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|--------|------------|
| Time Complexity | **O(n²)** |
| Space Complexity | **O(n)** |

Since `n ≤ 100`, this runs comfortably within limits.

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     if (sc.hasNextInt()) {
         int n = sc.nextInt();

         int[] speed = new int[n];
         int[] ram = new int[n];
         int[] hdd = new int[n];
         int[] cost = new int[n];

         for (int i = 0; i < n; i++) {
             speed[i] = sc.nextInt();
             ram[i] = sc.nextInt();
             hdd[i] = sc.nextInt();
             cost[i] = sc.nextInt();
         }

         int chosenIndex = -1;
         int minCost = Integer.MAX_VALUE;

         for (int i = 0; i < n; i++) {
             boolean outdated = false;

             for (int j = 0; j < n; j++) {
                 if (speed[i] < speed[j] &&
                     ram[i] < ram[j] &&
                     hdd[i] < hdd[j]) {

                     outdated = true;
                     break;
                 }
             }

             if (!outdated && cost[i] < minCost) {
                 minCost = cost[i];
                 chosenIndex = i + 1; // 1-based indexing
             }
         }

         System.out.println(chosenIndex);
     }

     sc.close();
 }
}
