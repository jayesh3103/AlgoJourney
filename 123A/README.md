# 🔢 A. Prime Permutation – Codeforces

## 📝 Problem Overview

You are given a string:

```
s (consisting of lowercase letters)
```

Let:

```
|s| = n
```

Your task is to **rearrange the characters** such that:

For every **prime number `p ≤ n`**, and for every integer:

```
i from 1 to ⌊n / p⌋
```

The following condition holds:

```
s[p] = s[p × i]
```

---

# 📥 Input

A single string:

```
s
```

Constraints:

```
1 ≤ |s| ≤ 1000
```

---

# 📤 Output

- Print `"YES"` and one valid permutation if possible
- Otherwise print `"NO"`

---

# 💡 Key Insight

This condition creates **groups of indices that must have the same character**.

---

## 🔍 Understanding the Constraint

For each prime `p`:

We must ensure:

```
s[p] = s[2p] = s[3p] = ...
```

So all multiples of `p` must have the **same character**.

---

## 🧠 Important Observation

If a position is part of multiple such constraints, they merge into a **connected component**.

👉 Eventually, we get:

- A **large component** (positions that must share the same character)
- Some **independent positions**

---

## 🚀 Key Trick

Positions that belong to the main component:

```
All positions i where:
i is NOT a prime > n/2
```

Why?

- Primes `p ≤ n/2` have multiples → create connections
- Primes `p > n/2` → no multiples → independent

---

# ⚙️ Approach

### Step 1: Count frequency of characters

```
count[26]
```

---

### Step 2: Identify main component

Create a boolean array:

```
inComp[i] = true → belongs to main component
```

Count size:

```
compSize
```

---

### Step 3: Find most frequent character

We need one character to fill the entire component.

```
maxFreq ≥ compSize
```

Otherwise → impossible

---

### Step 4: Construct result

1. Fill all component positions with most frequent character
2. Fill remaining positions with other characters

---

# ⏱ Complexity

- Prime checking: `O(n√n)`
- Filling string: `O(n)`

Overall:

```
O(n√n)
```

Efficient for `n ≤ 1000`

---

# 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int n = s.length();

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        boolean[] inComp = new boolean[n];
        int compSize = 0;

        for (int i = 1; i < n; i++) {

            int pos = i + 1;

            if (isPrime(pos) && pos > n / 2) {
                inComp[i] = false;
            } else {
                inComp[i] = true;
                compSize++;
            }
        }

        int maxFreq = 0;
        int maxChar = -1;

        for (int i = 0; i < 26; i++) {
            if (count[i] > maxFreq) {
                maxFreq = count[i];
                maxChar = i;
            }
        }

        if (maxFreq < compSize) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");

        char[] res = new char[n];

        // Fill main component
        for (int i = 0; i < n; i++) {
            if (inComp[i]) {
                res[i] = (char) (maxChar + 'a');
                count[maxChar]--;
            }
        }

        // Fill remaining positions
        int currChar = 0;

        for (int i = 0; i < n; i++) {

            if (!inComp[i]) {

                while (count[currChar] == 0) {
                    currChar++;
                }

                res[i] = (char) (currChar + 'a');
                count[currChar]--;
            }
        }

        System.out.println(new String(res));

        sc.close();
    }

    static boolean isPrime(int x) {

        if (x < 2) return false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }

        return true;
    }
}
```
