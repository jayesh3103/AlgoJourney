import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int[] a = new int[7];
        
        for (int i = 0; i < 7; i++) {
            a[i] = sc.nextInt();
        }
        
        int i = 0;
        while (true) {
            n -= a[i];
            if (n <= 0) {
                System.out.println(i + 1);
                break;
            }
            i = (i + 1) % 7;
        }
        
        sc.close();
    }
}
