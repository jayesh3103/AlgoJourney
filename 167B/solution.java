import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    static class Tour implements Comparable<Tour> {
        double p;
        int a;

        public Tour(double p, int a) {
            this.p = p;
            this.a = a;
        }

        @Override
        public int compareTo(Tour other) {
            return Integer.compare(other.a, this.a);
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String nStr = sc.next();
        if (nStr == null) return;

        int n = Integer.parseInt(nStr);
        int l = sc.nextInt();
        int k = sc.nextInt();

        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextDouble() / 100.0;
        }

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Tour[] tours = new Tour[n];
        for (int i = 0; i < n; i++) {
            tours[i] = new Tour(p[i], a[i]);
        }

        Arrays.sort(tours);

        double[][][] dp = new double[n + 1][n + 1][n + 1];
        dp[0][0][Math.min(k, n)] = 1.0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                for (int c = 0; c <= n; c++) {
                    if (dp[i][j][c] > 0) {
                        dp[i + 1][j][c] += dp[i][j][c] * (1.0 - tours[i].p);

                        int next_c = c + tours[i].a;
                        if (next_c >= 0) {
                            next_c = Math.min(next_c, n);
                            dp[i + 1][j + 1][next_c] += dp[i][j][c] * tours[i].p;
                        }
                    }
                }
            }
        }

        double ans = 0;
        for (int j = l; j <= n; j++) {
            for (int c = 0; c <= n; c++) {
                ans += dp[n][j][c];
            }
        }

        System.out.printf(Locale.US, "%.12f\n", ans);
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
}
