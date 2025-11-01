# ✊✋✌️ Rock-paper-scissors — Codeforces Practice

This is my solution for the **A. Rock-paper-scissors** problem from Codeforces.  
This README explains the **logic, approach, and Java implementation** used to solve the problem.

---

## 📄 Problem Description

Uncle Fyodor, Matroskin the Cat, and Sharic the Dog 🐾 decided to settle a dispute fairly —  
by playing **Rock-Paper-Scissors**!

The twist? There are **three players** instead of two.  
They must determine if **one of them wins outright** or if the game is **a draw**.

The rules are familiar:
- **Rock** breaks **Scissors**  
- **Scissors** cut **Paper**  
- **Paper** wraps **Rock**

However, with three players:
- If **one player’s gesture beats both others**, they are the **winner**.
- If no single gesture dominates, it’s a **draw** and the result is **"?"**.


---

## 💡 Approach

1. **Read all three gestures** — one for each player.  
2. For each player, check **if their gesture wins against both others**:
   - Example:  
     Fyodor wins if he shows **rock**, while both Matroskin and Sharic show **scissors**.  
3. Use logical conditions to verify all three winning scenarios.  
4. If none of the conditions hold, print `"?"`.

---

## 🧠 Core Idea

> “A player wins only if their gesture beats both of the other gestures.”

This ensures:
- **Fyodor wins** → if his hand beats both Matroskin and Sharic.  
- **Matroskin wins** → if his gesture beats both of the others.  
- **Sharic wins** → if his gesture beats both of the others.  
- Otherwise, it’s a **tie**.

---

## 🖥️ Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String f = in.next();
            String m = in.next();
            String s = in.next();

            boolean fWins = (f.equals("rock") && m.equals("scissors") && s.equals("scissors")) ||
                            (f.equals("scissors") && m.equals("paper") && s.equals("paper")) ||
                            (f.equals("paper") && m.equals("rock") && s.equals("rock"));

            boolean mWins = (m.equals("rock") && f.equals("scissors") && s.equals("scissors")) ||
                            (m.equals("scissors") && f.equals("paper") && s.equals("paper")) ||
                            (m.equals("paper") && f.equals("rock") && s.equals("rock"));

            boolean sWins = (s.equals("rock") && f.equals("scissors") && m.equals("scissors")) ||
                            (s.equals("scissors") && f.equals("paper") && m.equals("paper")) ||
                            (s.equals("paper") && f.equals("rock") && m.equals("rock"));

            if (fWins) {
                System.out.println("F");
            } else if (mWins) {
                System.out.println("M");
            } else if (sWins) {
                System.out.println("S");
            } else {
                System.out.println("?");
            }
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`
