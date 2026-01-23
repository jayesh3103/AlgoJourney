import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLong()) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            long r1 = (a - 1) / m + 1;
            long c1 = (a - 1) % m + 1;
            
            long r2 = (b - 1) / m + 1;
            long c2 = (b - 1) % m + 1;

            if (r1 == r2) {
                System.out.println(1);
            } else {
                boolean startsAtFirst = (c1 == 1);
                boolean endsAtLast = (c2 == m);
                
                if (startsAtFirst && endsAtLast) {
                    System.out.println(1);
                } else {
                    if (r2 == r1 + 1 || startsAtFirst || endsAtLast || c1 == c2 + 1) {
                        System.out.println(2);
                    } else {
                        System.out.println(3);
                    }
                }
            }
        }
        scanner.close();
    }
}
