# 🎯 B. Quiz League – Codeforces

## 📝 Problem Overview

In the Berland quiz show **"What? Where? When?"**, questions from the audience are placed in **n sectors** around a circular table.

- Each sector contains one question.
- The host spins an **arrow** that stops at sector **k**.

However:

- If the question in sector **k** was **already asked**, the host moves **clockwise** to find the **next unanswered question**.
- The sectors form a **circle**, so after sector **n**, it wraps back to **sector 1**.

Your task is to determine **which sector’s question will be asked next**.

---

# 📥 Input

Input is provided in **input.txt**.

### First line
```
n k
```

Where:

```
n → number of sectors (1 ≤ n ≤ 1000)
k → sector where arrow stops (1 ≤ k ≤ n)
```

### Second line

```
a1 a2 a3 ... an
```

Where:

```
ai = 0 → question already asked
ai = 1 → question not asked yet
```

The sectors are listed **clockwise**.

---

# 📤 Output

Print the **sector number** containing the next question to be asked.

Output should be written to **output.txt**.

---

# 💡 Approach

1. Convert sector `k` into **0-based index**:
```
k = k - 1
```

2. Check if the question in sector `k` is unanswered.

```
if a[k] == 1 → answer is k + 1
```

3. Otherwise, move **clockwise** until an unanswered question is found.

```
k = (k + 1) % n
```

The modulo `% n` ensures **circular traversal**.

4. Print the sector number.

```
k + 1
```

---

# 🔁 Circular Logic

Example:

```
n = 5
k = 5
```

Array:

```
0 1 0 1 0
```

Starting at sector **5**:

```
5 → asked
1 → asked
2 → unanswered ✔
```

Answer:

```
2
```

---

# ⏱ Complexity

Time Complexity

```
O(n)
```

Worst case: check all sectors once.

Space Complexity

```
O(n)
```

For storing sector status.

---

# 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        while (a[k] == 0) {
            k = (k + 1) % n;
        }

        pw.println(k + 1);

        pw.close();
        br.close();
    }
}
```

