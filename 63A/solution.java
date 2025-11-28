import java.io.*;
import java.util.*;

public class SinkingShip {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        String[] names = new String[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = in.next();
            status[i] = in.next();
        }

        for (int i = 0; i < n; i++) {
            if (status[i].equals("rat")) out.println(names[i]);
        }

        for (int i = 0; i < n; i++) {
            if (status[i].equals("woman") || status[i].equals("child")) out.println(names[i]);
        }

        for (int i = 0; i < n; i++) {
            if (status[i].equals("man")) out.println(names[i]);
        }

        for (int i = 0; i < n; i++) {
            if (status[i].equals("captain")) out.println(names[i]);
        }

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
