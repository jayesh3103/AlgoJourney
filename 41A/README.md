# 🔤 Translation – Codeforces Practice

This is my solution for the **Translation** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

In the languages **Berlandish** and **Birlandish**, words with the same meaning are written **in reverse order**.  

You are given:
- A word `s` written in **Berlandish**.
- A word `t` — Vasya’s translation of `s` into **Birlandish**.

Your task is to determine whether Vasya translated the word **correctly**, i.e.,  
whether `t` is exactly the **reverse** of `s`.

---

## 💡 Approach

1. **Read Input:**
   - Take two strings, `s` (original) and `t` (translated).

2. **Reverse the First String:**
   - Reverse `s` using `StringBuilder(s).reverse().toString()`.

3. **Compare:**
   - If the reversed version of `s` equals `t`, print **"YES"**.
   - Otherwise, print **"NO"**.

---

## 🧠 Core Idea

> The translation is considered **correct** only if `t` is the exact reverse of `s`.  
> Hence, this problem boils down to a **string reversal and comparison** check.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            String t = in.next();

            String reversedS = new StringBuilder(s).reverse().toString();

            if (reversedS.equals(t)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
```

---
## ✅ Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(n)
