import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();
            
            char[][] grid = new char[n][m];
            int[] rowCounts = new int[n];
            int[] colCounts = new int[m];
            
            for (int r = 0; r < n; r++) {
                String line = in.next();
                for (int c = 0; c < m; c++) {
                    grid[r][c] = line.charAt(c);
                    if (grid[r][c] == '*') {
                        rowCounts[r]++;
                        colCounts[c]++;
                    }
                }
            }
            
            long total = 0;
            
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (grid[r][c] == '*') {
                        long inRow = rowCounts[r] - 1;
                        long inCol = colCounts[c] - 1;
                        total += inRow * inCol;
                    }
                }
            }
            
            System.out.println(total);
        }
    }
}
