# 👖 A. Testing Pants for Sadness — Codeforces

## 🧠 Problem Summary

Vaganych must pass a computer test consisting of **n questions**, answered **strictly in order**.

- Question `i` has `aᵢ` answer options
- Exactly **one** option is correct
- Selecting an answer counts as **one click**
- If a **wrong answer** is selected:
  - All progress is reset
  - The test restarts from **question 1**
- Vaganych has **perfect memory**, but **no knowledge** of correct answers
- He chooses answers optimally to **minimize the total number of clicks**
- We must compute the **worst-case** number of clicks required to pass the test

---

## 🎯 Goal

Determine the **minimum number of clicks required in the worst case** to correctly answer all questions.

---

## 🔍 Key Insight

For each question `i`:

- In the worst case, Vaganych tries **all wrong answers first**
- Each wrong attempt at question `i` costs:
  - `i` clicks (since he must re-answer all previous correct questions)
- Finally, **1 click** is needed for the correct answer

So for question `i`:

Clicks = (aᵢ − 1) × i + 1

The total answer is the **sum of this value for all questions**.

---

## ✏️ Formula

\[
\text{Total Clicks} = \sum_{i=1}^{n} \big((a_i - 1) \cdot i + 1\big)
\]

---

## 📥 Input Format

- Integer `n` — number of questions `(1 ≤ n ≤ 100)`
- `n` integers `a₁, a₂, …, aₙ` — number of answer options per question `(1 ≤ aᵢ ≤ 10⁹)`

---

## 📤 Output Format

- Print **one integer** — the minimal number of clicks in the worst case

---

## 🧪 Examples

| Input | Output |
|-----|------|
| `2`<br>`1 1` | `2` |
| `2`<br>`2 2` | `5` |
| `1`<br>`10` | `10` |

---

## 🧠 Example Explanation (2 2)

Worst case:
1. Pick wrong answer for Q1 → reset
2. Pick correct answer for Q1
3. Pick wrong answer for Q2 → reset
4. Pick correct answer for Q1
5. Pick correct answer for Q2

➡️ **Total clicks = 5**

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| Time | **O(n)** |
| Space | **O(1)** |

Efficient even with very large `aᵢ` values.

---

## ✅ Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long totalClicks = 0;

        for (int i = 1; i <= n; i++) {
            long a = sc.nextLong();
            totalClicks += (a - 1) * i + 1;
        }

        System.out.println(totalClicks);
    }
}
