# 🧩 B. Vasya and Types

## 📌 Problem Overview

Vasya is learning a new programming language **&K*** which has a powerful and unusual type system.

### 🔹 Core Concepts
- `void` and `errtype` are the only **base types**
- `*` (pointer) increases pointer depth
- `&` (dereference) decreases pointer depth
- Dereferencing `void` results in `errtype`
- For `errtype`:

errtype* = &errtype = errtype

### 🔹 Operators
- `typedef A B`  
Defines a new type `B` equivalent to type expression `A`
- `typeof A`  
Outputs the normalized type of `A` in terms of `void*****`

⚠️ Operators are executed **sequentially**, and redefining a type does **not** affect previously defined types.

---

## 🎯 Objective

Process a sequence of `typedef` and `typeof` operations and output the result of each `typeof` query.

---

## 🧠 Key Insight

Each type can be represented as:
- `-1` → `errtype`
- `0` → `void`
- `k ≥ 1` → `void*...*` (k stars)

### Type Evaluation Rules
1. Count leading `&` (dereference operations)
2. Count trailing `*` (pointer operations)
3. Resolve base type
4. Apply stars **before** ampersands
5. If dereference exceeds pointer depth → `errtype`

This reduces the entire problem to **integer arithmetic on pointer depth**.

---

## 🛠️ Algorithm

For each operation:

### `typedef A B`
- Evaluate type expression `A`
- Store its pointer depth for name `B`

### `typeof A`
- Evaluate type expression `A`
- Output:
- `"errtype"` if invalid
- `"void*****"` according to pointer depth

---

## 💻 Java Implementation

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();

      Map<String, Integer> types = new HashMap<>();
      types.put("void", 0);
      types.put("errtype", -1);

      for (int i = 0; i < n; i++) {
          String op = sc.next();

          if (op.equals("typedef")) {
              String expr = sc.next();
              String name = sc.next();
              int value = evaluate(expr, types);
              types.put(name, value);
          } else { // typeof
              String expr = sc.next();
              int value = evaluate(expr, types);

              if (value == -1) {
                  System.out.println("errtype");
              } else {
                  System.out.print("void");
                  for (int j = 0; j < value; j++) {
                      System.out.print("*");
                  }
                  System.out.println();
              }
          }
      }
      sc.close();
  }

  private static int evaluate(String expr, Map<String, Integer> types) {
      int amp = 0, star = 0;
      int l = 0, r = expr.length() - 1;

      while (l <= r && expr.charAt(l) == '&') {
          amp++;
          l++;
      }
      while (l <= r && expr.charAt(r) == '*') {
          star++;
          r--;
      }

      if (l > r) return -1;

      String base = expr.substring(l, r + 1);
      if (!types.containsKey(base)) return -1;

      int baseVal = types.get(base);
      if (baseVal == -1) return -1;

      int total = baseVal + star;
      if (total < amp) return -1;

      return total - amp;
  }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n × L)`
- **Space Complexity:** `O(n)`
