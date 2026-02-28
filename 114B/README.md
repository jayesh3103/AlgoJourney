# 📘 B. PFAST Inc. – Codeforces

## 📝 Problem Summary

Petya is organizing his own programming contest format called **PFAST Inc.**  
Unlike ACM contests, a team can have **any number of members**.

However, some volunteers **do not get along**, and if two such people are on the same team, performance suffers.

Your task is to:

- Select the **largest possible team**
- Ensure **no two selected volunteers conflict**
- Print the selected names in **lexicographical order**

If multiple valid teams exist, print any one of them.

Constraints:
- `1 ≤ n ≤ 16`
- `0 ≤ m`
- Names are distinct and case-sensitive

---

## 💡 Key Insight

This is a **Maximum Independent Set** problem:

- Each volunteer → node
- Each conflict → edge
- We must select the largest subset of nodes with **no edges between them**

Since:

n ≤ 16

We can brute force all subsets using **bitmasking**.

Total subsets:

2^16 = 65,536

Efficient because `n ≤ 16`.

---

## 💻 Java Implementation

```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        // Sort names lexicographically
        Arrays.sort(names);

        // Map names to indices
        HashMap<String, Integer> nameToId = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nameToId.put(names[i], i);
        }

        // Conflict mask for each volunteer
        int[] conflictMask = new int[n];

        for (int i = 0; i < m; i++) {
            String u = sc.next();
            String v = sc.next();

            int idU = nameToId.get(u);
            int idV = nameToId.get(v);

            conflictMask[idU] |= (1 << idV);
            conflictMask[idV] |= (1 << idU);
        }

        int bestMask = 0;
        int maxSize = 0;
        int totalSubsets = 1 << n;

        // Try all subsets
        for (int mask = 0; mask < totalSubsets; mask++) {
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    if ((mask & conflictMask[i]) != 0) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                int size = Integer.bitCount(mask);
                if (size > maxSize) {
                    maxSize = size;
                    bestMask = mask;
                }
            }
        }

        System.out.println(maxSize);

        for (int i = 0; i < n; i++) {
            if ((bestMask & (1 << i)) != 0) {
                System.out.println(names[i]);
            }
        }

        sc.close();
    }
}
