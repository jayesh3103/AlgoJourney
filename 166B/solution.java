import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static class Point {
        long x, y;
        
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static long cross(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        
        int n = sc.nextInt();
        if (n == -1) return;
        
        Point[] a = new Point[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Point(sc.nextLong(), sc.nextLong());
        }
        
        int m = sc.nextInt();
        Point[] b = new Point[m];
        for (int i = 0; i < m; i++) {
            b[i] = new Point(sc.nextLong(), sc.nextLong());
        }
        
        for (int i = 0; i < m; i++) {
            Point p = b[i];
            
            if (cross(a[0], a[1], p) >= 0 || cross(a[0], a[n - 1], p) <= 0) {
                System.out.println("NO");
                return;
            }
            
            int l = 1;
            int r = n - 1;
            
            while (r - l > 1) {
                int mid = l + (r - l) / 2;
                if (cross(a[0], a[mid], p) > 0) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
            
            if (cross(a[l], a[r], p) >= 0) {
                System.out.println("NO");
                return;
            }
        }
        
        System.out.println("YES");
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
            String s = next();
            if (s == null) return -1;
            return Integer.parseInt(s);
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
