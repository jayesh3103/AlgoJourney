# 🏆 A. Room Leader

## 📅 Problem of the Day — Codeforces 

---

## 📝 Problem Summary

In a Codeforces round, contestants are divided into rooms.  
Each room has **n participants**, and exactly **one leader** — the contestant with the **maximum total score**.

Each participant earns points from:
- Solving problems **A, B, C, D, E**
- Performing **successful and unsuccessful hacks**

---

## 🧮 Scoring Rules

For each contestant:

### 🧩 Problem Scores
- Problem A → `a`
- Problem B → `b`
- Problem C → `c`
- Problem D → `d`
- Problem E → `e`

(If a problem is not solved, its score is `0`.)

### 💥 Hack Scores
- **Successful hack** → `+100 points`
- **Unsuccessful hack** → `-50 points`

---

## 🎯 Objective

Given all contestants in a room, determine:

> **The handle (username) of the contestant with the highest total score**

It is guaranteed that:
- All handles are unique
- There is **exactly one leader**

---

## 🧠 Approach

1. Read the number of contestants `n`
2. For each contestant:
   - Read handle, hacks, and problem scores
   - Compute total score using:
     ```
     total = (successful_hacks × 100)
             − (unsuccessful_hacks × 50)
             + sum of problem scores
     ```
3. Track the contestant with the **maximum score**
4. Output the handle of the leader

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(n)` |
| **Space Complexity** | `O(1)` |

Since we only track the current maximum, no extra storage is required.

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String bestHandle = "";
        long maxScore = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String handle = sc.next();
            int plus = sc.nextInt();
            int minus = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();

            long score = (long) plus * 100
                       - (long) minus * 50
                       + a + b + c + d + e;

            if (score > maxScore) {
                maxScore = score;
                bestHandle = handle;
            }
        }

        System.out.println(bestHandle);
    }
}
