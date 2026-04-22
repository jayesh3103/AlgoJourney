import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextLong()) return;
        
        long n = sc.nextLong();
        
        long minTotal = Long.MAX_VALUE;
        long maxTotal = -1;
        
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                long rem = n / i;
                for (long j = 1; j * j <= rem; j++) {
                    if (rem % j == 0) {
                        long k = rem / j;
                        
                        long t1 = (i + 1) * (j + 2) * (k + 2);
                        if (t1 < minTotal) minTotal = t1;
                        if (t1 > maxTotal) maxTotal = t1;
                        
                        long t2 = (j + 1) * (i + 2) * (k + 2);
                        if (t2 < minTotal) minTotal = t2;
                        if (t2 > maxTotal) maxTotal = t2;
                        
                        long t3 = (k + 1) * (i + 2) * (j + 2);
                        if (t3 < minTotal) minTotal = t3;
                        if (t3 > maxTotal) maxTotal = t3;
                    }
                }
            }
        }
        
        System.out.println((minTotal - n) + " " + (maxTotal - n));
        
        sc.close();
    }
}
