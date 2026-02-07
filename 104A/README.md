# 🃏 A. Blackjack — Codeforces

## 🌧️ Story Context

In a standard **52-card blackjack deck**, a player draws **two cards**.  
If the **sum of their points equals `n`**, the player wins.

In this problem:
- The **first card is fixed**: **Queen of Spades**
- You must count **how many possible second cards** lead to a total sum of exactly `n`

---

## 🧠 Card Values Recap

| Card Type | Point Value |
|---------|------------|
| 2–10 | Face value |
| Jack / Queen / King | 10 |
| Ace | 1 **or** 11 |

Important details:
- There are **4 cards of each value** (one per suit)
- The **Queen of Spades is already used**, so it **cannot** be drawn again

---

## 🎯 Problem Breakdown

- Queen of Spades = **10 points**
- Let  

diff = n - 10

- We must count how many remaining cards give exactly `diff` points

---

## 🔍 Case Analysis

### ❌ Impossible Cases
If:
- `diff ≤ 0` → cannot add zero or negative points
- `diff > 11` → max single-card value is Ace (11)

➡️ Output `0`

---

### 🂡 Ace Case
If:
- `diff == 1` or `diff == 11`

There are **4 Aces**, and Ace can count as **1 or 11**

➡️ Output `4`

---

### 🔢 Numeric Cards (2–9)
If:
- `2 ≤ diff ≤ 9`

Each value has **4 suits**

➡️ Output `4`

---

### 👑 Face Cards (10 points)
If:
- `diff == 10`

Valid cards:
- 4 Tens
- 4 Jacks
- 4 Queens
- 4 Kings  
- ❌ minus **Queen of Spades already used**

➡️ `16 - 1 = 15`

---

## ✅ Final Decision Table

| `diff` | Output |
|------|-------|
| `≤ 0` or `> 11` | `0` |
| `1` or `11` | `4` |
| `2–9` | `4` |
| `10` | `15` |


---

## ⏱️ Complexity

| Metric | Complexity |
|------|-----------|
| Time | **O(1)** |
| Space | **O(1)** |

---

## 🧩 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int diff = n - 10; // Queen of Spades gives 10 points

        if (diff <= 0 || diff > 11) {
            System.out.println(0);
        } 
        else if (diff == 1 || diff == 11) {
            System.out.println(4); // Aces
        } 
        else if (diff >= 2 && diff <= 9) {
            System.out.println(4); // One card per suit
        } 
        else { // diff == 10
            System.out.println(15); // All 10-point cards except Queen of Spades
        }
    }
}
