# A. Measuring Lengths in Baden

> **Platform:** Codeforces &nbsp;|&nbsp; **Type:** Implementation / Math &nbsp;|&nbsp; **Difficulty:** Easy

---

## Problem Statement

Lengths in Baden are measured in **inches** and **feet**, where:

- **1 inch = 3 cm** (Baden unit)
- **1 foot = 12 inches**

Given a length `n` in centimetres, convert it to feet and inches such that the **number of feet is maximised**. The result must contain an **integer number of inches**, rounded to the nearest value.

### Rounding Rule

| Remainder (cm) | Rounds to |
|:--------------:|:---------:|
| 1 cm           | 0 inches  |
| 2 cm           | 1 inch    |

---

## Input

A single integer `n` — the length in centimetres.

```
1 ≤ n ≤ 10000
```

## Output

Two space-separated non-negative integers `a b`:
- `a` — number of feet
- `b` — number of inches

---

## Examples

| Input | Output | Explanation |
|-------|--------|-------------|
| `42`  | `1 2`  | 42 cm → 14 inches → 1 foot 2 inches |
| `5`   | `0 2`  | 5 cm → rounds to 2 inches → 0 feet 2 inches |

---

## Key Insight

The rounding rule (`1 cm → 0 in`, `2 cm → 1 in`) is equivalent to:

```
totalInches = (n + 1) / 3   // integer division
```

This is standard **round-half-up** behaviour on `n / 3`, handled cleanly with the `+1` trick before integer division.

Once total inches are known:

```
feet   = totalInches / 12
inches = totalInches % 12
```

---

## Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int totalInches = (n + 1) / 3;  // round to nearest inch

        int feet   = totalInches / 12;
        int inches = totalInches % 12;

        System.out.println(feet + " " + inches);
        sc.close();
    }
}
```

---

## Walkthrough

**Input:** `42`

```
totalInches = (42 + 1) / 3 = 43 / 3 = 14
feet        = 14 / 12 = 1
inches      = 14 % 12 = 2
Output: 1 2 ✓
```

**Input:** `5`

```
totalInches = (5 + 1) / 3 = 6 / 3 = 2
feet        = 2 / 12 = 0
inches      = 2 % 12 = 2
Output: 0 2 ✓
```

---

## Complexity

| | Complexity |
|---|---|
| **Time** | O(1) |
| **Space** | O(1) |

---

## Topics

`Math` &nbsp; `Implementation` &nbsp; `Integer Division` &nbsp; `Unit Conversion` &nbsp; `Rounding`
