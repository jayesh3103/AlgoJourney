# 📘 B. Before Exam – Codeforces

## 📝 Problem Overview

Vasya is preparing for his **Mathematical Analysis exam**.

- There are **n theorems** in total.
- The exam contains **k cards**.
- Each card contains **exactly `c = n / k` distinct theorems**.
- Each theorem appears in **exactly one card**.

Vasya knows his **proficiency level** for each theorem:

```
a[i] = proficiency in theorem i
```

The **proficiency of a card** is defined as:

```
average = (sum of proficiencies of theorems in the card) / c
```

---

# 📥 Given Information

Some students who took the exam earlier told Vasya which theorems were on their cards.

However:

- Some cards may still be **unknown**.
- Students may receive the **same card multiple times**.
- Known cards may appear in **different orders**.

Vasya wants to know:

```
Minimum possible proficiency
Maximum possible proficiency
```

for the card he might receive.

---

# 🎯 Key Idea

Each card contains:

```
c = n / k
```

theorems.

Two types of cards exist:

### 1️⃣ Known cards
Cards already reported by students.

We compute their **sum of proficiencies**.

Track:

```
minKnownSum
maxKnownSum
```

---

### 2️⃣ Unknown cards

These must be formed using **unused theorems**.

Steps:

1. Collect theorems **not appearing in known cards**.
2. Sort their proficiency values.

To find extremes:

```
Minimum card sum → smallest c values
Maximum card sum → largest c values
```

---

# 📊 Final Result

Compare both possibilities:

```
globalMin = min(minKnownSum, minUnknownSum)
globalMax = max(maxKnownSum, maxUnknownSum)
```

Convert sums into averages:

```
answer = sum / c
```

---

# ⏱ Complexity

Sorting unused theorems:

```
O(n log n)
```

Other operations:

```
O(n)
```

Since:

```
n ≤ 100
```

This is very efficient.

---

# 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int c = n / k;

        int[] a = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        Set<String> knownCards = new HashSet<>();
        boolean[] used = new boolean[n + 1];

        double minKnownSum = Double.POSITIVE_INFINITY;
        double maxKnownSum = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());

            int[] card = new int[c];
            double sum = 0;

            for (int j = 0; j < c; j++) {
                card[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(card);

            StringBuilder key = new StringBuilder();

            for (int j = 0; j < c; j++) {
                key.append(card[j]).append(",");
                used[card[j]] = true;
                sum += a[card[j]];
            }

            String cardStr = key.toString();

            if (!knownCards.contains(cardStr)) {
                knownCards.add(cardStr);

                minKnownSum = Math.min(minKnownSum, sum);
                maxKnownSum = Math.max(maxKnownSum, sum);
            }
        }

        double globalMin = minKnownSum;
        double globalMax = maxKnownSum;

        if (knownCards.size() < k) {

            List<Integer> unused = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if (!used[i]) {
                    unused.add(a[i]);
                }
            }

            Collections.sort(unused);

            double minUnknown = 0;
            double maxUnknown = 0;

            for (int i = 0; i < c; i++) {
                minUnknown += unused.get(i);
                maxUnknown += unused.get(unused.size() - 1 - i);
            }

            globalMin = Math.min(globalMin, minUnknown);
            globalMax = Math.max(globalMax, maxUnknown);
        }

        System.out.printf(Locale.US, "%.10f %.10f\n", globalMin / c, globalMax / c);
    }
}
```
