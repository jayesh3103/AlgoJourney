import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static class FastScanner {
        private InputStream in;
        private byte[] buffer = new byte[1 << 16];
        private int head = 0, tail = 0;

        public FastScanner(InputStream in) {
            this.in = in;
        }

        public int nextInt() {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }

        private int read() {
            if (head >= tail) {
                head = 0;
                try {
                    tail = in.read(buffer, 0, buffer.length);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int la = sc.nextInt();
        if (la == -1) return;
        int lb = sc.nextInt();

        int[] a = new int[la];
        for (int i = 0; i < la; i++) {
            a[i] = sc.nextInt();
        }

        int[] posB = new int[1000005];
        Arrays.fill(posB, -1);
        for (int i = 0; i < lb; i++) {
            int b = sc.nextInt();
            posB[b] = i;
        }

        int[] p = new int[2 * la];
        for (int i = 0; i < la; i++) {
            int val = a[i];
            p[i] = posB[val];
            p[i + la] = posB[val];
        }

        int maxLen = 0;
        int n = 2 * la;
        int l = 0;

        while (l < n) {
            if (p[l] == -1) {
                l++;
                continue;
            }
            int r = l;
            long currentSum = 0;
            int currentL = l;
            
            while (r < n && p[r] != -1) {
                if (r > currentL) {
                    currentSum += (p[r] - p[r - 1] + lb) % lb;
                }
                while (currentL < r && (currentSum >= lb || (r - currentL + 1) > la)) {
                    currentSum -= (p[currentL + 1] - p[currentL] + lb) % lb;
                    currentL++;
                }
                maxLen = Math.max(maxLen, r - currentL + 1);
                r++;
            }
            l = r;
        }

        System.out.println(maxLen);
    }
}
