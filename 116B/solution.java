import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = sc.next().toCharArray();
            }
            
            int eaten = 0;
            
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 'W') {
                        for (int k = 0; k < 4; k++) {
                            int ni = i + dx[k];
                            int nj = j + dy[k];
                            
                            if (ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == 'P') {
                                eaten++;
                                grid[ni][nj] = '.';
                                break;
                            }
                        }
                    }
                }
            }
            
            System.out.println(eaten);
        }
        
        sc.close();
    }
}
