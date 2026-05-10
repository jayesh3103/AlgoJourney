import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) return;
        long q = sc.nextLong();
        sc.close();

        if (q == 1) {
            System.out.println("1\n0");
            return;
        }

        int count = 0;
        long p1 = 0;
        long p2 = 0;
        long n = q;

        for (long i = 2; i * i <= n && count < 2; i++) {
            while (n % i == 0 && count < 2) {
                if (count == 0) {
                    p1 = i;
                } else {
                    p2 = i;
                }
                count++;
                n /= i;
            }
        }

        if (count == 0) {
            System.out.println("1\n0");
        } else if (count == 1) {
            if (n > 1) {
                System.out.println("2");
            } else {
                System.out.println("1\n0");
            }
        } else {
            if (n > 1 || p1 * p2 != q) {
                System.out.println("1\n" + (p1 * p2));
            } else {
                System.out.println("2");
            }
        }
    }
}
