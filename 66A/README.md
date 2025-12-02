# 🧮 Problem of the Day — Petya and Java

### 📅 Daily Codeforces Problem  
**A. Petya and Java**  
A classification problem where we determine the *smallest possible* Java data type that can store a given positive integer.

---

## 📝 Problem Summary  

You are given a **positive integer `n`** that may contain **up to 100 digits**.  
Your task is to determine the **smallest** data type among:

- `byte`
- `short`
- `int`
- `long`
- `BigInteger`

that can store `n`.

The ranges of these types (upper bounds only, since `n` is positive):

| Type        | Max Value |
|-------------|-------------------------------|
| byte        | 127                           |
| short       | 32767                         |
| int         | 2147483647                    |
| long        | 9223372036854775807           |
| BigInteger  | Unlimited                     |

If the number fits any primitive type, return that type.  
Otherwise, print **"BigInteger"**.

---

## ⚙️ Approach  

The integer `n` may be extremely large (up to **100 digits**), so:

1. Read input as a **string**, not an integer.
2. Attempt to parse the string using `Long.parseLong()`:
   - If parsing fails → it cannot fit in `long` → output **BigInteger**.
3. If parsing succeeds:
   - Compare the value with upper bounds:
     - `≤ 127` → `byte`
     - `≤ 32767` → `short`
     - `≤ 2147483647` → `int`
     - Otherwise → `long`

Why this works:
- Java throws an exception when parsing numbers > 9.22e18.
- No need for complicated manual big number comparisons.

---

## 🧠 Code Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        try {
            long n = Long.parseLong(s);
            
            if (n <= 127) {
                System.out.println("byte");
            } else if (n <= 32767) {
                System.out.println("short");
            } else if (n <= 2147483647) {
                System.out.println("int");
            } else {
                System.out.println("long");
            }
        } catch (Exception e) {
            System.out.println("BigInteger");
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`
