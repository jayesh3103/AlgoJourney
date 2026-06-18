import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        String a = sc.next();
        String b = sc.next();

        int m = a.length();
        int k = b.length();
        
        int gcd = gcd(m, k);
        int lcm = (m * k) / gcd;

        long periods = (long) n / lcm;
        int rem = n % lcm;

        long lossA_period = 0;
        long lossB_period = 0;
        long lossA_rem = 0;
        long lossB_rem = 0;

        for (int i = 0; i < lcm; i++) {
            char ca = a.charAt(i % m);
            char cb = b.charAt(i % k);
            
            if (ca != cb) {
                if ((ca == 'R' && cb == 'S') || (ca == 'S' && cb == 'P') || (ca == 'P' && cb == 'R')) {
                    lossB_period++;
                    if (i < rem) {
                        lossB_rem++;
                    }
                } else {
                    lossA_period++;
                    if (i < rem) {
                        lossA_rem++;
                    }
                }
            }
        }

        long totalA = periods * lossA_period + lossA_rem;
        long totalB = periods * lossB_period + lossB_rem;

        System.out.println(totalA + " " + totalB);
        sc.close();
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
