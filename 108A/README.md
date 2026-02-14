# 🕒 A. Palindromic Times — Codeforces

## 📌 Problem Summary

Tattah noticed that **12:21** is a palindromic time because it reads the same forward and backward (ignoring the colon).

A time `"HH:MM"` is **palindromic** if:

H1 H2 : M1 M2

satisfies:

H1 == M2
H2 == M1

You are given a valid 24-hour time.  
Your task is to print the **next palindromic time strictly after** the given one.

If the given time is already palindromic, you must print the **next one**, not the same one.

Time wraps around after `23:59` → `00:00`.

---

## 🧠 Key Idea

We simulate minute-by-minute:

1. Increment minutes
2. Handle overflow:
   - If minutes == 60 → reset to 0 and increment hour
   - If hour == 24 → reset to 0
3. Check if current time is palindromic
4. Stop when found

Since there are only **1440 minutes in a day**, brute-force simulation is completely safe.

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|--------|------------|
| Time Complexity | **O(1440)** worst case |
| Space Complexity | **O(1)** |

Maximum 1440 iterations → constant time.

---

## 💻 Java 21 (64-bit) Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNext()) {
            String input = sc.next();
            String[] parts = input.split(":");

            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            while (true) {
                // Move to next minute
                minute++;

                if (minute == 60) {
                    minute = 0;
                    hour++;
                }

                if (hour == 24) {
                    hour = 0;
                }

                // Check palindrome condition
                if ((hour / 10 == minute % 10) &&
                    (hour % 10 == minute / 10)) {

                    System.out.printf("%02d:%02d\n", hour, minute);
                    break;
                }
            }
        }

        sc.close();
    }
}
