import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNext()) return;
        
        String[] board = new String[8];
        for (int i = 0; i < 8; i++) {
            board[i] = sc.next();
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{7, 0, 0});
        
        boolean[][][] visited = new boolean[8][8][10];
        visited[7][0][0] = true;
        
        int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];
            
            if (t >= 8 || (r == 0 && c == 7)) {
                System.out.println("WIN");
                return;
            }
            
            for (int i = 0; i < 9; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= 8 || nc < 0 || nc >= 8) continue;
                
                if (nr - t >= 0 && board[nr - t].charAt(nc) == 'S') continue;
                
                if (nr - t - 1 >= 0 && board[nr - t - 1].charAt(nc) == 'S') continue;
                
                if (!visited[nr][nc][t + 1]) {
                    visited[nr][nc][t + 1] = true;
                    q.add(new int[]{nr, nc, t + 1});
                }
            }
        }
        
        System.out.println("LOSE");
        sc.close();
    }
}
