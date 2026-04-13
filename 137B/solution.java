import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        boolean[] seen = new boolean[n + 1];
        int validCount = 0;
        
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a >= 1 && a <= n) {
                if (!seen[a]) {
                    seen[a] = true;
                    validCount++;
                }
            }
        }
        
        System.out.println(n - validCount);
        
        sc.close();
    }
}
