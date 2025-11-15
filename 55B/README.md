# 🔢 Smallest Number – Codeforces Practice

This is my solution for the **Smallest Number** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

Vladimir writes **4 integers** on a blackboard.  
Then, over **3 steps**, he performs this process:

- Pick **any two** available numbers.
- Replace them with **their sum** or **their product**, depending on the given operation.
- Continue until only **one number** remains.

The operations (`+` or `*`) are given **in order**, and Vladimir wants to know:

### ❓ What is the **smallest possible final number** that can be obtained?

You must compute the **minimum result** achievable by exploring **all valid pairings** consistent with the operations.

---

## 💡 Approach

This is a **state-space search** / **brute-force with recursion** problem.

### Key observations:

1. At each step:
   - You choose **any pair** of numbers (order doesn't matter).
   - Apply the given operation (`+` or `*` for this step).
   - Replace the pair with the result, leaving the other numbers untouched.
2. You repeat this process exactly **3 times**, reducing the list size:  
   `4 → 3 → 2 → 1`
3. Since choices matter (different pairings produce different results),  
   → We must explore **all possibilities**.

### ✔️ Solution Strategy

- Use recursion to simulate all choices.
- For each step `k`:
  - Operation is `ops[k]`.
  - Try all combinations `(i, j)` of pairable numbers.
  - Build a new list:
    - Insert `nums[i] op nums[j]`
    - Add the untouched numbers.
  - Recurse to the next step.
- Track the **smallest final result** across all branches.

Because there are:
- `C(4,2) = 6` choices at step 1  
- `C(3,2) = 3` choices at step 2  
- `C(2,2) = 1` choice at step 3  

Total possibilities = `6 × 3 × 1 = 18` — extremely manageable.

---

## 🖥️ Implementation (Java)

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static char[] ops = new char[3];
    static long minResult = Long.MAX_VALUE;

    private static void solve(List<Long> nums, int k) {
        if (k == 3) {
            minResult = Math.min(minResult, nums.get(0));
            return;
        }

        char op = ops[k];

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                
                List<Long> nextNums = new ArrayList<>();
                long res = (op == '+') ? (nums.get(i) + nums.get(j)) : (nums.get(i) * nums.get(j));
                nextNums.add(res);

                for (int m = 0; m < nums.size(); m++) {
                    if (m != i && m != j) {
                        nextNums.add(nums.get(m));
                    }
                }
                
                solve(nextNums, k + 1);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            
            List<Long> initialNums = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                initialNums.add(in.nextLong());
            }
            
            for (int i = 0; i < 3; i++) {
                ops[i] = in.next().charAt(0);
            }
            
            solve(initialNums, 0);
            System.out.println(minResult);
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`
