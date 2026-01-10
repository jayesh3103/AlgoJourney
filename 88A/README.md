# 🎵 A. Chord — README.md

## 🧩 Problem Overview
Vasya is learning music theory and needs help classifying **triads** (chords of exactly three notes).

There are **12 musical notes** arranged cyclically:

C, C#, D, D#, E, F, F#, G, G#, A, B, H

Each adjacent note is **1 semitone apart**.

A triad can be:
- **Major** → distances of **4 semitones then 3 semitones**
- **Minor** → distances of **3 semitones then 4 semitones**
- **Strange** → neither major nor minor

The order of input notes is **unordered**, so all permutations must be considered.

---

## 🛠️ Approach Used

1. **Map Notes to Indices**
   - Store all 12 notes in an array.
   - Convert each input note to its corresponding index (0–11).

2. **Handle Cyclic Nature**
   - Use modulo (`% 12`) to correctly compute distances across the circular scale.

3. **Check All Permutations**
   - Since the chord is unordered, generate all `3! = 6` permutations.
   - For each permutation:
     - Compute distance from X → Y
     - Compute distance from Y → Z

4. **Classify the Chord**
   - If distances are `(4, 3)` → **major**
   - If distances are `(3, 4)` → **minor**
   - If none match → **strange**

The problem guarantees that the answer is **unambiguous**.

---

## 💻 Implementation (Java)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};
        
        String s1 = scanner.next();
        String s2 = scanner.next();
        String s3 = scanner.next();
        
        int i1 = getIndex(notes, s1);
        int i2 = getIndex(notes, s2);
        int i3 = getIndex(notes, s3);
        
        int[] idx = {i1, i2, i3};
        
        int[][] permutations = {
            {0, 1, 2}, {0, 2, 1},
            {1, 0, 2}, {1, 2, 0},
            {2, 0, 1}, {2, 1, 0}
        };
        
        for (int[] p : permutations) {
            int a = idx[p[0]];
            int b = idx[p[1]];
            int c = idx[p[2]];
            
            int dist1 = (b - a + 12) % 12;
            int dist2 = (c - b + 12) % 12;
            
            if (dist1 == 4 && dist2 == 3) {
                System.out.println("major");
                return;
            }
            if (dist1 == 3 && dist2 == 4) {
                System.out.println("minor");
                return;
            }
        }
        
        System.out.println("strange");
    }
    
    private static int getIndex(String[] notes, String target) {
        for (int i = 0; i < notes.length; i++) {
            if (notes[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`

