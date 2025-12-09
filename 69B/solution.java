import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] l = new int[m + 1];
        int[] r = new int[m + 1];
        int[] t = new int[m + 1];
        int[] c = new int[m + 1];

        for (int i = 1; i <= m; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
            t[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        int totalProfit = 0;

        for (int section = 1; section <= n; section++) {
            int bestTime = 1001; 
            int winnerId = -1;

            for (int i = 1; i <= m; i++) {
                if (section >= l[i] && section <= r[i]) {
                    if (t[i] < bestTime) {
                        bestTime = t[i];
                        winnerId = i;
                    }
                }
            }

            if (winnerId != -1) {
                totalProfit += c[winnerId];
            }
        }

        System.out.println(totalProfit);
    }
}vv
