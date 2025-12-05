import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        
        int[] counts = new int[n + 1];
        boolean[] used = new boolean[n + 1];
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!used[j] && counts[j] == b[j]) {
                    ans[i] = j;
                    used[j] = true;
                    
                    for (int p = 1; p <= n; p++) {
                        if (!used[p] && j >= p + k) {
                            counts[p]++;
                        }
                    }
                    break;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
