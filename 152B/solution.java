import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) return;
        
        long n = sc.nextLong();
        long m = sc.nextLong();
        long x = sc.nextLong();
        long y = sc.nextLong();
        int k = sc.nextInt();
        
        long totalSteps = 0;
        
        for (int i = 0; i < k; i++) {
            long dx = sc.nextLong();
            long dy = sc.nextLong();
            
            long stepsX = Long.MAX_VALUE;
            if (dx > 0) {
                stepsX = (n - x) / dx;
            } else if (dx < 0) {
                stepsX = (x - 1) / -dx;
            }
            
            long stepsY = Long.MAX_VALUE;
            if (dy > 0) {
                stepsY = (m - y) / dy;
            } else if (dy < 0) {
                stepsY = (y - 1) / -dy;
            }
            
            long steps = Math.min(stepsX, stepsY);
            
            totalSteps += steps;
            x += steps * dx;
            y += steps * dy;
        }
        
        System.out.println(totalSteps);
        sc.close();
    }
}
