# 🎁 B. Present from Lena – Codeforces

## 📝 Problem Overview

Lena wants to create a **rhombus pattern** using numbers from `0` to `n` as a birthday present for Vasya.

Rules of the pattern:

1. The **largest number `n` is at the center**.
2. Numbers **increase from 0 up to a maximum value** in each row.
3. Then they **decrease symmetrically back to 0**.
4. The pattern forms a **rhombus (diamond)** shape.
5. Each pair of adjacent numbers must be separated by **exactly one space**.
6. Leading spaces must be printed **exactly as required**.
7. **No trailing spaces** should appear after the last number in a line.

Constraints:

```
2 ≤ n ≤ 9
```

Total rows:

```
2 * n + 1
```

---

# 💡 Pattern Insight

The rhombus has **2n + 1 rows**.

For each row `r`:

```
max_val = n - |n - r|
```

This gives the **largest number printed in that row**.

Example for `n = 5`:

```
r = 0 → max_val = 0
r = 1 → max_val = 1
r = 2 → max_val = 2
r = 3 → max_val = 3
r = 4 → max_val = 4
r = 5 → max_val = 5
r = 6 → max_val = 4
r = 7 → max_val = 3
r = 8 → max_val = 2
r = 9 → max_val = 1
r = 10 → max_val = 0
```

---

# 🧩 Steps to Build Each Row

### 1️⃣ Print Leading Spaces

Number of double spaces needed:

```
n - max_val
```

Each is `"  "` (two spaces).

---

### 2️⃣ Print Increasing Numbers

```
0 → max_val
```

---

### 3️⃣ Print Decreasing Numbers

```
max_val-1 → 0
```

---

# ⏱ Complexity

Time Complexity

```
O(n²)
```

Maximum rows = `19`, so very small.

Space Complexity

```
O(n)
```

Used for the string builder.

---

# 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();

            for (int r = 0; r <= 2 * n; r++) {

                int max_val = n - Math.abs(n - r);

                StringBuilder sb = new StringBuilder();

                // leading spaces
                for (int i = 0; i < n - max_val; i++) {
                    sb.append("  ");
                }

                // increasing numbers
                sb.append(0);
                for (int i = 1; i <= max_val; i++) {
                    sb.append(" ").append(i);
                }

                // decreasing numbers
                for (int i = max_val - 1; i >= 0; i--) {
                    sb.append(" ").append(i);
                }

                System.out.println(sb.toString());
            }
        }

        sc.close();
    }
}
```
