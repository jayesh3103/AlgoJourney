# 🍂 Indian Summer – Codeforces Practice

This is my solution for the **A. Indian Summer** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

Alyona is collecting fallen leaves during the **Indian summer**.  
Each leaf is described by:
- The **species** of the tree it came from.
- Its **color**.

However, Alyona is **very selective** —  
she **does not take** a leaf if she already has another leaf of the **same species and color**.  

Your task is to find **how many unique leaves** Alyona collects.

---

### 🔢 Input
- The first line contains an integer `n` — the number of leaves Alyona finds.  
- The next `n` lines each contain two strings:
  - `species` – name of the tree (lowercase Latin letters)
  - `color` – color of the leaf

### 🧾 Output
- Print a single integer — the **number of unique leaves** Alyona collects.

---

## 💡 Approach

1. **Read All Leaves:**
   - Each leaf is represented by a line containing two strings — species and color.

2. **Store Unique Combinations:**
   - Combine `species` and `color` into a single string (e.g., `"maple red"`).
   - Use a **HashSet** to automatically filter duplicates.

3. **Count Unique Entries:**
   - The final size of the `HashSet` equals the number of distinct (species, color) pairs.

---

## 🧠 Core Idea

> When uniqueness is based on a pair of values,  
> a **set** is the ideal data structure to handle it.

Each leaf’s uniqueness is determined by both its **tree species** and **color**,  
so combining them into a single string ensures easy comparison and efficient storage.

---

## 🖥️ Implementation (Java)

```java
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            in.nextLine(); 

            HashSet<String> leaves = new HashSet<>();

            for (int i = 0; i < n; i++) {
                String line = in.nextLine();
                leaves.add(line);
            }

            System.out.println(leaves.size());
        }
    }
}

```
---

## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

