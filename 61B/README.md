# ⚔️ B. Hard Work — String Cleansing & Validation  
### 📅 Daily Codeforces Challenge — AlgoJourney

Today’s mission was all about **string sanitization**, **case normalization**, and **permutation validation** — disguised as a story about Shapur correcting student papers.

---

## 🧩 Problem Summary  

You are given **three original strings**.  
Every student submits an answer that should be **a concatenation of these three strings in any order**.

However, complications arise:

- Students may **change character cases** → treat uppercase == lowercase  
- Students may **add/remove signs** like `-`, `_`, `;` → ignore all of them  
- Initial strings can be up to 100 chars; answers up to 600 chars  
- You must say `ACC` if the cleaned student answer matches **any permutation** of the cleaned original strings.

Your task:  
👉 Normalize strings → generate the 6 valid permutations → validate each student submission.

---

## 🧠 Approach

### 🔹 Step 1: Clean the original strings  
For each of the initial three strings:
- Remove all signs: `-`, `_`, `;`  
- Convert letters to lowercase  
- Keep only alphabetic characters  

### 🔹 Step 2: Generate all valid concatenation permutations  
There are exactly **6 permutations** of the three strings:
- ABC, ACB, BAC, BCA, CAB, CBA
Store all six in a `HashSet` for O(1) lookup.

### 🔹 Step 3: Process each student answer  
For each answer:
- Clean it using the same cleaning function  
- If the cleaned answer appears in the valid set → output `ACC`  
- Else → output `WA`

---

## 💻 Code Implementation (Java)

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s1 = clean(sc.next());
        String s2 = clean(sc.next());
        String s3 = clean(sc.next());
        
        HashSet<String> valid = new HashSet<>();
        valid.add(s1 + s2 + s3);
        valid.add(s1 + s3 + s2);
        valid.add(s2 + s1 + s3);
        valid.add(s2 + s3 + s1);
        valid.add(s3 + s1 + s2);
        valid.add(s3 + s2 + s1);
        
        int n = sc.nextInt();
        while (n-- > 0) {
            String ans = clean(sc.next());
            if (valid.contains(ans)) {
                System.out.println("ACC");
            } else {
                System.out.println("WA");
            }
        }
    }
    
    static String clean(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '-' && c != '_' && c != ';') {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n × L)`
- **Space Complexity:** `O(L)`
