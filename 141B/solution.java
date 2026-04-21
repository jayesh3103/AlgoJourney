import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int a = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        if (y % a == 0) {
            System.out.println("-1");
            return;
        }
        
        int r = y / a;
        
        if (r == 0) {
            if (Math.abs(x) * 2 < a) {
                System.out.println(1);
            } else {
                System.out.println("-1");
            }
        } else if (r % 2 == 1) {
            if (Math.abs(x) * 2 < a) {
                System.out.println(2 + (r / 2) * 3);
            } else {
                System.out.println("-1");
            }
        } else {
            if (x == 0 || Math.abs(x) >= a) {
                System.out.println("-1");
            } else if (x < 0) {
                System.out.println(3 + (r / 2 - 1) * 3);
            } else {
                System.out.println(4 + (r / 2 - 1) * 3);
            }
        }
        
        sc.close();
    }
}
