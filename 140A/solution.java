import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int R = sc.nextInt();
        int r = sc.nextInt();
        
        if (r > R) {
            System.out.println("NO");
        } else if (n == 1) {
            System.out.println("YES");
        } else if (R < 2 * r) {
            System.out.println("NO");
        } else {
            double d = (R - r) * Math.sin(Math.PI / n);
            if (d >= r - 1e-8) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }
}
