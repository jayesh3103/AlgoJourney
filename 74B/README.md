# 🚆 B. Train

## 📅 Problem of the Day — Codeforces  

---

## 📝 Problem Summary

A **stowaway** and a **controller** play a game on a train consisting of `n` wagons.

- Each minute, the train is either **moving** or **idle**
- The **controller** moves deterministically back and forth between head and tail
- The **stowaway** moves strategically to avoid being caught and to eventually escape

The goal is to determine **who wins** assuming **optimal play**.

---

## 🎯 Winning Conditions

- **Controller wins**  
  If at any minute both players occupy the **same wagon**

- **Stowaway wins**  
  If the stowaway reaches the **terminal station** and leaves the train forever

---

## 🔄 Movement Rules

### 👮 Controller
- Moves **every minute**
- Moves one wagon per minute
- Bounces back at wagon `1` or `n`
- Has **only one possible move** → always optimal

### 🕵️ Stowaway
- If train is **moving (`0`)**:
  - Can move left, right, or stay
- If train is **idle (`1`)**:
  - Leaves the train
  - Re-enters into **any wagon** (except controller’s current wagon)

---

## 🧠 Key Insight

The stowaway does **not need a fixed position** —  
instead, we track **all wagons where the stowaway *could possibly be*** at a given minute.

This turns the problem into a **state-space simulation**.

---

## 🧩 Approach

1. Track:
   - Controller position and direction
   - Boolean array `possible[]` of stowaway positions
2. For each minute:
   - Update controller’s position
   - Based on train state:
     - **Idle (`1`)** → stowaway can reset to any safe wagon
     - **Moving (`0`)** → propagate possible positions (left / right / stay)
3. Eliminate positions where:
   - Controller passes through
   - Controller ends
4. If no valid stowaway positions remain → **Controller wins**
5. If terminal station reached safely → **Stowaway wins**

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(T × N)` |
| **Space Complexity** | `O(N)` |

Where:
- `T ≤ 200` (length of train state string)
- `N ≤ 50` (wagons)

---

## 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();

        fs.next(); // skip "to"
        String dirString = fs.next();

        int cDir = dirString.equals("head") ? -1 : 1;
        String s = fs.next();

        int cPos = k;
        boolean[] possible = new boolean[n + 1];
        possible[m] = true;

        for (int i = 0; i < s.length(); i++) {
            char type = s.charAt(i);

            int cStart = cPos;
            int cEnd = cPos + cDir;

            int nextDir = cDir;
            if (cEnd == 1) nextDir = 1;
            else if (cEnd == n) nextDir = -1;

            if (type == '1') {
                if (i == s.length() - 1) {
                    System.out.println("Stowaway");
                    return;
                }

                Arrays.fill(possible, true);
                possible[0] = false;
                possible[cEnd] = false;

            } else {
                boolean[] nextPossible = new boolean[n + 1];
                boolean anySafe = false;

                for (int p = 1; p <= n; p++) {
                    if (possible[p]) {
                        for (int move = -1; move <= 1; move++) {
                            int nextP = p + move;
                            if (nextP >= 1 && nextP <= n) {
                                if (nextP != cStart && nextP != cEnd) {
                                    nextPossible[nextP] = true;
                                    anySafe = true;
                                }
                            }
                        }
                    }
                }

                possible = nextPossible;

                if (!anySafe) {
                    System.out.println("Controller " + (i + 1));
                    return;
                }
            }

            cPos = cEnd;
            cDir = nextDir;
        }

        System.out.println("Stowaway");
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
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
