import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        if (n > m) {
            int temp = n;
            n = m;
            m = temp;
        }
        
        if (n == 1) {
            System.out.println(m);
        } else if (n == 2) {
            int blocks = m / 4;
            int rem = m % 4;
            int ans = blocks * 4 + Math.min(rem, 2) * 2;
            System.out.println(ans);
        } else {
            System.out.println((n * m + 1) / 2);
        }
        
        sc.close();
    }
}
