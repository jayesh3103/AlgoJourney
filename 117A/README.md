# 📘 A. Elevator – Codeforces

## 📝 Problem Summary

There is an elevator in an `m`-floor hotel.

It moves in a fixed infinite pattern:

1 → 2 → 3 → ... → m  
m → m-1 → m-2 → ... → 1  
(repeats forever)

- Moving between adjacent floors takes **1 unit of time**
- At time `0`, elevator is at floor `1`
- Elevator has infinite capacity
- People enter instantly when elevator reaches their floor

For each participant, you are given:

- `s` → starting floor  
- `f` → destination floor  
- `t` → starting time  

You must print the **earliest arrival time** at floor `f`.

---

## 💡 Key Observations

### 🔁 Elevator Cycle Length

The full movement cycle length is:

```
L = 2*m - 2
```

Because:
- Going up: `m - 1` moves
- Going down: `m - 1` moves

Total:
```
L = 2*(m - 1)
```

---

### 🧭 When Does Elevator Reach Floor `s`?

We compute the first time in the cycle when elevator is at floor `s`
**in the correct direction**:

- If `s < f` → must go UP  
- If `s > f` → must go DOWN  

Base time in cycle:

```
If going up:
    B = s - 1

If going down:
    B = 2*m - s - 1
```

---

### ⏳ Waiting Time

At time `t`, elevator is at position:

```
t % L
```

Waiting time:

```
wait = (B - (t % L) + L) % L
```

---

### 🕒 Final Arrival Time

```
arrival = t + wait + |s - f|
```

Special case:
If `s == f`, answer is simply `t`.

---

## ⏱ Complexity

For each participant:
```
O(1)
```

Total:
```
O(n)
```

Works for:
```
n ≤ 10^5
m ≤ 10^8
```

---

## 💻 Java Implementation

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long cycleLength = 2L * m - 2; // Full elevator cycle
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            long s = Long.parseLong(st.nextToken());
            long f = Long.parseLong(st.nextToken());
            long t = Long.parseLong(st.nextToken());

            // If already at destination
            if (s == f) {
                sb.append(t).append("\n");
                continue;
            }

            long baseTime;

            // Determine correct direction arrival time in cycle
            if (s < f) {
                // Elevator must be moving upward
                baseTime = s - 1;
            } else {
                // Elevator must be moving downward
                baseTime = 2L * m - s - 1;
            }

            long currentTimeInCycle = t % cycleLength;

            long waitTime = (baseTime - currentTimeInCycle + cycleLength) % cycleLength;

            long arrivalTime = t + waitTime + Math.abs(s - f);

            sb.append(arrivalTime).append("\n");
        }

        System.out.print(sb.toString());
    }
}
```

