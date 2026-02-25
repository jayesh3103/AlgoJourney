# 📘 A. Grammar Lessons – Codeforces Practice

This is my solution for the **Grammar Lessons** problem from Codeforces.  
This README explains the grammar rules, validation logic, and implementation.

---

## 📄 Problem Description

Petya invented his own language with very strict grammar rules.

There are:

- **3 parts of speech**:
  - Adjective
  - Noun
  - Verb

- **2 genders**:
  - Masculine
  - Feminine

Each word belongs to exactly one type and one gender.

---

## 🧠 Word Endings

Every valid word must end with one of these six suffixes:

| Gender     | Adjective | Noun   | Verb     |
|------------|-----------|--------|----------|
| Masculine  | lios      | etr    | initis   |
| Feminine   | liala     | etra   | inites   |

No other endings are allowed.

Even words like `"lios"` or `"etr"` are valid words.

---

## 📜 Sentence Rules

A valid sentence is:

- Exactly **one word**, OR
- A **statement** that satisfies:

1️⃣ Zero or more adjectives  
2️⃣ Exactly one noun  
3️⃣ Zero or more verbs  
4️⃣ All words must have the same gender  

Order must be:

Adjectives → Noun → Verbs

---

## 💡 Approach

For each word:

1. Identify:
   - Gender (0 = masculine, 1 = feminine)
   - Type (1 = adjective, 2 = noun, 3 = verb)

2. If word does not match any valid ending → print `"NO"`

3. If only one word → print `"YES"`

4. Otherwise:
   - Ensure all words have the same gender
   - Ensure types are in non-decreasing order (1 → 2 → 3)
   - Ensure exactly one noun exists

If all conditions pass → `"YES"`  
Otherwise → `"NO"`

---

## ⏱ Complexity

- Time Complexity: O(n)
- Space Complexity: O(1)
- Total characters ≤ 10^5

Efficient for constraints.

---

## 🖥️ Implementation (Java)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            System.out.println("NO");
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        int n = st.countTokens();

        if (n == 0) {
            System.out.println("NO");
            return;
        }

        int expectedGender = -1;
        int nounCount = 0;
        int prevType = 0;

        for (int i = 0; i < n; i++) {
            String w = st.nextToken();
            int[] info = getWordInfo(w);

            if (info == null) {
                System.out.println("NO");
                return;
            }

            // Single word is always valid
            if (n == 1) {
                System.out.println("YES");
                return;
            }

            int gender = info[0];
            int type = info[1];

            if (expectedGender == -1) {
                expectedGender = gender;
            } else if (expectedGender != gender) {
                System.out.println("NO");
                return;
            }

            if (type < prevType) {
                System.out.println("NO");
                return;
            }

            if (type == 2) {
                nounCount++;
            }

            prevType = type;
        }

        if (n > 1 && nounCount != 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    private static int[] getWordInfo(String w) {
        if (w.endsWith("initis")) return new int[]{0, 3}; // masculine verb
        if (w.endsWith("inites")) return new int[]{1, 3}; // feminine verb
        if (w.endsWith("liala")) return new int[]{1, 1};  // feminine adjective
        if (w.endsWith("etra")) return new int[]{1, 2};   // feminine noun
        if (w.endsWith("lios")) return new int[]{0, 1};   // masculine adjective
        if (w.endsWith("etr")) return new int[]{0, 2};    // masculine noun

        return null;
    }
}
