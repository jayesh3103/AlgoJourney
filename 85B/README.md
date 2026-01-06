# 🏛️ B. Embassy Queue

## 📌 Problem Overview

An embassy uses an **electronic queue system** where every person must go through **three actions in order**:

1. Show ID  
2. Pay money  
3. Fingerprinting  

Each action has:
- A fixed **number of service windows**
- A fixed **service time per person**

People arrive at different times, and the system must be organized so that the **maximum total time spent by any person in the embassy is minimized**.

---

## ⚙️ Input Details

- `k1, k2, k3` — number of windows for actions 1, 2, and 3  
- `t1, t2, t3` — service time for each action  
- `n` — number of people  
- `ci` — arrival time of the `i-th` person (non-decreasing order)

---

## 🎯 Objective

Minimize the **maximum time** any person spends in the embassy, from arrival to completion of the third action.

---

## 🧠 Key Insight

- The optimal strategy is **FIFO (first-come-first-served)** for each action
- Each action behaves like a **parallel processing system** with `k` identical servers
- A person can start an action only after:
  - They finish the previous action
  - A window becomes free

This allows the problem to be solved using **simulation with finish-time arrays**.

---

## 🛠️ Algorithm

### Step-by-step Process:

1. **Cap window counts**  
   - No stage needs more windows than the number of people

2. **Simulate each stage independently**
   - Maintain an array of finish times
   - For each person:
     - Start time = `max(arrival time, finish time of window reused)`
     - Finish time = `start + service time`

3. **Repeat for all three stages**

4. **Compute total time**
   - For each person:  
     `finish_stage3[i] - arrival_time[i]`
   - Take the maximum

---

## 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        
        int k1 = fs.nextInt();
        int k2 = fs.nextInt();
        int k3 = fs.nextInt();
        
        long t1 = fs.nextInt();
        long t2 = fs.nextInt();
        long t3 = fs.nextInt();
        
        int n = fs.nextInt();
        
        long[] c = new long[n];
        for (int i = 0; i < n; i++) {
            c[i] = fs.nextInt();
        }
        
        if (k1 > n) k1 = n;
        if (k2 > n) k2 = n;
        if (k3 > n) k3 = n;
        
        long[] finish1 = new long[n];
        for (int i = 0; i < n; i++) {
            long start = (i < k1) ? c[i] : Math.max(c[i], finish1[i - k1]);
            finish1[i] = start + t1;
        }
        
        long[] finish2 = new long[n];
        for (int i = 0; i < n; i++) {
            long start = (i < k2) ? finish1[i] : Math.max(finish1[i], finish2[i - k2]);
            finish2[i] = start + t2;
        }
        
        long[] finish3 = new long[n];
        for (int i = 0; i < n; i++) {
            long start = (i < k3) ? finish2[i] : Math.max(finish2[i], finish3[i - k3]);
            finish3[i] = start + t3;
        }
        
        long maxTime = 0;
        for (int i = 0; i < n; i++) {
            maxTime = Math.max(maxTime, finish3[i] - c[i]);
        }
        
        System.out.println(maxTime);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
```
---
## ✅ Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`
