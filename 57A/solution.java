import java.util.Scanner;

public class Main {
    
    private static int getPos(int n, int x, int y) {
        if (y == 0) return x;
        if (x == n) return n + y;
        if (y == n) return n + n + (n - x);
        if (x == 0) return n + n + n + (n - y);
        return 0;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            
            int pos1 = getPos(n, x1, y1);
            int pos2 = getPos(n, x2, y2);
            
            int dist = Math.abs(pos1 - pos2);
            
            System.out.println(Math.min(dist, 4 * n - dist));
        }
    }
}
