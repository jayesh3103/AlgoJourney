# 💬 A. Chat Room – Codeforces Practice

This is my solution for the **Chat Room** problem from Codeforces.  
This README explains the **logic, intuition, and full Java implementation**.

---

## 📄 Problem Summary

Vasya wants to say `"hello"` in a chat room.  
He typed a string `s`, and he is considered successful **if we can delete some characters** from `s` (keeping order) to obtain the exact word:
`hello`
This means we are checking whether `"hello"` is a **subsequence** of the string `s`.

### Examples
- `"ahhellllloou"` → contains `h`, `e`, `l`, `l`, `o` in order → **YES**
- `"hlelo"` → the order gets broken → **NO**

---

## 💡 Approach

This is a classic **subsequence check** problem.

1. Maintain a pointer `targetPtr` for the word `"hello"`.
2. Scan the input string `s` from left to right.
3. Each time the current character matches the current character of `"hello"`, move the pointer forward.
4. If the pointer reaches the end of `"hello"`, it means we found all characters in order.

This works in **O(n)** time with **O(1)** space.

---

## 🖥️ Implementation (Java)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String s = sc.next();
        String target = "hello";
        
        int targetPtr = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (targetPtr < target.length() && s.charAt(i) == target.charAt(targetPtr)) {
                targetPtr++;
            }
        }

        if (targetPtr == target.length()) {
            out.println("YES");
        } else {
            out.println("NO");
        }

        out.close();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`
