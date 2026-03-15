# 🍀 B. Lucky Substring – Codeforces

## 📝 Problem Overview

Petya loves **lucky numbers**.

A **lucky number** is a number that contains **only the digits `4` and `7`**.

Examples of lucky numbers:

```
4
7
44
47
74
77
744
```

Examples of non-lucky numbers:

```
5
17
467
123
```

Petya receives a **string `s` consisting only of digits**. He wants to find a substring that:

1️⃣ Represents a **lucky number**  
2️⃣ **Is not empty**  
3️⃣ Appears in `s` the **maximum number of times**

If multiple such strings exist, he chooses the **lexicographically smallest one**.

If **no lucky substring exists**, print:

```
-1
```

---

# 📥 Input

A single string:

```
s
```

Constraints:

```
1 ≤ |s| ≤ 50
```

The string contains **only digits (0–9)**.

Example:

```
047
```

---

# 📤 Output

Print the **lucky substring** satisfying the conditions.

If none exists:

```
-1
```

---

# 💡 Key Insight

The substring must consist **only of digits `4` and `7`**.

Possible lucky substrings include:

```
4
7
44
47
74
77
...
```

However, longer lucky substrings occur **less frequently**.

Since we want the substring that appears **maximum number of times**, the best candidates will usually be **single digits**:

```
"4" or "7"
```

Because every occurrence of `4` or `7` is itself a valid lucky substring.

So we simply:

1️⃣ Count occurrences of `4`  
2️⃣ Count occurrences of `7`

Then decide:

- If both counts are `0` → no lucky substring
- Otherwise choose the digit with **higher frequency**
- If equal → choose **"4"** because it is **lexicographically smaller**

---

# ⚙️ Algorithm

1. Read the string `s`
2. Initialize counters:

```
count4 = 0
count7 = 0
```

3. Traverse the string and count occurrences
4. Apply rules:

```
if count4 == 0 AND count7 == 0 → print -1
else if count4 >= count7 → print "4"
else → print "7"
```

---

# ⏱ Complexity

String length:

```
|s| ≤ 50
```

Time Complexity:

```
O(n)
```

Space Complexity:

```
O(1)
```

---

# 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int count4 = 0;
        int count7 = 0;

        for (char c : s.toCharArray()) {
            if (c == '4') {
                count4++;
            } else if (c == '7') {
                count7++;
            }
        }

        if (count4 == 0 && count7 == 0) {
            System.out.println("-1");
        } 
        else if (count4 >= count7) {
            System.out.println("4");
        } 
        else {
            System.out.println("7");
        }

        sc.close();
    }
}
```
