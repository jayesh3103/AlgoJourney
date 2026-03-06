# 🔤 A. String Task – Codeforces

## 📝 Problem Overview

Petya received his first programming assignment.  
He needs to process a given string according to the following rules:

1. **Remove all vowels** from the string.
2. **Insert a "." before every consonant**.
3. **Convert all uppercase consonants to lowercase**.

### Vowels
The vowels considered in this problem are:

```
A, O, Y, E, U, I
```

Both **uppercase and lowercase** versions are vowels.

All other letters are **consonants**.

---

## 📥 Input

A single string consisting of **uppercase and lowercase Latin letters**.

Constraints:

```
1 ≤ length of string ≤ 100
```

---

## 📤 Output

Print the **processed string** after applying the rules:

- Remove vowels
- Add `"."` before each consonant
- Convert consonants to lowercase

It is guaranteed that the resulting string will **not be empty**.

---

## 📌 Examples

### Example 1
Input
```
tour
```

Output
```
.t.r
```

---

### Example 2
Input
```
Codeforces
```

Output
```
.c.d.f.r.c.s
```

---

### Example 3
Input
```
aBAcAba
```

Output
```
.b.c.b
```

---

## 💡 Approach

1. Convert the entire string to **lowercase**.
2. Iterate through each character.
3. Check if the character is **not a vowel**.
4. If it is a consonant:
   - Append `"."`
   - Append the character.
5. Print the final string.

---

## ⏱ Time Complexity

```
O(n)
```

Where **n** is the length of the string.

---

## 💾 Space Complexity

```
O(n)
```

Used for storing the resulting string.

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNext()) {
            String s = sc.next().toLowerCase();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'y') {
                    sb.append('.').append(c);
                }
            }

            System.out.println(sb.toString());
        }

        sc.close();
    }
}
```

