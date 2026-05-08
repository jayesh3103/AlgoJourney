import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int k = sc.nextInt();
        int[] a = new int[12];
        for (int i = 0; i < 12; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        if (k == 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(a);
        int sum = 0;
        int months = 0;

        for (int i = 11; i >= 0; i--) {
            sum += a[i];
            months++;
            if (sum >= k) {
                System.out.println(months);
                return;
            }
        }

        System.out.println(-1);
    }
}
