# 🔄 A. Transmigration — Codeforces

## 🧙 Problem Story

In Disgaea-style RPGs, characters possess **skills** with numeric levels.  
When a character undergoes **transmigration** (reincarnation into another class):

1. **All existing skills are retained**, but their levels are **reduced**
2. Reduction rule:  
   **new_level = ⌊old_level × k⌋**
3. If after reduction a skill’s level is **strictly less than 100**, the skill is **forgotten**
4. The new class grants **class-specific skills**:
   - If the character **does not already have** such a skill, it is added
   - New skills start at **level 0**

Your task is to determine **which skills remain** and **their final levels** after transmigration.

---

## 🧠 Key Rules Recap

### 🔽 Skill Reduction
- New level = `floor(old × k)`
- If new level `< 100` → skill is **removed**

### ➕ Class Skills
- Added **only if not already present**
- Initial level = **0**

### 📚 Ordering Requirement
- Final output must be **lexicographically sorted by skill name**

---

## 🧩 Strategy

1. Read and reduce all existing skills using coefficient `k`
2. Keep only skills whose reduced level is **≥ 100**
3. Add class-specific skills if they are missing (with level `0`)
4. Store skills in a sorted data structure to ensure correct order

---

## ⏱️ Constraints

| Parameter | Limit |
|---------|------|
| Number of skills (`n`, `m`) | ≤ 20 |
| Skill level | ≤ 9999 |
| Skill name length | 1–20 characters |
| Reduction coefficient `k` | 0.01 ≤ k ≤ 0.99 |

---

## ⚙️ Time & Space Complexity

| Metric | Complexity |
|------|-----------|
| Time Complexity | **O((n + m) log(n + m))** |
| Space Complexity | **O(n + m)** |

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

        // TreeMap keeps skill names sorted lexicographically
        Map<String, Integer> skills = new TreeMap<>();

        // Process existing skills
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int exp = sc.nextInt();

            int reducedExp = (int) (exp * k + 1e-7); // safe floor operation
            if (reducedExp >= 100) {
                skills.put(name, reducedExp);
            }
        }

        // Add class-specific skills if missing
        for (int i = 0; i < m; i++) {
            String name = sc.next();
            skills.putIfAbsent(name, 0);
        }

        // Output result
        System.out.println(skills.size());
        for (Map.Entry<String, Integer> entry : skills.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
