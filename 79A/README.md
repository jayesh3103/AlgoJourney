# 📌 A. Bus Game

## 📅 Problem of the Day — Codeforces    

---

## 📝 Problem Summary

Fox Ciel and Rabbit Hanako are playing a **turn-based game** on a bus.

There is a pile containing:
- `x` coins of **100 yen**
- `y` coins of **10 yen**

Each turn:
- A player must take **exactly 220 yen** from the pile.
- **Ciel** (first player) prefers the move with the **maximum number of 100-yen coins**.
- **Hanako** prefers the move with the **maximum number of 10-yen coins**.
- If a player **cannot** take exactly 220 yen, **she loses**.

---

## 🎯 Objective

Given `x` and `y`, determine **who wins the game** assuming both players play optimally following their preferences.

---

## 🧠 Valid Ways to Pay 220 Yen

| 100-yen coins | 10-yen coins |
|--------------|--------------|
| 2 | 2 |
| 1 | 12 |
| 0 | 22 |

---

## 🧠 Strategy Insight

- The game is **deterministic** (no choices once preferences are fixed)
- Each turn:
  - Ciel greedily removes **as many 100-yen coins as possible**
  - Hanako greedily removes **as many 10-yen coins as possible**
- The game continues until one player cannot make a valid move

Instead of using game theory, we **simulate turns directly** using the greedy rules.

---

## 🧠 Approach

1. Read `x` and `y`
2. Loop infinitely:
   - **Ciel's Turn**:
     - Try `(2×100 + 2×10)`
     - Else `(1×100 + 12×10)`
     - Else `(22×10)`
     - Else → **Ciel loses**
   - **Hanako's Turn**:
     - Try `(22×10)`
     - Else `(1×100 + 12×10)`
     - Else `(2×100 + 2×10)`
     - Else → **Hanako loses**
3. Print the winner

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(n)`  |
| **Space Complexity** | `O(1)` |


---

## 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        while (true) {
            if (x >= 2 && y >= 2) {
                x -= 2;
                y -= 2;
            } else if (x >= 1 && y >= 12) {
                x -= 1;
                y -= 12;
            } else if (y >= 22) {
                y -= 22;
            } else {
                System.out.println("Hanako");
                return;
            }
            
            if (y >= 22) {
                y -= 22;
            } else if (x >= 1 && y >= 12) {
                x -= 1;
                y -= 12;
            } else if (x >= 2 && y >= 2) {
                x -= 2;
                y -= 2;
            } else {
                System.out.println("Ciel");
                return;
            }
        }
    }
}
