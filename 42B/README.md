# ♟️ Game of Chess Unfinished – Codeforces Practice

This is my solution for the **B. Game of Chess Unfinished** problem from Codeforces.  
This README explains my **approach, logic, and implementation** behind determining whether the black king is checkmated.

---

## 📄 Problem Description

On an 8×8 chessboard, there are **four pieces**:
- Two **white rooks**
- One **white king**
- One **black king**

All positions are **valid** — meaning:
- No two pieces share the same cell.
- Kings are not in a position to capture each other.

Your task is to determine whether the **black king is checkmated**.

A **checkmate** occurs when:
- The black king is **under attack** by one or more white pieces, **and**
- It **cannot move** to any adjacent cell that is not attacked.

You must output:
- `"CHECKMATE"` — if the black king is in checkmate.
- `"OTHER"` — otherwise.

---

## 💡 Approach

1. **Input Parsing**
   - Read four positions: two rooks, white king, and black king.
   - Convert chess notation (e.g. `a6`, `c8`) to numeric coordinates for easier calculation.

2. **Rook Attack Logic**
   - A rook attacks all cells **in the same row or column**, unless blocked by another piece.
   - The helper function `rookAtk()` checks if a rook at `(r, c)` can attack a target position considering all obstacles.

3. **Check If Black King Is Attacked**
   - The black king’s current position is **attacked** if:
     - It is within one cell of the white king (adjacent attack), or
     - Either rook can attack it without obstruction.

4. **Check All Possible Moves**
   - The black king can move to any of the **8 adjacent squares**.
   - For each move:
     - Check if it’s inside the board.
     - Check if it’s attacked by any white piece.
   - If the black king has at least one **safe square**, it’s **not checkmate**.

5. **Final Decision**
   - If **no safe moves exist** → `"CHECKMATE"`.
   - Else → `"OTHER"`.

---

## 🧠 Core Idea

> To identify checkmate, simulate the black king’s **surrounding moves** and check if every possible position is under attack by the white pieces.  
If **no escape square exists**, the black king is **trapped and defeated**.

---

## 🖥️ Implementation (Java)

```java
import java.util.Scanner;

public class Main {

    private static boolean isBetween(int a, int mid, int b) {
        return (mid > Math.min(a, b) && mid < Math.max(a, b));
    }

    private static int[] parse(String s) {
        return new int[]{s.charAt(1) - '1', s.charAt(0) - 'a'};
    }

    private static boolean rookAtk(int r, int c, int[] rook, int[] b1, int[] b2, int[] b3) {
        if (r == rook[0] && c == rook[1]) return false;

        if (r == rook[0]) {
            if (b1[0] == r && isBetween(rook[1], b1[1], c)) return false;
            if (b2[0] == r && isBetween(rook[1], b2[1], c)) return false;
            if (b3[0] == r && isBetween(rook[1], b3[1], c)) return false;
            return true;
        }

        if (c == rook[1]) {
            if (b1[1] == c && isBetween(rook[0], b1[0], r)) return false;
            if (b2[1] == c && isBetween(rook[0], b2[0], r)) return false;
            if (b3[1] == c && isBetween(rook[0], b3[0], r)) return false;
            return true;
        }
        return false;
    }

    private static boolean isAttacked(int r, int c, int[] r1, int[] r2, int[] wk, int[] bk) {
        if (Math.abs(r - wk[0]) <= 1 && Math.abs(c - wk[1]) <= 1) {
            return true;
        }
        if (rookAtk(r, c, r1, r2, wk, bk)) {
            return true;
        }
        if (rookAtk(r, c, r2, r1, wk, bk)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] r1 = parse(in.next());
        int[] r2 = parse(in.next());
        int[] wk = parse(in.next());
        int[] bk = parse(in.next());
        in.close();

        boolean canEscape = false;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nr = bk[0] + dr;
                int nc = bk[1] + dc;

                if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) {
                    if (!isAttacked(nr, nc, r1, r2, wk, new int[]{nr, nc})) {
                        canEscape = true;
                        break;
                    }
                }
            }
            if (canEscape) {
                break;
            }
        }

        System.out.println(canEscape ? "OTHER" : "CHECKMATE");
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`
