# 📌 A. Panoramix's Prediction

## 📅 Problem of the Day — Codeforces  

---

## 📝 Problem Summary

A **prime number** is a number that has exactly two distinct divisors: `1` and itself.

Panoramix predicted that if:
- One day the Gauls beat **n** Roman soldiers (where `n` is prime), and  
- The next day they beat **m** Roman soldiers,  
- And **m is the immediate next prime number after n**,  

then chaos will follow.

Your task is to determine whether **m is the next prime number after n**.

---

## 🎯 Objective

Given two integers `n` and `m`:
- `n` is guaranteed to be a prime number  
- `m > n`  

Print **YES** if `m` is the **next prime** after `n`, otherwise print **NO`.

---

## 🧠 Key Insight

- There is **exactly one next prime** after every prime number.
- We must **not skip primes**.
- Simply checking if `m` is prime is **not sufficient** —  
  it must be the **very next** one.

---

## 🧠 Approach

1. Start from `n + 1`
2. Find the **first prime number** greater than `n`
3. Compare it with `m`
   - If equal → print `YES`
   - Otherwise → print `NO`

To check if a number is prime:
- Try dividing it from `2` up to `√number`
- If divisible → not prime

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(√m)` |
| **Space Complexity** | `O(1)` |

Given `m ≤ 50`, this solution is extremely efficient.

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int candidate = n + 1;

        while (!isPrime(candidate)) {
            candidate++;
        }

        if (candidate == m) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
