import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String s = sc.next();
        if (s == null) return;
        
        int n = Integer.parseInt(s);
        int k = sc.nextInt();
        
        double[] a = new double[n];
        double maxVal = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] > maxVal) maxVal = a[i];
        }
        
        double factor = 1.0 - k / 100.0;
        double l = 0.0;
        double r = maxVal;
        
        for (int i = 0; i < 100; i++) {
            double mid = (l + r) / 2;
            double surplus = 0;
            double deficit = 0;
            
            for (double val : a) {
                if (val > mid) {
                    surplus += (val - mid);
                } else {
                    deficit += (mid - val);
                }
            }
            
            if (surplus * factor >= deficit) {
                l = mid;
            } else {
                r = mid;
            }
        }
        
        System.out.printf("%.9f%n", l);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
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
