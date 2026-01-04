# 📌 A. Toy Army

## 📅 Problem of the Day — Codeforces    

---

## 📝 Problem Summary

Valera and Arcady are playing a turn-based strategy game called **GAGA: Go And Go Again**.

- There are **two armies**, each with `n` soldiers (`n` is even).
- Soldiers shoot **perfectly** and **simultaneously**.
- Multiple soldiers may target the same enemy.
- A soldier dies if hit at least once.
- The game consists of **exactly three turns**:
  1. Valera shoots
  2. Arcady shoots
  3. Valera shoots again

Once a soldier dies, they no longer participate.

---

## 🎯 Objective

Given `n`, find the **maximum total number of soldiers** that can be killed over the three turns.

---

## 🧠 Key Insight

- Initially, there are `2n` soldiers in total.
- The goal is to **maximize deaths**, not preserve fairness.
- Optimal strategy:
  - Valera uses both of his turns aggressively.
  - Arcady also targets optimally.

After analyzing all possibilities, it turns out that:

> 💡 **The maximum number of soldiers that can be killed is:**  
>  
> \[
> \frac{3n}{2}
> \]

This holds for all even `n`.

---

## 🧠 Why This Works

- In each Valera turn, he can potentially eliminate up to `n/2` enemies.
- Arcady can retaliate but has fewer opportunities.
- The total kill count is limited by turn count and remaining soldiers.
- Careful targeting ensures no shots are wasted.

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(1)` |
| **Space Complexity** | `O(1)` |

No loops, no simulation — just a direct formula.

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        System.out.println((long) n * 3 / 2);
        
        scanner.close();
    }
}
