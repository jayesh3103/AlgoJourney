import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        
        int n = scanner.nextInt();
        int[] radii = new int[n];
        for (int i = 0; i < n; i++) {
            radii[i] = scanner.nextInt();
        }
        scanner.close();
        
        Arrays.sort(radii);
        
        double area = 0.0;
        int sign = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            area += sign * Math.PI * radii[i] * radii[i];
            sign *= -1;
        }
        
        System.out.printf("%.10f\n", area);
    }
}
