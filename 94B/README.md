# 🤝 B. Friends — Codeforces Problem

## 📌 Problem Summary

Igor K. is intrigued by a famous statement from **Ramsey Theory**:

> *Among any six people, there are either three pairwise acquainted people or three pairwise unacquainted people.*

Igor believes this should also hold true for **five people** and wants to verify it.

You are given:
- **5 people**, numbered from `1` to `5`
- Some pairs of people who are **acquainted (friends)**

Your task is to determine whether **among these five people** there exists:
- **Three people who all know each other**, **OR**
- **Three people who are all strangers to each other**

---

## 🧠 Key Idea

This problem is small and bounded:
- Only **5 people**
- Maximum **10 relationships**

So we can:
1. Store friendship relations in an **adjacency matrix**
2. Check **all combinations of 3 people** (`C(5,3) = 10`)
3. For each triple:
   - Check if **all three pairs are friends**
   - OR **none of the three pairs are friends**

If any triple satisfies either condition → **WIN**  
Otherwise → **FAIL**

---

## ⏱️ Complexity Analysis

| Aspect | Complexity |
|------|------------|
| Time | `O(C(5,3)) = O(1)` |
| Space | `O(1)` |

Constant time and space due to fixed size constraints.

---

## ✅ Java Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        boolean[][] friends = new boolean[6][6];

        // Read friendship relations
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            friends[u][v] = true;
            friends[v][u] = true;
        }

        // Check all combinations of 3 people
        for (int i = 1; i <= 5; i++) {
            for (int j = i + 1; j <= 5; j++) {
                for (int k = j + 1; k <= 5; k++) {

                    boolean allFriends =
                            friends[i][j] && friends[j][k] && friends[i][k];

                    boolean noFriends =
                            !friends[i][j] && !friends[j][k] && !friends[i][k];

                    if (allFriends || noFriends) {
                        System.out.println("WIN");
                        scanner.close();
                        return;
                    }
                }
            }
        }

        System.out.println("FAIL");
        scanner.close();
    }
}
