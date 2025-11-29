import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        
        int n = fs.nextInt();
        int k = fs.nextInt();
        int[] cnt = new int[k + 1];
        
        for (int i = 0; i < n; i++) {
            cnt[fs.nextInt()]++;
        }
        
        int ans = 0;
        while (cnt[k] != n) {
            ans++;
            for (int i = k - 1; i >= 1; i--) {
                if (cnt[i] > 0) {
                    cnt[i]--;
                    cnt[i + 1]++;
                }
            }
        }
        
        out.println(ans);
        out.flush();
    }
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        
        String next() {
            while (!st.hasMoreTokens()) {
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
