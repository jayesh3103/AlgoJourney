import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        
        for (int a = 1; a <= 9; a++) {
            int b = r1 - a;
            int c = c1 - a;
            int d = d1 - a;
            
            if (b >= 1 && b <= 9 && c >= 1 && c <= 9 && d >= 1 && d <= 9) {
                if (a != b && a != c && a != d && b != c && b != d && c != d) {
                    if (c + d == r2 && b + d == c2 && b + c == d2) {
                        System.out.println(a + " " + b);
                        System.out.println(c + " " + d);
                        sc.close();
                        return;
                    }
                }
            }
        }
        
        System.out.println("-1");
        sc.close();
    }
}
