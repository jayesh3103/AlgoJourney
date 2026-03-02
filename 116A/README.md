# 📘 A. Tram – Codeforces

## 📝 Problem Summary

There is a tram with `n` stops.

At each stop:
- `ai` passengers **exit**
- `bi` passengers **enter**

Important rules:

- The tram starts **empty**
- At each stop, passengers exit **before** new passengers enter
- At the last stop:
  - Everyone exits
  - No one enters

---

## 🎯 Task

Find the **minimum capacity** of the tram such that  
the number of passengers inside the tram **never exceeds** this capacity.

---

## 💡 Key Insight

We simply simulate the process:

At each stop:

1. Subtract exiting passengers  
2. Add entering passengers  
3. Track the maximum number of passengers at any time  

The highest number of passengers at any moment  
is the **minimum required capacity**.

---

## 🚀 Approach

1. Read `n`
2. Initialize:
   - `currentPassengers = 0`
   - `maxCapacity = 0`
3. For each stop:
   - `currentPassengers -= exit`
   - `currentPassengers += enter`
   - Update `maxCapacity`
4. Print `maxCapacity`


---

## 💻 Java Implementation

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int currentPassengers = 0;
        int maxCapacity = 0;

        for (int i = 0; i < n; i++) {
            int exit = sc.nextInt();
            int enter = sc.nextInt();

            currentPassengers -= exit;   // passengers exit first
            currentPassengers += enter;  // then passengers enter

            if (currentPassengers > maxCapacity) {
                maxCapacity = currentPassengers;
            }
        }

        System.out.println(maxCapacity);

        sc.close();
    }
}
