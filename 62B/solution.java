import java.io.*;
import java.util.*;

public class TyndexBrome {
    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();

        List<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        while (n-- > 0) {
            String c = in.next();
            long ans = 0;
            int len = c.length();

            for (int i = 0; i < len; i++) {
                int u = c.charAt(i) - 'a';
                List<Integer> list = pos[u];

                if (list.isEmpty()) {
                    ans += len;
                } else {
                    int idx = Collections.binarySearch(list, i);
                    if (idx >= 0) continue;
                    
                    idx = -idx - 1;
                    int cur = Integer.MAX_VALUE;

                    if (idx < list.size()) cur = Math.min(cur, Math.abs(i - list.get(idx)));
                    if (idx > 0) cur = Math.min(cur, Math.abs(i - list.get(idx - 1)));
                    
                    ans += cur;
                }
            }
            out.println(ans);
        }
        out.flush();
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
