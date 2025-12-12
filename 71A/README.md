# ✂️ A. Way Too Long Words — Codeforces Daily Solution

## 📌 Problem Summary
Some words like **"localization"** or **"internationalization"** are long and tiring to rewrite.  
We define a word as **too long** if: `length > 10`
Such words must be converted into a special abbreviation,
Examples:
- `localization` → `l10n`
- `internationalization` → `i18n`
- `pneumonoultramicroscopicsilicovolcanoconiosis` → `p43s`

Words with length **≤ 10** remain unchanged.

---

## 🎯 Goal  
Given **n words**, output each word in its original form or its abbreviated form.

---

## 🧠 Approach & Logic

### ✔ Step 1 — Read the number of words  
The first integer `n` tells how many words follow.

### ✔ Step 2 — For each word:
If `length > 10`, convert using:
- first = s.charAt(0)
- middleCount = s.length() - 2
- last = s.charAt(s.length()-1)
- result = first + middleCount + last

Else, print the original word.

### ✔ Step 3 — Output results line-by-line  
No extra spaces, exactly **n outputs**.

---

## ⏱️ Time & Space Complexity

| Complexity | Value |
|-----------|--------|
| **Time** | `O(n * L)` where `L ≤ 100` (reading + processing words) |
| **Space** | `O(1)` aside from input storage |

Very lightweight and optimal.

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            while (n-- > 0) {
                String s = sc.next();
                if (s.length() > 10) {
                    System.out.print(s.charAt(0));
                    System.out.print(s.length() - 2);
                    System.out.println(s.charAt(s.length() - 1));
                } else {
                    System.out.println(s);
                }
            }
        }
    }
}
