# 📌 A. Magical Array

## 📅 Problem of the Day — Codeforces  

---

## 📝 Problem Summary

Valera defines an array as **magical** if:

> **Minimum element = Maximum element**

You are given an array of integers.  
Your task is to count how many **non-empty subarrays** are magical.

A **subarray** is a contiguous sequence of elements.

---

## 🎯 Objective

Given an array `a` of length `n`, count the number of subarrays where:
- All elements are equal  
  (because only then min = max)

---

## 🧠 Key Insight

A subarray is magical **if and only if all its elements are the same**.

So the problem reduces to:
- Finding **contiguous segments of equal values**
- Counting how many subarrays each such segment contributes

---

## 🧠 Mathematical Observation

For a contiguous segment of identical elements of length `k`:

Number of subarrays = k × (k + 1) / 2

Example:

[a, a, a] → 3 + 2 + 1 = 6 subarrays

---

## 🧠 Approach

1. Traverse the array once
2. Maintain the length of the current segment of equal elements
3. When the value changes:
   - Add `k × (k + 1) / 2` to the answer
   - Reset the segment length
4. Add the last segment contribution
5. Print the total count

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(n)` |
| **Space Complexity** | `O(1)` |

Efficient for `n ≤ 10⁵`.

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

        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
        long count = 1;

        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                count++;
            } else {
                answer += count * (count + 1) / 2;
                count = 1;
            }
        }

        // Add last segment
        answer += count * (count + 1) / 2;

        System.out.println(answer);
    }
}
