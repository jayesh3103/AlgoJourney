import java.util.Scanner;

public class Main {
    static class Point {
        long x, y;
        int id;
        
        Point(long x, long y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

    static Point[] pts = new Point[8];
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextLong()) return;
        
        for (int i = 0; i < 8; i++) {
            pts[i] = new Point(sc.nextLong(), sc.nextLong(), i + 1);
        }
        
        permute(0);
        
        if (!found) {
            System.out.println("NO");
        }
        
        sc.close();
    }

    static void permute(int i) {
        if (found) return;
        
        if (i == 8) {
            if (isSquare(pts[0], pts[1], pts[2], pts[3]) && 
                isRectangle(pts[4], pts[5], pts[6], pts[7])) {
                found = true;
                System.out.println("YES");
                System.out.println(pts[0].id + " " + pts[1].id + " " + pts[2].id + " " + pts[3].id);
                System.out.println(pts[4].id + " " + pts[5].id + " " + pts[6].id + " " + pts[7].id);
            }
            return;
        }
        
        for (int j = i; j < 8; j++) {
            swap(i, j);
            permute(i + 1);
            swap(i, j);
        }
    }

    static void swap(int i, int j) {
        Point temp = pts[i];
        pts[i] = pts[j];
        pts[j] = temp;
    }

    static long distSq(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    static boolean isSquare(Point a, Point b, Point c, Point d) {
        long ab = distSq(a, b);
        long bc = distSq(b, c);
        long cd = distSq(c, d);
        long da = distSq(d, a);
        long ac = distSq(a, c);
        long bd = distSq(b, d);
        
        return ab > 0 && ab == bc && bc == cd && cd == da && ac == bd && ac == ab + bc;
    }

    static boolean isRectangle(Point a, Point b, Point c, Point d) {
        long ab = distSq(a, b);
        long bc = distSq(b, c);
        long cd = distSq(c, d);
        long da = distSq(d, a);
        long ac = distSq(a, c);
        long bd = distSq(b, d);
        
        return ab > 0 && bc > 0 && ab == cd && bc == da && ac == bd && ac == ab + bc;
    }
}
