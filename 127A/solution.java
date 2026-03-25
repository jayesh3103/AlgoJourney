import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int prevX = sc.nextInt();
        int prevY = sc.nextInt();
        
        double totalDistance = 0.0;
        
        for (int i = 1; i < n; i++) {
            int currX = sc.nextInt();
            int currY = sc.nextInt();
            
            double dx = currX - prevX;
            double dy = currY - prevY;
            
            totalDistance += Math.sqrt(dx * dx + dy * dy);
            
            prevX = currX;
            prevY = currY;
        }
        
        double totalTime = (totalDistance * k) / 50.0;
        
        System.out.printf(Locale.US, "%.9f\n", totalTime);
        
        sc.close();
    }
}
