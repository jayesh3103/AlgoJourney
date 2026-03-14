# 🍀 A. Lucky Division – Codeforces

## 📝 Problem Overview

Petya loves **lucky numbers**.

A **lucky number** is a positive integer whose decimal representation contains **only the digits `4` and `7`**.

Examples of lucky numbers:

```
4
7
44
47
74
77
444
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

A number `n` is called **almost lucky** if:

```
n is divisible by at least one lucky number
```

You are given an integer:

```
1 ≤ n ≤ 1000
```

Determine whether `n` is **almost lucky**.

---

# 📥 Input

A single integer:

```
n
```

Example:

```
47
```

---

# 📤 Output

Print:

```
YES
```

if the number is **almost lucky**, otherwise print:

```
NO
```

---

# 💡 Key Idea

Since:

```
n ≤ 1000
```

We only need to check divisibility with **all lucky numbers ≤ 1000**.

Possible lucky numbers within this range are:

```
4
7
44
47
74
77
444
447
474
477
744
747
774
777
```

If **any of these numbers divides `n`**, then:

```
n is almost lucky
```

---

# ⚙️ Approach

1. Store all lucky numbers ≤ 1000 in an array.
2. Iterate through each lucky number.
3. Check:

```
n % lucky == 0
```

4. If true → print `"YES"`.
5. Otherwise → print `"NO"`.

---

# ⏱ Complexity

Number of lucky numbers checked:

```
14
```

Time Complexity:

```
O(14) ≈ O(1)
```

Space Complexity:

```
O(1)
```

Very efficient.

---

# 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] luckyNumbers = {
            4, 7,
            44, 47, 74, 77,
            444, 447, 474, 477,
            744, 747, 774, 777
        };

        boolean isAlmostLucky = false;

        for (int lucky : luckyNumbers) {

            if (n % lucky == 0) {
                isAlmostLucky = true;
                break;
            }
        }

        if (isAlmostLucky) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}
```
