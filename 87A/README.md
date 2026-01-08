# 🚆 A. Trains

## 📌 Problem Overview

Vasya lives in the middle of a subway line and has two girlfriends:

- **Dasha** — trains arrive every `a` minutes
- **Masha** — trains arrive every `b` minutes

Whenever Vasya enters the subway:
- He waits for the **first arriving train**
- If **both trains arrive at the same time**, he chooses the direction with **lower frequency** (i.e., larger interval)

The train schedules are synchronized, meaning there exists a moment when both trains arrive together.

---

## 🎯 Objective

Determine **which girlfriend Vasya will visit more often** over time.

### Output Rules
- Print `"Dasha"` if Vasya goes to Dasha more often
- Print `"Masha"` if Vasya goes to Masha more often
- Print `"Equal"` if visits are equally frequent

---

## 🧠 Key Insight

The entire system repeats every:

LCM(a, b)

Within one full cycle:
- Trains to **Dasha** arrive `LCM / a` times
- Trains to **Masha** arrive `LCM / b` times

Using:

LCM(a, b) = (a × b) / gcd(a, b)

We can compare:

countDasha = b / gcd(a, b)
countMasha = a / gcd(a, b)

⚠️ Special Case  
If the difference between these counts is exactly `1`, tie-breaking cancels it out → result is `"Equal"`.

---

## 🛠️ Algorithm

1. Read `a` and `b`
2. Compute `g = gcd(a, b)`
3. Compute:
   - `countDasha = b / g`
   - `countMasha = a / g`
4. Compare the counts:
   - If difference is greater than `1`, higher count wins
   - Otherwise, result is `"Equal"`

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        long g = gcd(a, b);
        
        long countDasha = b / g;
        long countMasha = a / g;

        if (countDasha > countMasha) {
            if (countDasha == countMasha + 1) {
                System.out.println("Equal");
            } else {
                System.out.println("Dasha");
            }
        } else {
            if (countMasha == countDasha + 1) {
                System.out.println("Equal");
            } else {
                System.out.println("Masha");
            }
        }

        scanner.close();
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(log(min(a, b)))`
- **Space Complexity:** `O(1)`
