# 📘 B. Very Interesting Game – Codeforces

## 📝 Problem Summary

Two players play a game:

1. First player writes a **9-digit string** `s1` (with leading zeros allowed)  
   representing a number ≤ `a`.

2. Second player writes a **9-digit string** `s2`  
   representing a number ≤ `b`.

Then:

```
number = s1 || s2   (concatenation)
```

If this number is divisible by `mod` → **Second player wins**  
Otherwise → **First player wins**

Both play optimally.

If first player wins, we must print:
```
1 <lexicographically smallest winning s1>
```

If second player wins:
```
2
```

---

## 💡 Key Insight

The concatenated number equals:

```
(s1 * 10^9 + s2) % mod
```

Let:

```
P = (10^9 % mod)
```

Then:

```
(s1 * P + s2) % mod == 0
```

For a fixed `s1`, second player wants:

```
s2 ≡ - (s1 * P) (mod mod)
```

Let:

```
target = (mod - (s1 * P % mod)) % mod
```

If `target ≤ b`, then second player can choose that value and win.

---

### 🎯 Winning Condition

- If **for every possible `s1`**, second player can find such `s2`  
  → Second player wins.

- If there exists an `s1` such that:
```
target > b
```
→ second player cannot respond → First player wins.

We must output the **lexicographically smallest such s1**.

---

### ⚡ Optimization Trick

Important observation:

If:
```
b ≥ mod - 1
```

Then second player can always pick a valid remainder.

So:
```
Second player wins immediately.
```

Otherwise:

- Iterate `s1` from `1` to `min(a, mod)`
- Maintain `(s1 * P) % mod` incrementally
- Check if required remainder > b

Stop at first winning `s1`.

---

## ⏱ Complexity

At most:
```
O(min(a, mod))
```

Since `mod ≤ 10^7`, this is efficient.

Space complexity:
```
O(1)
```

---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) return;

        long a = sc.nextLong();
        long b = sc.nextLong();
        int mod = sc.nextInt();

        // If second player can cover all possible remainders
        if (b >= mod - 1) {
            System.out.println("2");
            return;
        }

        int p = (int)(1000000000L % mod);  // 10^9 % mod
        int val = 0;

        long limit = Math.min(a, mod);

        for (long i = 1; i <= limit; i++) {

            // Compute (i * p) % mod incrementally
            val += p;
            if (val >= mod) {
                val -= mod;
            }

            int remainderNeeded = (val == 0) ? 0 : (mod - val);

            if (remainderNeeded > b) {
                System.out.printf("1 %09d\n", i);
                return;
            }
        }

        System.out.println("2");
    }
}
```

