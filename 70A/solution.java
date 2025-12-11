import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            long mod = 1000003;

            if (n == 0) {
                System.out.println(1);
            } else {
                long ans = 1;
                for (int i = 0; i < n - 1; i++) {
                    ans = (ans * 3) % mod;
                }
                System.out.println(ans);
            }
        }
    }
}
