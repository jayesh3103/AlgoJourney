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
            long arrival = c[i];
            long start;
            if (i < k1) {
                start = arrival;
            } else {
                start = Math.max(arrival, finish1[i - k1]);
            }
            finish1[i] = start + t1;
        }
        
        long[] finish2 = new long[n];
        for (int i = 0; i < n; i++) {
            long arrival = finish1[i];
            long start;
            if (i < k2) {
                start = arrival;
            } else {
                start = Math.max(arrival, finish2[i - k2]);
            }
            finish2[i] = start + t2;
        }
        
        long[] finish3 = new long[n];
        for (int i = 0; i < n; i++) {
            long arrival = finish2[i];
            long start;
            if (i < k3) {
                start = arrival;
            } else {
                start = Math.max(arrival, finish3[i - k3]);
            }
            finish3[i] = start + t3;
        }
        
        long maxTime = 0;
        for (int i = 0; i < n; i++) {
            long totalTime = finish3[i] - c[i];
            if (totalTime > maxTime) {
                maxTime = totalTime;
            }
        }
        
        System.out.println(maxTime);
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
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
