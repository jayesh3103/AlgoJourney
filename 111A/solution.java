import java.util.Scanner;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = sc.nextLong();
        long x = sc.nextLong();
        long y = sc.nextLong();

        if (y < n) {
            System.out.println("-1");
            return;
        }

        long lastNumber = y - (n - 1);
        long sumOfSquares = (n - 1) + (lastNumber * lastNumber);

        if (sumOfSquares >= x) {
            for (int i = 0; i < n - 1; i++) {
                out.println(1);
            }
            out.println(lastNumber);
        } else {
            out.println("-1");
        }
        
        out.flush();
        out.close();
    }
}
