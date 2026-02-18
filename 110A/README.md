# 🍀 A. Nearly Lucky Number — Codeforces

## 📌 Problem Overview

A **lucky number** is a number that contains only digits `4` and `7`.

Examples:
- Lucky: `4`, `7`, `47`, `744`
- Not lucky: `5`, `17`, `467`

A number is called **nearly lucky** if:

> The number of lucky digits (4 or 7) inside it is itself a lucky number.

You are given an integer `n` (up to 10¹⁸).  
Determine whether it is nearly lucky.

---

## 🧠 Key Idea

1. Count how many digits in `n` are either:

‘4’ or ‘7’

2. Let that count be `c`.

3. Check if `c` is a lucky number.

Since `n ≤ 10¹⁸`, it has at most 18 digits.

Therefore:
- Maximum possible `c` = 18
- The only lucky counts possible ≤ 18 are:

4 and 7

So we just check:

count == 4 OR count == 7

---

## ⏱ Complexity Analysis

| Metric | Complexity |
|--------|------------|
| Time Complexity | O(d) where d ≤ 18 |
| Space Complexity | O(1) |

Extremely efficient.

---

## 💻 Java Code

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        if (sc.hasNext()) {
            String n = sc.next();
            int count = 0;

            // Count lucky digits
            for (int i = 0; i < n.length(); i++) {
                char c = n.charAt(i);
                if (c == '4' || c == '7') {
                    count++;
                }
            }

            // Check if count itself is lucky
            if (count == 4 || count == 7) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
