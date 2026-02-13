import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int h = sc.nextInt();
            
            int[] s = new int[m + 1];
            int totalPlayers = 0;
            
            for (int i = 1; i <= m; i++) {
                s[i] = sc.nextInt();
                totalPlayers += s[i];
            }
            
            if (totalPlayers < n) {
                System.out.println("-1");
                return;
            }
            
            int k = n - 1;
            int poolTotal = totalPlayers - 1;
            int poolOther = totalPlayers - s[h];
            
            if (poolOther < k) {
                System.out.println("1");
            } else {
                double probNone = 1.0;
                for (int i = 0; i < k; i++) {
                    probNone *= (double)(poolOther - i) / (poolTotal - i);
                }
                System.out.println(1.0 - probNone);
            }
        }
        sc.close();
    }
}
