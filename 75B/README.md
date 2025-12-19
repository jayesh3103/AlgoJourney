# 📌 B. Facetook Priority Wall

## 📅 Problem of the Day — Codeforces  
**Difficulty:** Easy–Medium  
**Category:** Strings, Maps, Sorting  

---

## 📝 Problem Summary

Facetook introduces a new feature called **Priority Wall** that sorts your friends based on how frequently they interact with you.

Each interaction increases a **priority factor** between two users:

| Action | Points |
|------|--------|
| X posted on Y's wall | 15 |
| X commented on Y's post | 10 |
| X likes Y's post | 5 |

The priority factor is **mutual** (X ↔ Y).

---

## 🎯 Objective

Given:
- Your name
- A list of interaction events

You must:
1. Compute the priority factor between **you** and every other distinct user
2. Output all names (excluding yourself)
3. Sort them by:
   - **Descending priority factor**
   - **Lexicographical order** if tied

Even users with **0 priority factor** must be printed.

---

## 🧠 Key Observations

- Each action line always contains **two names**
- Names may appear in any role (actor or receiver)
- Only interactions **involving you** affect priority
- Apostrophe `'s` must be removed when extracting names
- Sorting requires **custom comparator logic**

---

## 🧠 Approach

1. Read your name and number of actions
2. Use a `HashMap<String, Integer>` to track priority scores
3. For each action:
   - Parse the two names
   - Determine points based on action type
   - Update priority **only if one name is you**
4. Collect all distinct names except yourself
5. Sort using:
   - Higher priority first
   - Alphabetical order if tied
6. Print the result

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|------|-----------|
| **Time Complexity** | `O(n log n)` |
| **Space Complexity** | `O(n)` |

Where `n` is the number of distinct users (≤ 100).

---

## 💻 Java Implementation

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNext()) return;
        
        String myName = sc.next();
        int n = sc.nextInt();
        sc.nextLine(); 
        
        Map<String, Integer> scores = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            
            String name1 = parts[0];
            String name2Raw = "";
            int points = 0;
            
            if (parts[1].equals("posted")) {
                name2Raw = parts[3];
                points = 15;
            } else if (parts[1].equals("commented")) {
                name2Raw = parts[3];
                points = 10;
            } else if (parts[1].equals("likes")) {
                name2Raw = parts[2];
                points = 5;
            }
            
            String name2 = name2Raw.substring(0, name2Raw.length() - 2);
            
            scores.putIfAbsent(name1, 0);
            scores.putIfAbsent(name2, 0);
            
            if (name1.equals(myName)) {
                scores.put(name2, scores.get(name2) + points);
            }
            
            if (name2.equals(myName)) {
                scores.put(name1, scores.get(name1) + points);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (String name : scores.keySet()) {
            if (!name.equals(myName)) {
                result.add(name);
            }
        }
        
        Collections.sort(result, (a, b) -> {
            int diff = scores.get(b) - scores.get(a);
            if (diff != 0) return diff;
            return a.compareTo(b);
        });
        
        for (String name : result) {
            System.out.println(name);
        }
    }
}
