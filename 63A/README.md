# 🚢 Codeforces Daily Problem — A. Sinking Ship  

## 📌 Problem Summary  
A ship is sinking, and the entire crew is lined up from **1 to n**. Each member has a **name** and a **status**.  
Your task is to print the order in which crew members should evacuate based on the strict priority rules:

### 🧭 Evacuation Priority  
1. **Rats**  
2. **Women & Children** (same priority, keep original order)  
3. **Men**  
4. **Captain** (always last)

If two members have equal priority, the one standing **earlier in the line** leaves first.

---

## 🎯 Key Insight  
Instead of sorting with custom comparators, simply **scan the input four times**, printing members who match each category.  
This maintains stability (order of appearance) with minimal effort.

---

## 🧠 Approach  
- Read all names + statuses while preserving order.  
- Create four separate passes:
  - First print all **rats**  
  - Then **women + children**  
  - Then **men**  
  - Finally the **captain**  

This guarantees correctness due to simple prioritization and linear ordering.

---

## ✅ Java Implementation  

```java
import java.io.*;
import java.util.*;

public class SinkingShip {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        String[] names = new String[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = in.next();
            status[i] = in.next();
        }

        for (int i = 0; i < n; i++) {
            if (status[i].equals("rat")) out.println(names[i]);
        }

        for (int i = 0; i < n; i++) {
            if (status[i].equals("woman") || status[i].equals("child")) out.println(names[i]);
        }

        for (int i = 0; i < n; i++) {
            if (status[i].equals("man")) out.println(names[i]);
        }

        for (int i = 0; i < n; i++) {
            if (status[i].equals("captain")) out.println(names[i]);
        }

        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`
