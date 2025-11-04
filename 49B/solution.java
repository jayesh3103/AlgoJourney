import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String a = in.next();
            String b = in.next();

            int maxDigit = 0;
            for (char c : (a + b).toCharArray()) {
                maxDigit = Math.max(maxDigit, c - '0');
            }

            int base = maxDigit + 1;

            long valA = Long.parseLong(a, base);
            long valB = Long.parseLong(b, base);

            long sum = valA + valB;

            String result = Long.toString(sum, base);
            System.out.println(result.length());
        }
    }
}
