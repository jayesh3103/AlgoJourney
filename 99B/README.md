# 🧃 B. Help Chef Gerasim — Codeforces

## 📌 Problem Summary

Chef Gerasim suspects that the royal pages may have poured juice **from one cup to another exactly once**.  
You are given the final measured volumes of juice in `n` cups and must determine:

1. **No pouring happened** → all cups were originally equal  
2. **Exactly one pouring happened** → identify:
   - how much juice was poured (`v`)
   - from which cup (`a`)
   - to which cup (`b`)
3. **Impossible to recover** → configuration cannot be obtained with ≤ 1 pour

⚠️ Only **integer milliliters** can be poured, and cups are **bottomless**.

---

## 📥 Input

- Integer `n` — number of cups (`1 ≤ n ≤ 1000`)
- Next `n` lines — non-negative integers (`≤ 10⁴`) representing juice volumes

---

## 📤 Output

Exactly **one** of the following:

- `Exemplary pages.`
- `v ml. from cup #a to cup #b.`
- `Unrecoverable configuration.`

---

## 🧠 Key Observations

- Total juice **must remain constant**
- If **all cups are equal** → no pouring
- If **exactly two cups differ** from the average → one pour possible
- Any other configuration → unrecoverable

---

## ✅ Strategy

1. Compute total sum
2. Check if average volume is an integer
3. Count cups differing from the average
4. Handle cases based on difference count

---

## ⏱️ Complexity

| Aspect | Value |
|------|------|
| Time | **O(n)** |
| Space | **O(n)** |

---

## 💡 Java Solution

```java
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cups = new int[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            cups[i] = sc.nextInt();
            sum += cups[i];
        }

        // If average is not integer, impossible
        if (sum % n != 0) {
            System.out.println("Unrecoverable configuration.");
            return;
        }

        int target = (int) (sum / n);
        ArrayList<Integer> diff = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (cups[i] != target) {
                diff.add(i);
            }
        }

        if (diff.isEmpty()) {
            System.out.println("Exemplary pages.");
        } else if (diff.size() == 2) {
            int i = diff.get(0);
            int j = diff.get(1);

            int from, to, amount;

            if (cups[i] > cups[j]) {
                from = i + 1;
                to = j + 1;
                amount = cups[i] - target;
            } else {
                from = j + 1;
                to = i + 1;
                amount = cups[j] - target;
            }

            System.out.println(amount + " ml. from cup #" + from + " to cup #" + to + ".");
        } else {
            System.out.println("Unrecoverable configuration.");
        }
    }
}
