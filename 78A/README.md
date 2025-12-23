# 📌 A. Haiku

## 📅 Problem of the Day — Codeforces  

---

## 📝 Problem Summary

**Haiku** is a traditional Japanese poetry form consisting of **three phrases** with a strict syllable pattern:

| Phrase | Required Syllables |
|------|--------------------|
| First | 5 |
| Second | 7 |
| Third | 5 |

To simplify syllable counting, the problem defines:

👉 **Number of syllables = number of vowel letters**  
Vowels considered: **a, e, i, o, u**

You are given **three lines**, each representing a phrase of a poem.  
Your task is to determine whether the poem follows the **5–7–5 haiku structure**.

---

## 🎯 Objective

- Read three phrases (lines)
- Count the number of vowels in each phrase
- Check if the counts are exactly **5, 7, and 5** respectively
- Print:
  - `"YES"` if it is a haiku
  - `"NO"` otherwise

---

## 🧠 Key Observations

- Spaces do **not** matter — only vowel characters are counted
- Leading and trailing spaces may exist
- Each phrase contains at least one valid character
- All letters are lowercase English letters
- Early termination is possible if any phrase fails the requirement

---

## 🧠 Approach

1. Store the expected vowel counts: `[5, 7, 5]`
2. Read the poem line by line
3. For each line:
   - Count vowels (`a, e, i, o, u`)
   - Compare with the expected count
4. If any mismatch occurs → print `"NO"`
5. If all match → print `"YES"`

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(n)` |
| **Space Complexity** | `O(1)` |

Where `n` is the total number of characters across all three lines (≤ 300).

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] targetCounts = {5, 7, 5};
        
        for (int i = 0; i < 3; i++) {
            if (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (countVowels(line) != targetCounts[i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        
        System.out.println("YES");
    }

    private static int countVowels(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
}
