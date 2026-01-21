import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            
            int fullRoundCost = n * (n + 1) / 2;
            
            m %= fullRoundCost;
            
            for (int i = 1; i <= n; i++) {
                if (m >= i) {
                    m -= i;
                } else {
                    break;
                }
            }
            
            System.out.println(m);
        }
        scanner.close();
    }
}
