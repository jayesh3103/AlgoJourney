import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Lemming implements Comparable<Lemming> {
        int id;
        long m, v;

        public Lemming(int id, long m, long v) {
            this.id = id;
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Lemming other) {
            if (this.m != other.m) {
                return Long.compare(this.m, other.m);
            }
            return Long.compare(this.v, other.v);
        }
    }

    static int n, k;
    static long h;
    static Lemming[] lemmings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        h = Long.parseLong(st.nextToken());

        lemmings = new Lemming[n];
        long[] m = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            m[i] = Long.parseLong(st.nextToken());
        }

        long[] v = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            lemmings[i] = new Lemming(i + 1, m[i], v[i]);
        }

        Arrays.sort(lemmings);

        double low = 0.0;
        double high = 1e11; 
        int[] bestAns = new int[k];

        for (int iter = 0; iter < 100; iter++) {
            double mid = low + (high - low) / 2.0;
            int[] ans = check(mid);
            if (ans != null) {
                high = mid;
                bestAns = ans;
            } else {
                low = mid;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(bestAns[i]).append(i == k - 1 ? "" : " ");
        }
        System.out.println(sb.toString());
    }

    static int[] check(double t) {
        int[] ans = new int[k];
        int j = 1;
        for (int i = 0; i < n; i++) {
            if (j > k) break;
            if ((double) j * h <= t * lemmings[i].v) {
                ans[j - 1] = lemmings[i].id;
                j++;
            }
        }
        if (j > k) {
            return ans;
        }
        return null;
    }
}
