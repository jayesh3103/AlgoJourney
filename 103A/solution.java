import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            long totalClicks = 0;
            
            for (int i = 1; i <= n; i++) {
                long a = sc.nextLong();
                totalClicks += (a - 1) * i + 1;
            }
            
            System.out.println(totalClicks);
        }
    }
}
