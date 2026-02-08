# 🔄 A. Transmigration — Codeforces

## 🧙 Problem Story

In Disgaea-style RPGs, characters possess **skills** with numeric levels.  
When a character undergoes **transmigration** (reincarnation into another class):

1. **All existing skills are kept**, but their levels are **reduced**
2. Reduction rule:  

new_level = floor(old_level × k)3. If after reduction a skill’s level is **< 100**, the skill is **forgotten**
4. The new class grants **class-specific skills**:
- If the character **does not already have** such a skill, it is added
- New skills start at **level 0**

Your task is to determine **which skills remain** and **their final levels**.

---

## 🧠 Key Rules Recap

### 🔽 Skill Reduction
- New level = `⌊old × k⌋`
- If new level `< 100` → skill is **removed**

### ➕ Class Skills
- Added **only if not already present**
- Level set to **0**

### 📚 Ordering
- Output must be **lexicographically sorted**

---

## 🧩 Strategy

1. Read and reduce all existing skills
2. Keep only those with reduced level ≥ 100
3. Insert class-specific skills if missing (level 0)
4. Use a sorted structure to maintain order

---

## ⏱️ Constraints

| Parameter | Limit |
|---------|------|
| Skills (`n`, `m`) | ≤ 20 |
| Skill level | ≤ 9999 |
| Names | lowercase, ≤ 20 chars |

---

## ⚙️ Time & Space Complexity

| Metric | Complexity |
|------|-----------|
| Time | **O((n + m) log(n + m))** |
| Space | **O(n + m)** |

---

## 💻 Java Implementation

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        if (!sc.hasNext()) return;

        int n = sc.nextInt();
        int m = sc.nextInt();
        double k = sc.nextDouble();

        // TreeMap keeps keys sorted lexicographically
        Map<String, Integer> skills = new TreeMap<>();

        // Process existing skills
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int exp = sc.nextInt();
            int newExp = (int)(exp * k + 1e-7); // safe floor

            if (newExp >= 100) {
                skills.put(name, newExp);
            }
        }

        // Add class-specific skills if missing
        for (int i = 0; i < m; i++) {
            String name = sc.next();
            skills.putIfAbsent(name, 0);
        }

        // Output
        System.out.println(skills.size());
        for (Map.Entry<String, Integer> entry : skills.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

