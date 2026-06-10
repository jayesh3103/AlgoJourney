import java.io.*;
import java.util.*;

public class Main {
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
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String nStr = sc.next();
        if (nStr == null) return;
        
        int n = Integer.parseInt(nStr);
        double a = sc.nextDouble();
        double d = sc.nextDouble();

        double prevArrival = 0.0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            double t = sc.nextDouble();
            double v = sc.nextDouble();

            double s_accel = (v * v) / (2.0 * a);
            double arrivalTime;

            if (s_accel >= d) {
                double timeTravel = Math.sqrt(2.0 * d / a);
                arrivalTime = t + timeTravel;
            } else {
                double timeTravel = (v / a) + (d - s_accel) / v;
                arrivalTime = t + timeTravel;
            }

            double actualArrival = Math.max(arrivalTime, prevArrival);
            prevArrival = actualArrival;

            sb.append(actualArrival).append("\n");
        }

        System.out.print(sb.toString());
    }
}
