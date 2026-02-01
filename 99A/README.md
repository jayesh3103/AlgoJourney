# 🏰 A. Help Far Away Kingdom — Codeforces

## 📌 Problem Summary

The King of a far away kingdom ordered that **all decimal numbers must be rounded** to simplify calculations.  
However, the rounding rules are **non-standard** and depend on the **last digit of the integer part**.

Your task is to apply the King’s rounding rules exactly as stated.

---

## 📥 Input

- A single number in the form:

<integer_part>.<fractional_part>

### Constraints:
- Total length ≤ 1000 characters (including the dot)
- Integer part:
  - Non-empty
  - No leading zeroes (except `"0"`)
- Fractional part:
  - Non-empty
  - Consists only of digits

---

## 📤 Output

- If rounding is possible → print the rounded integer **without leading zeroes**
- If the integer part ends with digit `9` → print:

GOTO Vasilisa.

---

## 🧠 Rounding Rules (King’s Order)

Let:
- `I` = integer part
- `F` = fractional part

### Case 1  
If **last digit of `I` ≠ 9** and **F < 0.5**  
➡️ Output `I`

### Case 2  
If **last digit of `I` ≠ 9** and **F ≥ 0.5**  
➡️ Add `1` to the **last digit** of `I`

### Case 3  
If **last digit of `I` = 9**  
➡️ Output `"GOTO Vasilisa."`

⚠️ Carry propagation is **not allowed**.

---

## ✨ Key Observation

Only **one digit matters** in the fractional part:
- The **first fractional digit**
  - `< '5'` → round down
  - `≥ '5'` → round up

This avoids big-number arithmetic entirely.

---

## ⏱️ Complexity

| Aspect | Value |
|----|----|
| Time | **O(n)** |
| Space | **O(n)** |
| Arithmetic | **String-based only** |

---

## ✅ Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int dotIndex = s.indexOf('.');
        String integerPart = s.substring(0, dotIndex);

        char firstFractionDigit = s.charAt(dotIndex + 1);
        char lastIntDigit = integerPart.charAt(integerPart.length() - 1);

        if (lastIntDigit == '9') {
            System.out.println("GOTO Vasilisa.");
        } else {
            if (firstFractionDigit < '5') {
                System.out.println(integerPart);
            } else {
                StringBuilder sb = new StringBuilder(integerPart);
                sb.setCharAt(sb.length() - 1, (char)(lastIntDigit + 1));
                System.out.println(sb.toString());
            }
        }
    }
}
