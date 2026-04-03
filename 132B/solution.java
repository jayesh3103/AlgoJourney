import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        char[][] grid = new char[m][];
        for (int i = 0; i < m; i++) {
            grid[i] = sc.next().toCharArray();
        }
        
        int cols = grid[0].length;
        int[][] blockId = new int[m][cols];
        
        int[] minR = new int[2505];
        int[] maxR = new int[2505];
        int[] minC = new int[2505];
        int[] maxC = new int[2505];
        char[] color = new char[2505];
        int numBlocks = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != '0' && blockId[r][c] == 0) {
                    numBlocks++;
                    minR[numBlocks] = r; maxR[numBlocks] = r;
                    minC[numBlocks] = c; maxC[numBlocks] = c;
                    color[numBlocks] = grid[r][c];

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{r, c});
                    blockId[r][c] = numBlocks;

                    int[] dr = {-1, 1, 0, 0};
                    int[] dc = {0, 0, -1, 1};

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int cr = curr[0];
                        int cc = curr[1];
                        
                        minR[numBlocks] = Math.min(minR[numBlocks], cr);
                        maxR[numBlocks] = Math.max(maxR[numBlocks], cr);
                        minC[numBlocks] = Math.min(minC[numBlocks], cc);
                        maxC[numBlocks] = Math.max(maxC[numBlocks], cc);

                        for (int i = 0; i < 4; i++) {
                            int nR = cr + dr[i];
                            int nC = cc + dc[i];
                            if (nR >= 0 && nR < m && nC >= 0 && nC < cols) {
                                if (grid[nR][nC] == grid[r][c] && blockId[nR][nC] == 0) {
                                    blockId[nR][nC] = numBlocks;
                                    q.add(new int[]{nR, nC});
                                }
                            }
                        }
                    }
                }
            }
        }

        int currBlock = blockId[0][0];
        int dp = 1; 
        int cp = 0; 
        
        int[][][] visitedStep = new int[numBlocks + 1][4][2];
        for (int i = 0; i <= numBlocks; i++) {
            for (int j = 0; j < 4; j++) {
                Arrays.fill(visitedStep[i][j], -1);
            }
        }

        for (int step = 0; step < n; step++) {
            if (visitedStep[currBlock][dp][cp] != -1) {
                int cycleLen = step - visitedStep[currBlock][dp][cp];
                int rem = (n - step) % cycleLen;
                
                for (int i = 0; i < rem; i++) {
                    int r = -1, c = -1;
                    if (dp == 0) { r = minR[currBlock]; c = (cp == 0) ? minC[currBlock] : maxC[currBlock]; }
                    else if (dp == 1) { c = maxC[currBlock]; r = (cp == 0) ? minR[currBlock] : maxR[currBlock]; }
                    else if (dp == 2) { r = maxR[currBlock]; c = (cp == 0) ? maxC[currBlock] : minC[currBlock]; }
                    else if (dp == 3) { c = minC[currBlock]; r = (cp == 0) ? maxR[currBlock] : minR[currBlock]; }

                    int nr = r, nc = c;
                    if (dp == 0) nr--; else if (dp == 1) nc++; else if (dp == 2) nr++; else if (dp == 3) nc--;

                    if (nr >= 0 && nr < m && nc >= 0 && nc < cols && grid[nr][nc] != '0') {
                        currBlock = blockId[nr][nc];
                    } else {
                        if (cp == 0) cp = 1; else { cp = 0; dp = (dp + 1) % 4; }
                    }
                }
                break;
            }
            
            visitedStep[currBlock][dp][cp] = step;
            
            int r = -1, c = -1;
            if (dp == 0) { r = minR[currBlock]; c = (cp == 0) ? minC[currBlock] : maxC[currBlock]; }
            else if (dp == 1) { c = maxC[currBlock]; r = (cp == 0) ? minR[currBlock] : maxR[currBlock]; }
            else if (dp == 2) { r = maxR[currBlock]; c = (cp == 0) ? maxC[currBlock] : minC[currBlock]; }
            else if (dp == 3) { c = minC[currBlock]; r = (cp == 0) ? maxR[currBlock] : minR[currBlock]; }

            int nr = r, nc = c;
            if (dp == 0) nr--; else if (dp == 1) nc++; else if (dp == 2) nr++; else if (dp == 3) nc--;

            if (nr >= 0 && nr < m && nc >= 0 && nc < cols && grid[nr][nc] != '0') {
                currBlock = blockId[nr][nc];
            } else {
                if (cp == 0) cp = 1; else { cp = 0; dp = (dp + 1) % 4; }
            }
        }

        System.out.println(color[currBlock]);
        sc.close();
    }
}
