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
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        String nStr = fs.next();
        if (nStr == null) return;
        
        int n = Integer.parseInt(nStr);
        int m = fs.nextInt();

        int[] type = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            type[i] = fs.nextInt();
        }

        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        ArrayList<Integer>[] rev = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj[u].add(v);
            rev[v].add(u);
        }

        boolean[] reach1 = new boolean[n + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for (int i = 1; i <= n; i++) {
            if (type[i] == 1) {
                reach1[i] = true;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (!reach1[v]) {
                    reach1[v] = true;
                    if (type[v] != 1) {
                        q.add(v);
                    }
                }
            }
        }

        boolean[] reach2 = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (type[i] == 2) {
                reach2[i] = true;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : rev[u]) {
                if (!reach2[v]) {
                    reach2[v] = true;
                    if (type[v] != 1) {
                        q.add(v);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (reach1[i] && reach2[i]) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (i < n) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
