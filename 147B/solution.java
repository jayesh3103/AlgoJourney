import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][][] M = new int[10][n][n];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(M[i][j], -INF);
                if (i == 0) {
                    M[0][j][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            M[0][u][v] = c1;
            M[0][v][u] = c2;
        }

        for (int step = 1; step <= 9; step++) {
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (M[step - 1][i][k] == -INF) continue;
                    for (int j = 0; j < n; j++) {
                        if (M[step - 1][k][j] != -INF) {
                            M[step][i][j] = Math.max(M[step][i][j], M[step - 1][i][k] + M[step - 1][k][j]);
                        }
                    }
                }
            }
        }

        int[][] curr = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(curr[i], -INF);
            curr[i][i] = 0;
        }

        int ans = 0;
        for (int step = 9; step >= 0; step--) {
            int[][] temp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(temp[i], -INF);
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (curr[i][k] == -INF) continue;
                    for (int j = 0; j < n; j++) {
                        if (M[step][k][j] != -INF) {
                            temp[i][j] = Math.max(temp[i][j], curr[i][k] + M[step][k][j]);
                        }
                    }
                }
            }

            boolean hasPositiveCycle = false;
            for (int i = 0; i < n; i++) {
                if (temp[i][i] > 0) {
                    hasPositiveCycle = true;
                    break;
                }
            }

            if (!hasPositiveCycle) {
                curr = temp;
                ans += (1 << step);
            }
        }

        if (ans + 1 > n) {
            System.out.println(0);
        } else {
            System.out.println(ans + 1);
        }
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int head = 0;
        private int tail = 0;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (head >= tail) {
                head = 0;
                try {
                    tail = stream.read(buf, 0, buf.length);
                } catch (IOException e) {
                    return -1;
                }
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }

        public int nextInt() {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return negative ? -res : res;
        }
    }
}
