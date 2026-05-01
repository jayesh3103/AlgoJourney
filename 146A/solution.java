import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        
        int n = scanner.nextInt();
        String ticket = scanner.next();
        scanner.close();

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < n; i++) {
            char c = ticket.charAt(i);
            
            if (c != '4' && c != '7') {
                System.out.println("NO");
                return;
            }
            
            if (i < n / 2) {
                sum1 += c - '0';
            } else {
                sum2 += c - '0';
            }
        }

        if (sum1 == sum2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
