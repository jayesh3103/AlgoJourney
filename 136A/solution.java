import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            ans[sc.nextInt()] = i;
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + (i == n ? "" : " "));
        }
        System.out.println();
        
        sc.close();
    }
}
