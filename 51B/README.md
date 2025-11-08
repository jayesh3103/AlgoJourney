# 🧮 bHTML Tables Analysis – Codeforces Practice

This is my solution for the **bHTML Tables Analysis** problem from Codeforces.  
This README explains my **approach, implementation, and reasoning** behind the solution.

---

## 📄 Problem Description

You are given a **simplified version of HTML tables** (called **bHTML**), described by the following grammar:

`TABLE ::= ROWS`
`ROWS  ::= ROW | ROW ROWS`
`ROW   ::= CELLS`
`CELLS ::= CELL | CELL CELLS`
`CELL  ::=  | TABLE`

- Every table contains **one or more rows**, and each row contains **one or more cells**.  
- Each cell can either be **empty** (`<td></td>`) or contain a **nested table** (`<td>TABLE</td>`).  
- The task is to **analyze all tables** and find the **number of cells** in each of them.

You need to output the **sizes of all tables** (number of cells) in **non-decreasing order**.

---

## 💡 Approach

1. **Read and merge all input lines:**  
   - The input table can be split across multiple lines.  
   - Combine them into a single string for uniform parsing.

2. **Extract and analyze tags:**  
   - Split the string using the regex `(?=<)` so each tag can be processed sequentially.

3. **Use a stack to track nested tables:**  
   - Push `0` when a new `<table>` starts.  
   - For each `<td>`, increment the top value on the stack (adding a cell).  
   - When encountering `</table>`, pop the top element — it represents one table’s total cell count.

4. **Store and sort results:**  
   - Store all table sizes in a list.  
   - Sort them in non-decreasing order for final output.

5. **Print results:**  
   - Output all table sizes separated by spaces.

---

## 🖥️ Implementation (Java)

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            sb.append(in.nextLine());
        }
        String s = sb.toString();
        in.close();

        Stack<Integer> stack = new Stack<>();
        List<Integer> sizes = new ArrayList<>();

        String[] tags = s.split("(?=<)");

        for (String tag : tags) {
            if (tag.equals("<table>")) {
                stack.push(0);
            } else if (tag.equals("</table>")) {
                if (!stack.isEmpty()) {
                    sizes.add(stack.pop());
                }
            } else if (tag.equals("<td>")) {
                if (!stack.isEmpty()) {
                    stack.push(stack.pop() + 1);
                }
            }
        }

        Collections.sort(sizes);

        for (int i = 0; i < sizes.size(); i++) {
            System.out.print(sizes.get(i));
            if (i < sizes.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
```
---

## ✅ Complexity

- **Time Complexity:** `O(n)` 
- **Space Complexity:** `O(n)` 
