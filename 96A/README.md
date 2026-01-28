# ⚽ A. Football — Codeforces

## 📌 Problem Statement

Petya is watching a football match and writes down the players’ positions as a string of `0`s and `1`s:

- `0` → players of one team  
- `1` → players of the other team  

A situation is considered **dangerous** if **at least 7 players of the same team stand consecutively**.

Your task is to determine whether the given situation is dangerous or not.

---

## 🔍 Input

- A non-empty string consisting only of characters `0` and `1`
- Length of the string ≤ 100
- At least one player from **each team** is present

---

## 📤 Output

- Print **`YES`** if the situation is dangerous  
- Otherwise, print **`NO`**

---

## 🧠 Approach

Since the string is small:

- Simply check whether it contains:
  - `"0000000"` (7 consecutive zeros), or
  - `"1111111"` (7 consecutive ones)

If either exists → **dangerous situation**

---

## ⏱️ Complexity Analysis

| Type | Complexity |
|----|----|
| Time | **O(n)** |
| Space | **O(1)** |

Where `n` is the length of the string.

---

## ✅ Java Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();

        if (s.contains("0000000") || s.contains("1111111")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
