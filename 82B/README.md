# 📌 B. Sets

## 📅 Problem of the Day — Codeforces   

---

## 📝 Problem Summary

Little Vasya loves playing with **disjoint sets of positive integers**.

He starts with **n non-empty sets**, such that:
- No two sets share common elements

He then writes down **all possible unions of two different sets**  
→ total `n × (n − 1) / 2` unions  
→ shuffles them  
→ prints the elements in **arbitrary order**

You are given **only these union results**, and your task is to **reconstruct the original sets**.

---

## 🎯 Objective

Given all pairwise unions of unknown disjoint sets:
- Restore the original `n` sets
- Order of sets and elements does **not matter**
- Any valid solution is acceptable

---

## 🧠 Key Insight

💡 **Each number belongs to exactly one original set.**

Since:
- Sets are **disjoint**
- Every union includes all elements of both participating sets

👉 A number appears **exactly in all unions involving its original set**.

Thus:
- Each number has a **unique signature**:  
  the list of union indices where it appears
- Numbers with **identical signatures** belong to the **same original set**

---

## 🧠 Approach

### Step 1: Read Input
- Total union lines = `n × (n − 1) / 2`
- Track, for each number, **which union lines it appears in**

---

### Step 2: Build Signatures
- For every number, record a list of union indices
- This list acts as a **fingerprint**

---

### Step 3: Group by Signature
- Numbers with the **same signature** → same original set
- Use a `Map<List<Integer>, List<Integer>>`

---

### Step 4: Output the Sets
- Print each reconstructed set
- Order is irrelevant
- Guaranteed at least one valid solution

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(n² × k)` |
| **Space Complexity** | `O(n²)` |

Where:
- `n ≤ 200`
- `k ≤ 200` (numbers per union)

Efficient and safe within constraints.

---

## 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        if (!sc.hasMore()) return;

        int n = sc.nextInt();

        // Special case: only one union exists
        if (n == 2) {
            int k = sc.nextInt();
            int[] nums = new int[k];
            for (int i = 0; i < k; i++) nums[i] = sc.nextInt();

            System.out.println("1 " + nums[0]);
            System.out.print((k - 1));
            for (int i = 1; i < k; i++) System.out.print(" " + nums[i]);
            System.out.println();
            return;
        }

        int totalLines = n * (n - 1) / 2;
        Map<Integer, List<Integer>> occurrences = new HashMap<>();

        // Read all unions and record occurrences
        for (int line = 0; line < totalLines; line++) {
            int k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                int val = sc.nextInt();
                occurrences.putIfAbsent(val, new ArrayList<>());
                occurrences.get(val).add(line);
            }
        }

        // Group numbers by their occurrence signature
        Map<List<Integer>, List<Integer>> result = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : occurrences.entrySet()) {
            result.putIfAbsent(entry.getValue(), new ArrayList<>());
            result.get(entry.getValue()).add(entry.getKey());
        }

        // Output reconstructed sets
        StringBuilder sb = new StringBuilder();
        for (List<Integer> set : result.values()) {
            sb.append(set.size());
            for (int x : set) sb.append(" ").append(x);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // Fast input reader
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean hasMore() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return false;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return false;
                }
            }
            return true;
        }

        String next() {
            return hasMore() ? st.nextToken() : null;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
