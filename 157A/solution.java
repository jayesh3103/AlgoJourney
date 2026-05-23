import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
            }
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (colSum[j] > rowSum[i]) {
                    ans++;
                }
            }
        }
        
        System.out.println(ans);
        sc.close();
    }
}
