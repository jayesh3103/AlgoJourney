import java.util.Scanner;

public class Main {
    static int n, k, A;
    static int[] b;
    static int[] l;
    static double maxP = -1.0;
    static double[] outcomes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        
        n = sc.nextInt();
        k = sc.nextInt();
        A = sc.nextInt();
        
        b = new int[n];
        l = new int[n];
        
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            l[i] = sc.nextInt();
        }
        
        int limit = 1 << n;
        outcomes = new double[limit];
        
        for (int mask = 0; mask < limit; mask++) {
            int yes = Integer.bitCount(mask);
            if (yes > n / 2) {
                outcomes[mask] = 1.0;
            } else {
                long sumB = 0;
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) == 0) {
                        sumB += b[i];
                    }
                }
                outcomes[mask] = (double) A / (A + sumB);
            }
        }
        
        solve(0, k);
        System.out.printf("%.10f\n", maxP);
    }

    static void solve(int idx, int rem) {
        if (idx == n) {
            double cur = 0.0;
            double[] p = new double[n];
            for (int i = 0; i < n; i++) p[i] = l[i] / 100.0;
            
            for (int mask = 0; mask < outcomes.length; mask++) {
                double prob = 1.0;
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        prob *= p[i];
                    } else {
                        prob *= (1.0 - p[i]);
                    }
                }
                cur += prob * outcomes[mask];
            }
            if (cur > maxP) maxP = cur;
            return;
        }

        int currentL = l[idx];
        int maxAdd = (100 - currentL) / 10;
        int bound = Math.min(rem, maxAdd);

        for (int i = 0; i <= bound; i++) {
            l[idx] = currentL + i * 10;
            solve(idx + 1, rem - i);
        }
        l[idx] = currentL;
    }
}
