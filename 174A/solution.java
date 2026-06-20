import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        double b = sc.nextDouble();
        
        double[] a = new double[n];
        double sum = 0;
        double maxA = -1;
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
            sum += a[i];
            if (a[i] > maxA) {
                maxA = a[i];
            }
        }
        
        double targetVolume = (sum + b) / n;
        
        if (targetVolume < maxA) {
            System.out.println("-1");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.printf("%.6f\n", targetVolume - a[i]);
            }
        }
        
        sc.close();
    }
}
