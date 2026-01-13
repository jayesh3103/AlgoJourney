import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            char[][] grid = new char[n][m];
            
            for (int i = 0; i < n; i++) {
                String row = sc.next();
                grid[i] = row.toCharArray();
            }
            
            int[][] rowCounts = new int[n][26];
            int[][] colCounts = new int[m][26];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int charIdx = grid[i][j] - 'a';
                    rowCounts[i][charIdx]++;
                    colCounts[j][charIdx]++;
                }
            }
            
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int charIdx = grid[i][j] - 'a';
                    
                    if (rowCounts[i][charIdx] == 1 && colCounts[j][charIdx] == 1) {
                        result.append(grid[i][j]);
                    }
                }
            }
            
            System.out.println(result.toString());
        }
        sc.close();
    }
}
