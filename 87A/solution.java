import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLong()) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            long g = gcd(a, b);
            
            long countDasha = b / g;
            long countMasha = a / g;

            if (countDasha > countMasha) {
                if (countDasha == countMasha + 1) {
                    System.out.println("Equal");
                } else {
                    System.out.println("Dasha");
                }
            } else {
                if (countMasha == countDasha + 1) {
                    System.out.println("Equal");
                } else {
                    System.out.println("Masha");
                }
            }
        }
        scanner.close();
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
