# 🧮 Ultra-Fast Mathematician — Daily CF Problem

### 📅 Problem of the Day  
**A. Ultra-Fast Mathematician**  
A simple yet elegant bitwise-thinking problem from Codeforces.

---

## 📝 Problem Summary  
You are given two binary strings **of equal length**.  
For every index `i`, you must output:

- `1` → if the two bits at position `i` are **different**  
- `0` → if they are **the same**

Essentially, it's the **XOR** operation performed character-by-character on binary strings.

---

## ⚙️ Approach

The solution follows a **straightforward scan** across both strings:

1. Read the two binary strings `s1` and `s2`.
2. Iterate through each character index `i`.
3. Compare `s1[i]` and `s2[i]`.
4. Append:
   - `'1'` if they differ  
   - `'0'` if they are the same  
5. Output the newly constructed string.

This ensures leading zeros are preserved, as required.

---

## 💡 Why This Works

Binary XOR logic:  
| Bit A | Bit B | Output |
|------|-------|---------|
| 0    | 0     | 0       |
| 1    | 1     | 0       |
| 0    | 1     | 1       |
| 1    | 0     | 1       |

The problem is essentially this table applied over the entire string.

---

## 🧠 Code Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s1 = sc.next();
        String s2 = sc.next();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        
        System.out.println(sb);
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`
