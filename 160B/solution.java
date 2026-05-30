import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        String ticket = scanner.next();
        scanner.close();

        char[] firstHalf = ticket.substring(0, n).toCharArray();
        char[] secondHalf = ticket.substring(n).toCharArray();

        Arrays.sort(firstHalf);
        Arrays.sort(secondHalf);

        boolean strictlyLess = true;
        boolean strictlyGreater = true;

        for (int i = 0; i < n; i++) {
            if (firstHalf[i] >= secondHalf[i]) {
                strictlyLess = false;
            }
            if (firstHalf[i] <= secondHalf[i]) {
                strictlyGreater = false;
            }
        }

        if (strictlyLess || strictlyGreater) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
