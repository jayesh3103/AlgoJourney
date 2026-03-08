# 🎮 A. Epic Game – Codeforces

## 📝 Problem Overview

Two players play a turn-based game with a **heap of `n` stones**.

Players:

- **Simon** → fixed number `a`
- **Antisimon** → fixed number `b`

Simon always **starts first**.

---

## 🎯 Game Rule

On each turn, a player must remove:

```
gcd(player_number, current_stones)
```

stones from the heap.

Where:

```
gcd(x, y) = greatest common divisor of x and y
```

After removing stones:

```
n = n - gcd(player_number, n)
```

---

## ❌ Losing Condition

A player **loses** if:

```
stones left < gcd(player_number, stones_left)
```

Meaning the player **cannot remove the required number of stones**.

---

## 🏆 Output Rule

Print:

```
0 → Simon wins
1 → Antisimon wins
```

---

# 💡 Strategy

We simulate the game turn by turn.

Variables:

```
turn = 0 → Simon
turn = 1 → Antisimon
```

Loop until someone loses.

Steps each turn:

1️⃣ Compute:

```
required = gcd(player_number, n)
```

2️⃣ If:

```
required > n
```

player loses.

3️⃣ Otherwise:

```
n -= required
```

4️⃣ Switch turn.

---

# ⏱ Complexity

Maximum stones:

```
n ≤ 100
```

Each move removes **at least 1 stone**, so at most **100 iterations**.

Time Complexity:

```
O(n log n)
```

Space Complexity:

```
O(1)
```

---

# 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        int turn = 0; // 0 = Simon, 1 = Antisimon

        while (true) {

            int playerNumber = (turn == 0) ? a : b;

            int required = gcd(playerNumber, n);

            if (required > n) {
                System.out.println(turn == 0 ? 1 : 0);
                break;
            }

            n -= required;

            turn = 1 - turn;
        }

        sc.close();
    }

    static int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}
```
