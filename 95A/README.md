# 🏒 A. Hockey — Codeforces Problem

## 📌 Problem Overview

Petya is allowed to modify a hockey team’s name to maximize the number of occurrences of a **lucky letter**, but **only** at positions covered by **forbidden substrings**.

### Rules:
- Forbidden substrings are matched **case-insensitively**
- If a position belongs to **any forbidden substring**, it may be replaced
- Replacement **must keep the original case** (uppercase/lowercase)
- Letters outside forbidden ranges **cannot be changed**
- Goal:
  1. Maximize the number of occurrences of the given lucky letter
  2. If multiple answers exist, choose the **lexicographically smallest**

---

## 🧠 Strategy

1. Convert the main string and forbidden strings to lowercase for matching
2. Mark all positions covered by forbidden substrings
3. Build the result string:
   - If a position is **not covered**, keep it unchanged
   - If it **is covered**:
     - Replace with the lucky letter (same case) if possible
     - Otherwise, replace with the smallest possible lexicographic letter
4. Output the final string

---

## ⏱️ Complexity Analysis

| Type | Complexity |
|-----|-----------|
| Time | **O(n × |w| × |s|)** — safe due to small constraints |
| Space | **O(|w|)** |

Where:
- `n ≤ 100` forbidden substrings  
- `|w| ≤ 100`

---

## ✅ Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] forbidden = new String[n];

        for (int i = 0; i < n; i++) {
            forbidden[i] = sc.next();
        }

        String w = sc.next();
        char luckyLower = sc.next().charAt(0);

        int len = w.length();
        boolean[] covered = new boolean[len];

        String wLower = w.toLowerCase();

        // Mark all forbidden-covered positions
        for (String f : forbidden) {
            String fLower = f.toLowerCase();
            int idx = 0;

            while ((idx = wLower.indexOf(fLower, idx)) != -1) {
                for (int k = 0; k < f.length(); k++) {
                    covered[idx + k] = true;
                }
                idx++;
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char original = w.charAt(i);

            if (!covered[i]) {
                result.append(original);
            } else {
                boolean isUpper = Character.isUpperCase(original);
                char lucky = isUpper
                        ? Character.toUpperCase(luckyLower)
                        : Character.toLowerCase(luckyLower);

                if (lucky != original) {
                    result.append(lucky);
                } else {
                    char replacement = isUpper ? 'A' : 'a';
                    if (replacement == original) {
                        replacement = isUpper ? 'B' : 'b';
                    }
                    result.append(replacement);
                }
            }
        }

        System.out.println(result.toString());
    }
}
