# 📘 A. Petya and Strings – Codeforces Practice

This is my solution for the **Petya and Strings** problem from Codeforces.  
This README explains the idea and implementation.

---

## 📄 Problem Description

Petya receives two strings of equal length.  
The strings contain uppercase and lowercase Latin letters.

We must compare them **lexicographically**, ignoring letter case.

Rules:

- If first string < second string → print `-1`
- If first string > second string → print `1`
- If both strings are equal → print `0`
- Comparison is **case-insensitive**

---

## 💡 Approach

Since case does not matter:

1. Convert both strings to the same case (lowercase).
2. Use built-in lexicographical comparison.
3. Print result according to comparison value.

Java provides:

String.compareTo()

Which returns:
- Negative → first string is smaller
- Positive → first string is larger
- Zero → strings are equal

---

## ⏱ Complexity

- Time Complexity: O(n)
- Space Complexity: O(1)
- Where n ≤ 100

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNext()) {
            String s1 = sc.next().toLowerCase();
            String s2 = sc.next().toLowerCase();

            int result = s1.compareTo(s2);

            if (result < 0) {
                System.out.println("-1");
            } else if (result > 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }

        sc.close();
    }
}
