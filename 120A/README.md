# 🛗 A. Elevator – Codeforces

## 📝 Problem Overview

A skyscraper in city **N** has modern elevators with **two doors**:

- **Front door**
- **Back door**

Each elevator also has **two rails** that passengers can hold while riding.

### Rail Positions

| Door Perspective | Rail 1 | Rail 2 |
|------------------|--------|--------|
| **Front door**   | Left side | Right side |
| **Back door**    | Right side | Left side |

Each person naturally holds the rail using their **strongest hand**.

Given:

- The **door** through which the VIP entered
- The **rail number** they held

We must determine whether the VIP is:

```
L → Left-handed
R → Right-handed
```

---

# 📥 Input

Two lines are given in **input.txt**.

```
door
rail
```

Where:

```
door → "front" or "back"
rail → 1 or 2
```

Example:

```
front
1
```

---

# 📤 Output

Print in **output.txt**:

```
L
```

or

```
R
```

---

# 💡 Logic

### Case 1 — Entered through **front door**

Rail positions:

```
Rail 1 → Left side
Rail 2 → Right side
```

Therefore:

```
Rail 1 → Left-handed (L)
Rail 2 → Right-handed (R)
```

---

### Case 2 — Entered through **back door**

Rail positions reverse:

```
Rail 1 → Right side
Rail 2 → Left side
```

Therefore:

```
Rail 1 → Right-handed (R)
Rail 2 → Left-handed (L)
```

---

# 📊 Decision Table

| Door | Rail | Result |
|-----|-----|------|
| front | 1 | L |
| front | 2 | R |
| back | 1 | R |
| back | 2 | L |

---

# ⏱ Complexity

Time Complexity

```
O(1)
```

Space Complexity

```
O(1)
```

Only simple conditional checks are required.

---

# 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        String door = br.readLine().trim();
        int rail = Integer.parseInt(br.readLine().trim());

        if (door.equals("front")) {
            if (rail == 1) {
                pw.println("L");
            } else {
                pw.println("R");
            }
        } else {
            if (rail == 1) {
                pw.println("R");
            } else {
                pw.println("L");
            }
        }

        pw.close();
        br.close();
    }
}
```

