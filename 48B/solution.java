import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();
            
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = in.nextInt();
                }
            }
            
            int a = in.nextInt();
            int b = in.nextInt();
            
            int minTrees = Integer.MAX_VALUE;
            
            if (a <= n && b <= m) {
                for (int r = 0; r <= n - a; r++) {
                    for (int c = 0; c <= m - b; c++) {
                        int currentTrees = 0;
                        for (int i = r; i < r + a; i++) {
                            for (int j = c; j < c + b; j++) {
                                currentTrees += grid[i][j];
                            }
                        }
                        minTrees = Math.min(minTrees, currentTrees);
                    }
                }
            }
            
            if (a != b && b <= n && a <= m) {
                for (int r = 0; r <= n - b; r++) {
                    for (int c = 0; c <= m - a; c++) {
                        int currentTrees = 0;
                        for (int i = r; i < r + b; i++) {
                            for (int j = c; j < c + a; j++) {
                                currentTrees += grid[i][j];
                            }
                        }
                        minTrees = Math.min(minTrees, currentTrees);
                    }
                }
            }
            
            System.out.println(minTrees);
        }
    }
}
