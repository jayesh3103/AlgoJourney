# 🚰 A. Dorm Water Supply — Codeforces

## 🏠 Problem Overview

The GUC dorm houses are connected using **directed water pipes**.

Each house:
- Has **at most one incoming pipe**
- Has **at most one outgoing pipe**

Each pipe has:
- A **direction**
- A **diameter** (maximum water capacity)

---

## 🎯 Goal

Lulu must:

- Install a **tank** at every house with:
  - An outgoing pipe
  - No incoming pipe

- Install a **tap** at every house with:
  - An incoming pipe
  - No outgoing pipe

Each tank supplies water through a chain of pipes to a tap.

The maximum safe water flow from a tank to a tap is:

> The **minimum diameter** along the pipe chain between them.

---

## 🧠 Key Observations

Because:

- Each house has **at most one outgoing pipe**
- Each house has **at most one incoming pipe**

The structure forms:

- Independent **linear chains**
- Possibly **cycles**

We only care about **chains** that:

- Start at a tank (in-degree = 0, has outgoing)
- End at a tap (no outgoing)

If a cycle exists → no tank exists in that component → ignore.

---

## 🧩 Strategy

1. Store:
   - `nextHouse[i]` → where pipe from `i` goes
   - `pipeDiameter[i]` → diameter of outgoing pipe
   - `inDegree[i]` → count incoming pipes

2. For every house:
   - If `inDegree[i] == 0` AND it has outgoing pipe
     → it's a **tank**
   - Traverse until no outgoing pipe
   - Track minimum diameter along path
   - That endpoint is the **tap**

3. Store results
4. Sort by tank index
5. Print

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|--------|------------|
| Time Complexity | **O(n)** |
| Space Complexity | **O(n)** |

Since each house is visited at most once in a chain traversal.

Constraints: `n ≤ 1000` → Fully safe.

---

## 💻 Java Implementation

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class TankTap implements Comparable<TankTap> {
        int tank;
        int tap;
        int minDiameter;

        public TankTap(int tank, int tap, int minDiameter) {
            this.tank = tank;
            this.tap = tap;
            this.minDiameter = minDiameter;
        }

        @Override
        public int compareTo(TankTap other) {
            return Integer.compare(this.tank, other.tank);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {

            int n = scanner.nextInt();
            int p = scanner.nextInt();

            int[] nextHouse = new int[n + 1];
            int[] pipeDiameter = new int[n + 1];
            int[] inDegree = new int[n + 1];

            // Read pipes
            for (int i = 0; i < p; i++) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                int diameter = scanner.nextInt();

                nextHouse[from] = to;
                pipeDiameter[from] = diameter;
                inDegree[to]++;
            }

            List<TankTap> result = new ArrayList<>();

            // Identify tank houses
            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0 && nextHouse[i] != 0) {

                    int current = i;
                    int minDiameter = Integer.MAX_VALUE;

                    // Traverse chain
                    while (nextHouse[current] != 0) {
                        minDiameter = Math.min(minDiameter, pipeDiameter[current]);
                        current = nextHouse[current];
                    }

                    result.add(new TankTap(i, current, minDiameter));
                }
            }

            Collections.sort(result);

            // Output
            System.out.println(result.size());
            for (TankTap pair : result) {
                System.out.println(pair.tank + " " + pair.tap + " " + pair.minDiameter);
            }
        }

        scanner.close();
    }
}
