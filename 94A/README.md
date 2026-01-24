# 🔐 A. Restoring Password — Codeforces Problem

## 📌 Problem Summary

Igor K.’s ISQ account was hacked by a virus that **encrypted his password** and replaced it with a strange **80-bit binary string**.

Fortunately, Igor discovered how the encryption works:

- The encrypted string has **80 bits**
- Every **10 consecutive bits** represent **one decimal digit (0–9)**
- The original password has **8 digits**
- A **mapping of digits 0–9 to unique 10-bit binary codes** is provided

Your task is to **decode the encrypted binary string** and restore the original password.

---

## 🧠 Key Idea

1. Read the 80-bit encrypted string
2. Split it into **8 chunks of 10 bits**
3. For each chunk:
   - Match it with the given binary codes for digits `0–9`
   - Append the corresponding digit to the password
4. Output the reconstructed 8-digit password

The problem guarantees that:
- All mappings are valid
- A solution always exists

---

## ⏱️ Complexity Analysis

| Aspect | Complexity |
|------|------------|
| Time | `O(80 × 10)` → constant |
| Space | `O(1)` |

---

## ✅ Java Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Encrypted 80-bit binary string
        String encrypted = scanner.next();

        // Binary codes for digits 0 to 9
        String[] codes = new String[10];
        for (int i = 0; i < 10; i++) {
            codes[i] = scanner.next();
        }

        StringBuilder password = new StringBuilder();

        // Process each 10-bit chunk
        for (int i = 0; i < 8; i++) {
            String chunk = encrypted.substring(i * 10, (i + 1) * 10);

            for (int digit = 0; digit < 10; digit++) {
                if (codes[digit].equals(chunk)) {
                    password.append(digit);
                    break;
                }
            }
        }

        System.out.println(password.toString());
        scanner.close();
    }
}
