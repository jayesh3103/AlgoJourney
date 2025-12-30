# 📌 A. Plug-in

## 📅 Problem of the Day — Codeforces  

---

## 📝 Problem Summary

Polycarp often types the same letter multiple times consecutively due to overthinking.  
To fix this, he wants a **text editor plug-in** that removes **pairs of identical consecutive letters**.

### Important Rules:
- If two **identical letters appear consecutively**, remove them.
- After removal, **new adjacent pairs may form**, which must also be removed.
- This process continues **until no such pairs remain**.
- The final string is guaranteed to have **at least one character**.

---

## 🎯 Objective

Given a string `s`:
- Repeatedly remove **adjacent identical character pairs**
- Output the **final processed string**

---

## 🧠 Key Insight

This problem is equivalent to:
- Repeatedly canceling matching adjacent characters
- Which is a **classic stack problem**

Using a stack ensures:
- Each character is processed **once**
- Adjacent duplicates are removed immediately
- Overall time complexity stays efficient for large inputs

---

## 🧠 Approach

1. Create a character stack
2. Traverse the string character by character
3. For each character:
   - If the stack top is the same → **pop**
   - Otherwise → **push**
4. Convert the stack back into a string

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(n)` |
| **Space Complexity** | `O(n)` |

Where `n` is the length of the string.

---

## 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        char[] stack = new char[s.length()];
        int top = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (top >= 0 && stack[top] == c) {
                top--; 
            } else {
                stack[++top] = c; 
            }
        }
        
        System.out.println(new String(stack, 0, top + 1));
    }
}
