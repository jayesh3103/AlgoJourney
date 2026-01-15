import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int[] s = new int[n];
        s[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            s[i] = Math.min(a[i], s[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                out.print("-1 ");
                continue;
            }

            int low = i + 1;
            int high = n - 1;
            int bestJ = -1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (s[mid] < a[i]) {
                    bestJ = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (bestJ != -1) {
                out.print((bestJ - i - 1) + " ");
            } else {
                out.print("-1 ");
            }
        }
        
        out.println();
        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String s = br.readLine();
                    if (s == null) return null;
                    st = new StringTokenizer(s);
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
