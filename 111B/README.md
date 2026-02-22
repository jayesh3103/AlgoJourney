# 📘 B. Petya and Divisors – Codeforces Practice

This is my solution for the **Petya and Divisors** problem from Codeforces.  
This README explains the idea, optimization, and implementation details.

---

## 📄 Problem Description

We are given **n queries** of the form:

xi yi  

For each query, we must count how many **positive divisors of xi** do **NOT divide any of the previous y numbers**:

xi−yi, xi−yi+1, ..., xi−1  

If:

yi = 0  

Then the answer is simply the total number of divisors of xi.

Constraints:

- 1 ≤ n ≤ 10^5  
- 1 ≤ xi ≤ 10^5  
- 0 ≤ yi ≤ i−1  

---

## 💡 Key Idea

Instead of checking previous numbers explicitly (which would be too slow), we use:

### 🔹 Observation

If a divisor `d` of `xi` appeared in one of the last `y` queries,  
then it must have been a divisor of some `xj` where:

j ≥ i − y  

So we track:

- `lastSeen[d]` → the last query index where divisor `d` appeared.

For query `i`:

- Let `threshold = i - y`
- For each divisor `d` of `xi`:
  - If `lastSeen[d] < threshold`, then this divisor was NOT used in the restricted range → count it.
  - Update `lastSeen[d] = i`

This avoids checking previous numbers directly.

---

## 🚀 Why This Works

- Each number ≤ 100000 has at most ~300 divisors.
- We compute divisors in O(√x).
- Total operations remain efficient even for 10^5 queries.
- 5-second time limit is enough.

---

## ⏱ Complexity

- Divisor calculation per query: O(√xi)
- Total complexity: approximately O(n √max(x))
- Space complexity: O(max(x)) for `lastSeen`

Efficient for constraints.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[] lastSeen = new int[100001];

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            List<Integer> divisors = getDivisors(x);
            int count = 0;
            int threshold = i - y;

            for (int d : divisors) {
                if (lastSeen[d] < threshold) {
                    count++;
                }
                lastSeen[d] = i;
            }

            out.println(count);
        }

        out.flush();
        out.close();
    }

    private static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i * i != n) {
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }
}
