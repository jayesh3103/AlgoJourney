import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        
        int total = (n * k * t) / 100;
        
        for (int i = 0; i < n; i++) {
            if (total >= k) {
                System.out.print(k + " ");
                total -= k;
            } else {
                System.out.print(total + " ");
                total = 0;
            }
        }
    }
}
