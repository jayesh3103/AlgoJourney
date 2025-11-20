import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String s = sc.next();
        
        int upperCount = 0;
        int lowerCount = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            } else {
                lowerCount++;
            }
        }
        
        if (upperCount > lowerCount) {
            out.println(s.toUpperCase());
        } else {
            out.println(s.toLowerCase());
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
