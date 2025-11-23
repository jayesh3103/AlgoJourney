import java.util.*;

public class Main {
    static int k, n, m;
    static char[][][] grid;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();

        grid = new char[k][n][m];

        for (int z = 0; z < k; z++) {
            for (int i = 0; i < n; i++) {
                String line = sc.next();
                grid[z][i] = line.toCharArray();
            }
        }

        int startX = sc.nextInt() - 1;
        int startY = sc.nextInt() - 1;

        dfs(0, startX, startY);

        System.out.println(count);
    }

    static void dfs(int z, int x, int y) {
        if (z < 0 || z >= k || x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }

        if (grid[z][x][y] == '#') {
            return;
        }

        grid[z][x][y] = '#';
        count++;

        dfs(z + 1, x, y);
        dfs(z - 1, x, y);
        dfs(z, x + 1, y);
        dfs(z, x - 1, y);
        dfs(z, x, y + 1);
        dfs(z, x, y - 1);
    }
}
