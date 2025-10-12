# 🏭 Warehouse – Codeforces Practice

This repository contains my solution for the **“Warehouse” (Problem B)** from Codeforces.  
It simulates the process of storing and removing boxes in a warehouse following specific placement rules.

---

## 📄 Problem Description

A warehouse in Arlandia has shelves arranged in **n rows** and **m columns**, where each section can hold **exactly one box** of a magical drink.  

There are two types of operations:  
1. **`+1 x y id`** → Place a box labeled `id` at position `(x, y)`.  
   - If `(x, y)` is occupied, continue searching **rightward** on the same shelf.  
   - If the end of the shelf is reached, move **downward** to the next shelf, starting again from the first section.  
   - If no empty space exists, the box is discarded.  
2. **`-1 id`** → Remove the box with the identifier `id` and print its **(shelf, section)** position.  
   - If no such box exists, output `-1 -1`.

---

## 💡 Approach

To simulate the warehouse operations efficiently:
1. Maintain a **2D array `grid[n][m]`** to represent the shelves.
2. Use a **HashMap `locs`** to quickly find the position of any box by its ID.
3. For each operation:
   - If it's `+1`, search the shelves as per the rules and place the box in the first empty position found.
   - If it's `-1`, look up the ID in the map:
     - If found → print and remove it from both the grid and the map.
     - If not found → print `-1 -1`.

This approach ensures **accurate simulation** of the problem’s behavior while maintaining simplicity and clarity.

---

## 🖥️ Implementation (Java)

```java
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    record Pos(int r, int c) {}

    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();

            String[][] grid = new String[n][m];
            Map<String, Pos> locs = new HashMap<>();

            for (int opCount = 0; opCount < k; opCount++) {
                String type = in.next();

                if (type.equals("+1")) {
                    int r = in.nextInt() - 1;
                    int c = in.nextInt() - 1;
                    String id = in.next();

                    boolean placed = false;
                    for (int i = r; i < n && !placed; i++) {
                        int jStart = (i == r) ? c : 0;
                        for (int j = jStart; j < m && !placed; j++) {
                            if (grid[i][j] == null) {
                                grid[i][j] = id;
                                locs.put(id, new Pos(i + 1, j + 1));
                                placed = true;
                            }
                        }
                    }
                } else {
                    String id = in.next();
                    if (locs.containsKey(id)) {
                        Pos pos = locs.remove(id);
                        out.println(pos.r() + " " + pos.c());
                        grid[pos.r() - 1][pos.c() - 1] = null;
                    } else {
                        out.println("-1 -1");
                    }
                }
            }
        }
    }
}
```
---

## ✅ Complexity

- **Time Complexity:** O(n × m)
- **Space Complexity:** O(n × m) 
