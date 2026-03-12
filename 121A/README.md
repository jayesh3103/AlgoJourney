# 🍀 A. Lucky Sum – Codeforces

## 📝 Problem Overview

Petya loves **lucky numbers**.

A **lucky number** is a positive integer whose decimal representation contains **only digits `4` and `7`**.

Examples of lucky numbers:

```
4
7
44
47
74
77
444
744
```

Examples of **non-lucky numbers**:

```
5
17
467
123
```

---

# 🎯 Task

Define a function:

```
next(x) = smallest lucky number ≥ x
```

You are given two integers:

```
l and r
```

You must compute:

```
next(l) + next(l+1) + next(l+2) + ... + next(r)
```

Constraints:

```
1 ≤ l ≤ r ≤ 10^9
```

---

# 💡 Key Observation

Instead of computing `next(x)` for **every number between `l` and `r`**, we notice:

The value of `next(x)` stays **constant until the next lucky number appears**.

Example:

```
Lucky numbers: 4, 7, 44
```

For values:

```
1 → 4
2 → 4
3 → 4
4 → 4
5 → 7
6 → 7
7 → 7
```

So instead of iterating through each number, we process **ranges**.

---

# ⚙️ Approach

### 1️⃣ Generate all lucky numbers

Use **DFS recursion**:

```
current * 10 + 4
current * 10 + 7
```

Generate lucky numbers up to:

```
10^10
```

(so they safely cover r ≤ 10^9)

---

### 2️⃣ Sort lucky numbers

This helps us process them in increasing order.

---

### 3️⃣ Process interval [l, r]

For each lucky number `L`:

```
rightBound = min(r, L)
count = rightBound - l + 1
```

Contribution:

```
sum += count * L
```

Then move:

```
l = rightBound + 1
```

Stop when:

```
l > r
```

---

# ⏱ Complexity

Lucky numbers count:

```
≈ 2^10 ≈ 1022
```

Time Complexity:

```
O(2^digits)
≈ O(1000)
```

Very fast.

Space Complexity:

```
O(1000)
```

---

# 💻 Java Implementation

```java
import java.util.*;

public class Main {

    static List<Long> luckyNumbers = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long l = sc.nextLong();
        long r = sc.nextLong();

        generateLuckyNumbers(0);

        Collections.sort(luckyNumbers);

        long totalSum = 0;

        for (long lucky : luckyNumbers) {

            if (lucky >= l) {

                long rightBound = Math.min(r, lucky);

                long count = rightBound - l + 1;

                totalSum += count * lucky;

                l = rightBound + 1;

                if (l > r) {
                    break;
                }
            }
        }

        System.out.println(totalSum);

        sc.close();
    }

    static void generateLuckyNumbers(long current) {

        if (current > 10000000000L) return;

        if (current > 0) {
            luckyNumbers.add(current);
        }

        generateLuckyNumbers(current * 10 + 4);
        generateLuckyNumbers(current * 10 + 7);
    }
}
```
