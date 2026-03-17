# 🔢 B. Permutations – Codeforces

## 📝 Problem Overview

You are given:

- `n` integers
- Each integer has exactly `k` digits

You are allowed to **rearrange the positions of digits** using the **same permutation** for all numbers.

🎯 Goal:

Minimize:

```
(max number after rearrangement) - (min number after rearrangement)
```

---

# 📥 Input

```
n k
```

Followed by `n` lines, each containing a `k`-digit number.

Constraints:

```
1 ≤ n, k ≤ 8
```

Leading zeros are allowed.

---

# 📤 Output

Print a single integer:

```
Minimum possible difference
```

---

# 💡 Key Idea

Since:

```
k ≤ 8
```

Total permutations:

```
k! ≤ 40320
```

👉 This allows a **brute-force approach using permutations**.

---

# ⚙️ Approach

### Step 1: Generate all permutations

We generate all permutations of indices:

```
[0, 1, 2, ..., k-1]
```

Each permutation represents a **digit reordering rule**.

---

### Step 2: Apply permutation to all numbers

For each permutation:

- Rearrange digits of every number
- Convert to integer

Example:

```
Original: 5237
Permutation: [2,0,3,1]
New: 3 5 7 2 → 3572
```

---

### Step 3: Track min and max

For each permutation:

```
minVal = smallest number formed
maxVal = largest number formed
```

Compute:

```
difference = maxVal - minVal
```

Update global minimum.

---

### Step 4: Return final answer

---

# ⏱ Complexity

Permutations:

```
O(k!) ≤ 40320
```

For each permutation:

```
O(n * k)
```

Total:

```
O(k! * n * k)
≈ 40320 * 8 * 8 ≈ 2.5 million operations
```

✅ Efficient within limits.

---

# 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {

    static int minDiff = Integer.MAX_VALUE;
    static int n, k;
    static String[] nums;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        nums = new String[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.next();
        }

        int[] p = new int[k];

        for (int i = 0; i < k; i++) {
            p[i] = i;
        }

        permute(p, 0);

        System.out.println(minDiff);

        sc.close();
    }

    static void permute(int[] p, int idx) {

        if (idx == k) {
            evaluate(p);
            return;
        }

        for (int i = idx; i < k; i++) {

            swap(p, i, idx);
            permute(p, idx + 1);
            swap(p, i, idx);
        }
    }

    static void swap(int[] p, int i, int j) {
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }

    static void evaluate(int[] p) {

        int maxVal = -1;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int val = 0;

            for (int j = 0; j < k; j++) {
                val = val * 10 + (nums[i].charAt(p[j]) - '0');
            }

            maxVal = Math.max(maxVal, val);
            minVal = Math.min(minVal, val);
        }

        minDiff = Math.min(minDiff, maxVal - minVal);
    }
}
```
