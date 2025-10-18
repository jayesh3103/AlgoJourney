import java.util.Scanner;

public class Main {

    private static long countBlack(long h, long w, long r, long c) {
        if (h <= 0 || w <= 0) {
            return 0;
        }
        long total = h * w;
        if ((r + c) % 2 == 0) {
            return (total + 1) / 2;
        } else {
            return total / 2;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        long x = in.nextLong();

        long h1 = n - 2 * (x - 1);
        long w1 = m - 2 * (x - 1);
        long count1 = countBlack(h1, w1, x - 1, x - 1);

        long h2 = n - 2 * x;
        long w2 = m - 2 * x;
        long count2 = countBlack(h2, w2, x, x);

        System.out.println(count1 - count2);
        in.close();
    }
}
