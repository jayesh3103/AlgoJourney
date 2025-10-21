# ⚙️ C*++ Calculations – Codeforces Practice

This is my solution for the **C\*++ Calculations** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

The language **C\*++** behaves unpredictably when evaluating expressions containing pre-increment (`++a`) and post-increment (`a++`) operations.  

You are given:
- An initial value of the variable `a`.
- An arithmetic expression that may include:
  - Terms like `a++`, `++a`, or their coefficient-multiplied versions (e.g. `5*a++`, `3*++a`).
  - Plus or minus signs between terms.

The rules of evaluation are:
- `a++`: Use the current value of `a`, **then increment** `a` by 1.
- `++a`: **Increment** `a` by 1, then use the updated value.
- Summands can be evaluated in **any order**, and we must find the **maximum possible value** of the expression.

---

## 💡 Approach

1. **Parse the Expression:**
   - Add a `'+'` sign to the beginning (for easier parsing).
   - Traverse the string and extract:
     - **Sign** (`+` or `-`)
     - **Coefficient** (default = 1 if omitted)
     - **Type** of term (`++a` or `a++`).

2. **Represent Each Term:**
   - Use a `Term` class storing:
     - `coeff`: signed integer (based on `+` or `-`)
     - `isPreIncrement`: boolean flag for whether it’s a pre-increment.

3. **Order of Evaluation (Key Insight):**
   - To **maximize** the result:
     - Compute terms with **smaller coefficients first**, since earlier increments affect later terms.
   - Sort all terms by coefficient (ascending order).

4. **Simulate Evaluation:**
   - For each term:
     - If pre-increment → increment `a`, then add `coeff × a`.
     - If post-increment → add `coeff × a`, then increment `a`.

---

## 🧠 Core Idea

> Since increments permanently raise `a`, higher-coefficient terms should be computed later to multiply a larger `a` value.  
This observation turns the problem into a **greedy sorting** one.

---

## 🖥️ Implementation (Java)

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Term implements Comparable<Term> {
        int coeff;
        boolean isPreIncrement;

        Term(int coeff, boolean isPreIncrement) {
            this.coeff = coeff;
            this.isPreIncrement = isPreIncrement;
        }

        @Override
        public int compareTo(Term other) {
            return Integer.compare(this.coeff, other.coeff);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        String expr = in.next();

        if (expr.charAt(0) != '+' && expr.charAt(0) != '-') {
            expr = "+" + expr;
        }

        List<Term> terms = new ArrayList<>();
        int i = 0;
        while (i < expr.length()) {
            int sign = (expr.charAt(i) == '+') ? 1 : -1;
            i++;

            int numStart = i;
            while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                i++;
            }

            int coeff = 1;
            if (i > numStart) {
                coeff = Integer.parseInt(expr.substring(numStart, i));
            }

            if (i < expr.length() && expr.charAt(i) == '*') {
                i++;
            }

            boolean isPre = (expr.charAt(i) == '+');
            i += 3; 

            terms.add(new Term(sign * coeff, isPre));
        }

        Collections.sort(terms);

        long total = 0;
        for (Term t : terms) {
            if (t.isPreIncrement) {
                a++;
                total += (long) t.coeff * a;
            } else {
                total += (long) t.coeff * a;
                a++;
            }
        }

        System.out.println(total);
        in.close();
    }
}
```

---

## ✅ Complexity

- **Time Complexity:** `O(nlogn)` 
- **Space Complexity:** `O(n)`
