import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        long x = sc.nextLong();
        long y = sc.nextLong();
        long z = sc.nextLong();
        long k = sc.nextLong();

        long[] dims = {x, y, z};
        Arrays.sort(dims);

        long sum = k + 3;

        long a = sum / 3;
        long b = (sum - a) / 2;
        long c = sum - a - b;

        if (a > dims[0]) {
            a = dims[0];
            long rem = sum - a;
            b = rem / 2;
            c = rem - b;
        }

        if (b > dims[1]) {
            b = dims[1];
            c = sum - a - b;
        }

        if (c > dims[2]) {
            c = dims[2];
        }

        System.out.println(a * b * c);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
