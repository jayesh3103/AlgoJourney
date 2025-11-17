import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    static class Road {
        int a, b, c;

        public Road(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        Road[] roads = new Road[m];
        for (int i = 0; i < m; i++) {
            roads[i] = new Road(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        long totalStonesSum = 0;

        for (int i = 0; i < k; i++) {
            int queryCell = sc.nextInt();
            long stonesInThisCell = 0;

            for (int j = 0; j < m; j++) {
                Road road = roads[j];
                if (queryCell >= road.a && queryCell <= road.b) {
                    stonesInThisCell += (road.c + queryCell - road.a);
                }
            }
            
            totalStonesSum += stonesInThisCell;
        }

        out.println(totalStonesSum);
        out.flush();
        out.close();
    }

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
