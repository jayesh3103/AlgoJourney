# 📌 B. Sequence Formatting

## 📅 Problem of the Day — Codeforces  

---

## 📝 Problem Summary

Polycarp is extremely particular about how numeric sequences are formatted.  
He wants to **fix spaces** in a sequence so that it looks neat and consistent.

The input string is a concatenation of:
- Positive integers (no leading zeros)
- Commas `,`
- Spaces
- Three dots `...`

Your task is to **add and remove spaces** so that the formatting rules are satisfied.

---

## 🎯 Formatting Rules

After processing the string:

1. **Each comma** must be followed by **exactly one space**  
   - (unless it is the last character)
2. **Each `...`** must be preceded by **exactly one space**  
   - (unless it is at the beginning)
3. If **two numbers** are separated only by spaces → keep **exactly one space**
4. **No extra spaces** should appear anywhere else

---

## 🧠 Key Observations

- The input is already syntactically valid
- Only **spacing needs correction**
- Parsing the string into **logical tokens** makes the task manageable
- The problem becomes deterministic once tokens are classified

---

## 🧠 Approach

### Step 1: Tokenization
Parse the string into tokens:
- Numbers
- Commas
- Three dots `...`

While parsing:
- Track whether a token had spaces before it
- Assign each token a type:
  - `0` → Number
  - `1` → Comma
  - `2` → Three dots

---

### Step 2: Rebuilding the String
Reconstruct the output using strict rules:
- Add a space **after a comma**
- Add a space **before `...`**
- Add a space **between consecutive numbers if they had spaces**
- Avoid adding spaces elsewhere

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(n)` |
| **Space Complexity** | `O(n)` |


---

## 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Token {
        String content;
        boolean hasSpaceBefore;
        int type; 

        Token(String content, boolean hasSpaceBefore, int type) {
            this.content = content;
            this.hasSpaceBefore = hasSpaceBefore;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) return;

        List<Token> tokens = new ArrayList<>();
        int i = 0, n = s.length();

        while (i < n) {
            boolean spaceFound = false;
            while (i < n && s.charAt(i) == ' ') {
                spaceFound = true;
                i++;
            }
            if (i >= n) break;

            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num.append(s.charAt(i++));
                }
                tokens.add(new Token(num.toString(), spaceFound, 0));
            } else if (c == ',') {
                tokens.add(new Token(",", spaceFound, 1));
                i++;
            } else if (c == '.') {
                tokens.add(new Token("...", spaceFound, 2));
                i += 3;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int k = 0; k < tokens.size(); k++) {
            if (k > 0) {
                Token prev = tokens.get(k - 1);
                Token curr = tokens.get(k);

                boolean addSpace = false;
                if (prev.type == 1) addSpace = true;             
                if (curr.type == 2) addSpace = true;             
                if (prev.type == 0 && curr.type == 0 && curr.hasSpaceBefore)
                    addSpace = true;                             

                if (addSpace) result.append(' ');
            }
            result.append(tokens.get(k).content);
        }

        System.out.println(result.toString());
    }
}
