import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        out.print(n);

        while (n > 1) {
            int div = n;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    div = i;
                    break;
                }
            }
            n /= div;
            out.print(" " + n);
        }
        
        out.println();
        out.flush();
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
                    st = new StringTokenizer(br.readLine());
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
