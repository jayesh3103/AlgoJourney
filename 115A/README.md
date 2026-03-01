# 📘 A. Party – Codeforces

## 📝 Problem Summary

A company has `n` employees.  
Each employee:

- Either has **no manager** (`-1`)
- Or has **exactly one immediate manager**

There are **no cycles** in management.

An employee A is a **superior** of B if:

- A is B’s direct manager  
- OR A is the manager of B’s manager (directly or indirectly)

---

## 🎯 Task

Divide employees into the **minimum number of groups** such that:

- Each employee belongs to exactly one group
- In any group, **no employee is a superior of another**

---

## 💡 Key Insight

This is a **tree (or forest)** structure problem.

- Each `-1` represents a root.
- Each employee forms a chain up to a root.
- The company forms one or more trees (a forest).

### Important Observation:

If two employees are in the same management chain,  
they **cannot** be in the same group.

Therefore:

👉 The minimum number of groups equals  
the **maximum depth of any management chain**.

In other words:

> The answer is the length of the longest path from any employee to a root.

---

## 🚀 Approach

1. Read `n`
2. Store manager array `p[i]`
3. For each employee:
   - Traverse upward until reaching `-1`
   - Count depth
4. Track maximum depth
5. Print maximum depth

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int maxDepth = 0;

        for (int i = 1; i <= n; i++) {
            int current = i;
            int depth = 0;

            while (current != -1) {
                depth++;
                current = p[current];
            }

            maxDepth = Math.max(maxDepth, depth);
        }

        System.out.println(maxDepth);

        sc.close();
    }
}
