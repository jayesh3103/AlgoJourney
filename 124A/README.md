# 📍 A. The Number of Positions – Codeforces

## 📝 Problem Overview

Petr is standing in a **line of `n` people**, but he does not know his **exact position**.

However, he knows two facts:

- There are **at least `a` people standing in front of him**
- There are **at most `b` people standing behind him**

We must determine **how many possible positions Petr could occupy** in the line.

Positions are numbered from **1 to n**.

---

# 📥 Input

A single line contains three integers:

```
n a b
```

Where:

- `n` → total number of people in the line  
- `a` → minimum number of people in front of Petr  
- `b` → maximum number of people behind Petr  

Constraints:

```
0 ≤ a, b < n ≤ 100
```

---

# 📤 Output

Print **one integer** — the number of possible positions Petr can stand in.

---

# 💡 Key Idea

If Petr is at position **i**:

```
people in front = i - 1
people behind = n - i
```

### Condition 1 — People in front

```
i - 1 ≥ a
```

```
i ≥ a + 1
```

So the **minimum possible position** is:

```
a + 1
```

---

### Condition 2 — People behind

```
n - i ≤ b
```

```
i ≥ n - b
```

So Petr must also satisfy:

```
i ≥ n - b
```

---

### Final Lower Bound

Petr must satisfy **both constraints**, therefore:

```
i ≥ max(a + 1, n - b)
```

---

### Maximum Possible Position

Petr cannot exceed the line:

```
i ≤ n
```

---

# 📊 Number of Possible Positions

The valid positions are:

```
max(a + 1, n - b) → n
```

Count:

```
n - max(a + 1, n - b) + 1
```

This simplifies to:

```
min(n - a, b + 1)
```

---

# ⚙️ Approach

1. Read integers `n`, `a`, `b`
2. Compute:

```
answer = min(n - a, b + 1)
```

3. Print the result.

---

# ⏱ Complexity

Time Complexity:

```
O(1)
```

Space Complexity:

```
O(1)
```

Only simple arithmetic operations are used.

---

# 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(Math.min(n - a, b + 1));

        sc.close();
    }
}
```
