# 🍀 B. Lucky Transformation – Codeforces

## 📝 Problem Overview

Petya loves **lucky numbers**.  
A **lucky number** is a number that contains **only digits `4` and `7`**.

Petya has a number represented as an **array of digits `d`** of length `n`.

He performs the following operation **exactly `k` times**:

1. Find the **smallest index `x` (1 ≤ x < n)** such that:

```
d[x] = 4 and d[x+1] = 7
```

2. If such `x` exists:

- If **x is odd** → change both digits to `4`
  
```
d[x] = 4
d[x+1] = 4
```

- If **x is even** → change both digits to `7`

```
d[x] = 7
d[x+1] = 7
```

3. If **no such pair exists**, the operation does nothing.

After performing **k operations**, print the final number.

---

# 📥 Input

First line:

```
n k
```

Where:

```
1 ≤ n ≤ 100000
0 ≤ k ≤ 10^9
```

Second line:

```
n digits forming the number
```

Example:

```
7 4
4727447
```

---

# 📤 Output

Print the resulting number after **k operations**.

---

# 💡 Key Observations

The transformation only affects **pairs `"47"`**.

Example:

```
47 → (odd position) → 44
47 → (even position) → 77
```

However, sometimes a **cycle appears**.

Example:

```
447 → 477 → 447 → 477 ...
```

So when we detect this **cycle pattern**, we can stop early.

---

# ⚙️ Algorithm

We scan the array from left to right.

For each position `i`:

Check if:

```
s[i] == '4' AND s[i+1] == '7'
```

Then apply the rule:

### Case 1 — Odd position (i is even in 0-index)

```
47 → 44
```

### Case 2 — Even position (i is odd in 0-index)

```
47 → 77
```

### Special Case (Cycle Detection)

If we encounter:

```
...447...
```

A cycle occurs:

```
447 → 477 → 447 → ...
```

Then we only need to check if `k` is **odd or even** to determine the final state.

---

# ⏱ Complexity

Worst case scanning:

```
O(n)
```

Even though:

```
k ≤ 10^9
```

We avoid simulating all operations by **cycle detection**.

Space complexity:

```
O(n)
```

---

# 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] s = br.readLine().toCharArray();

        for (int i = 0; i < n - 1 && k > 0; ) {

            if (s[i] == '4' && s[i + 1] == '7') {

                if (i % 2 == 0) {  // odd position (1-based)

                    s[i + 1] = '4';
                    k--;
                    i++;

                } else {  // even position (1-based)

                    if (i > 0 && s[i - 1] == '4') {

                        if (k % 2 == 1) {
                            s[i] = '7';
                        }

                        break;

                    } else {

                        s[i] = '7';
                        k--;
                        i--;
                    }
                }

            } else {
                i++;
            }
        }

        System.out.println(new String(s));
    }
}
```

