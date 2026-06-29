import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int r = 0;
        int c = 0;
        
        for (int i = 1; i <= n; i++) {
            String s = sc.next();
            for (int j = 1; j <= m; j++) {
                if (s.charAt(j - 1) == '*') {
                    r ^= i;
                    c ^= j;
                }
            }
        }
        
        System.out.println(r + " " + c);
        sc.close();
    }
}
