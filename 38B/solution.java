import java.util.Scanner;

public class Main {

    static final int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.next();
        int rR = s1.charAt(1) - '1';
        int rC = s1.charAt(0) - 'a';

        String s2 = in.next();
        int kR = s2.charAt(1) - '1';
        int kC = s2.charAt(0) - 'a';

        boolean[][] bad = new boolean[8][8];

        bad[rR][rC] = true;
        bad[kR][kC] = true;

        for (int i = 0; i < 8; i++) {
            bad[rR][i] = true;
            bad[i][rC] = true;
        }

        markKnight(bad, rR, rC);
        markKnight(bad, kR, kC);

        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!bad[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
        in.close();
    }

    private static void markKnight(boolean[][] grid, int r, int c) {
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) {
                grid[nr][nc] = true;
            }
        }
    }
}
