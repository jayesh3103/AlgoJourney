# 📰 Newspaper Headline (Codeforces – Problem A)

## 📌 Problem Summary

Fangy the little walrus wants to create a word `s2` by:
1. Taking several copies of a newspaper headline `s1`
2. Gluing them together (forming repetitions of `s1`)
3. Deleting some characters (without leaving spaces)

Your task is to determine the **minimum number of times** `s1` must be glued so that `s2` can be obtained as a **subsequence** of the resulting string.

If it’s impossible, print `-1`.

---

## 🧠 Key Observations

- Characters in `s2` must appear **in order**
- Deletions are allowed → this is a **subsequence problem**
- We can reuse `s1` multiple times
- We want to **minimize** how many times we restart scanning `s1`

---

## 💡 Strategy

1. **Preprocess `s1`**  
   Store all positions of each character (`a`–`z`) in `s1`.

2. **Validation**  
   If any character in `s2` does not appear in `s1`, the answer is `-1`.

3. **Greedy Scan**  
   - Traverse `s2` character by character
   - Try to match each character in the current copy of `s1`
   - If not possible, start a new copy of `s1` and increment the count

4. **Binary Search Optimization**  
   Efficiently find the next valid position using binary search.

---

## ✅ Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        // Store positions of each character in s1
        List<Integer>[] positions = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            positions[i] = new ArrayList<>();
        }

        for (int i = 0; i < s1.length(); i++) {
            positions[s1.charAt(i) - 'a'].add(i);
        }

        // Check feasibility
        for (int i = 0; i < s2.length(); i++) {
            if (positions[s2.charAt(i) - 'a'].isEmpty()) {
                System.out.println("-1");
                return;
            }
        }

        int count = 1;
        int currentIndex = -1;

        // Greedy subsequence matching
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            List<Integer> list = positions[c - 'a'];

            int pos = Collections.binarySearch(list, currentIndex);
            int next;

            if (pos >= 0) {
                next = pos + 1;
            } else {
                next = -(pos + 1);
            }

            if (next < list.size()) {
                currentIndex = list.get(next);
            } else {
                count++;
                currentIndex = list.get(0);
            }
        }

        System.out.println(count);
    }
}

```
---
## ✅ Complexity
- **Time Complexity:** `O(|s1| + |s2| log |s1|)`
- **Space Complexity:** `O(|s1|)`
