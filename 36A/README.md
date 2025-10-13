# 🛸 Extra-terrestrial Intelligence – Codeforces Practice

This is my solution for the **Extra-terrestrial Intelligence** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

- Vasya has been recording **signals** for `n` consecutive days.  
- On each day:
  - He writes `1` if a signal was received.
  - He writes `0` if no signal was received.  
- Vasya believes he has discovered **intelligent alien life** if all intervals between consecutive `1`s are **equal**.  
- Otherwise, the signals are considered random.

---

## 💡 Approach

1. **Read Input:**  
   - First line → number of days `n`.  
   - Second line → binary string of length `n`.  

2. **Find Signal Days:**  
   - Store all indices where `s[i] == '1'` in a list `ones`.  

3. **Compute Intervals:**  
   - Calculate the first gap: `diff = ones[1] - ones[0]`.  
   - For all subsequent `1`s, verify that  
     `ones[i] - ones[i - 1] == diff`.  

4. **Output Result:**  
   - If all intervals are equal → print `"YES"`.  
   - Otherwise → print `"NO"`.  

> This method ensures we only check **relative differences** between signal positions, keeping the logic simple and accurate.

---

## 🖥️ Implementation (Java)

```java
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            in.nextInt();
            String s = in.next();

            List<Integer> ones = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    ones.add(i);
                }
            }

            boolean ok = true;
            int diff = ones.get(1) - ones.get(0);
            for (int i = 2; i < ones.size(); i++) {
                if (ones.get(i) - ones.get(i - 1) != diff) {
                    ok = false;
                    break;
                }
            }

            out.println(ok ? "YES" : "NO");
        }
    }
}
```

---

## ✅ Complexity

- **Time Complexity:** `O(n)` 
- **Space Complexity:** `O(n)` 
