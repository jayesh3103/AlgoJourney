# 📘 A. Cifera – Codeforces

## 📝 Problem Summary

You are given two integers:

- `k`
- `l`

A number belongs to the **petriciumus cifera** set if it can be written as:

k¹, k², k³, k⁴, ...

If `l = k^m` for some integer `m ≥ 1`, then:

- Print `"YES"`
- Print the **importance**, which equals `m - 1`

Otherwise, print `"NO"`.

---

## 💡 Idea

We repeatedly multiply `k` until:

- It becomes equal to `l`
- Or it exceeds `l`

If it becomes equal → valid power  
If it exceeds → not valid  

The number of multiplications performed equals the importance.

---

## ⏱ Complexity

- Time Complexity: **O(logₖ l)**
- Space Complexity: **O(1)**

---

## 💻 Java Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long k = sc.nextLong();
        long l = sc.nextLong();

        long current = k;
        int importance = 0;

        while (current < l) {
            current *= k;
            importance++;
        }

        if (current == l) {
            System.out.println("YES");
            System.out.println(importance);
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}
