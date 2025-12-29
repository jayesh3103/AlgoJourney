# 🥤 A. Double Cola (Codeforces)

## 📌 Problem Description
Five friends — **Sheldon, Leonard, Penny, Rajesh, and Howard** — are standing in a queue for a vending machine.

Rules:
1. The first person drinks a cola.
2. After drinking, that person duplicates into **two identical copies**.
3. Both copies go to the **end of the queue**.
4. The process repeats indefinitely.

Initial queue:
```
Sheldon, Leonard, Penny, Rajesh, Howard
```

Your task is to determine **who drinks the n-th cola**.

---

## 🔍 Key Insight
Simulating the queue is impossible for large `n` (up to `10^9`).

Observation:
- Each round consists of `5 × copies` drinks
- Initially, `copies = 1`
- After each round, `copies` doubles

We subtract full rounds from `n` until it fits in the current round.

---

## 🧠 Approach
1. Store the five names in an array
2. Initialize `copies = 1`
3. While `n > 5 × copies`:
   - Subtract the round size from `n`
   - Double `copies`
4. Compute index:
   ```
   index = (n - 1) / copies
   ```
5. Print the name at that index

---

## ✅ Java Implementation
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] names = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int copies = 1;

        while (n > 5 * copies) {
            n -= 5 * copies;
            copies *= 2;
        }

        int index = (n - 1) / copies;
        System.out.println(names[index]);
        scanner.close();
    }
}
```

---

## 🧪 Examples
| Input | Output |
|------|--------|
| 1 | Sheldon |
| 6 | Sheldon |
| 1802 | Penny |

---

## ⏱️ Complexity Analysis
- **Time Complexity:** `O(log n)`
- **Space Complexity:** `O(1)`

---

## 🎯 Takeaways
- Pattern recognition avoids brute-force simulation
- Exponential growth problems often reduce to logarithmic loops
- Integer arithmetic can replace queue simulation efficiently

---

⭐ *A classic Codeforces problem demonstrating mathematical optimization over simulation.*
