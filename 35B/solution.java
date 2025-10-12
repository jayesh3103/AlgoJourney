import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    record Pos(int r, int c) {}

    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();

            String[][] grid = new String[n][m];
            Map<String, Pos> locs = new HashMap<>();

            for (int opCount = 0; opCount < k; opCount++) {
                String type = in.next();

                if (type.equals("+1")) {
                    int r = in.nextInt() - 1;
                    int c = in.nextInt() - 1;
                    String id = in.next();

                    boolean placed = false;
                    for (int i = r; i < n && !placed; i++) {
                        int jStart = (i == r) ? c : 0;
                        for (int j = jStart; j < m && !placed; j++) {
                            if (grid[i][j] == null) {
                                grid[i][j] = id;
                                locs.put(id, new Pos(i + 1, j + 1));
                                placed = true;
                            }
                        }
                    }
                } else {
                    String id = in.next();
                    if (locs.containsKey(id)) {
                        Pos pos = locs.remove(id);
                        out.println(pos.r() + " " + pos.c());
                        grid[pos.r() - 1][pos.c() - 1] = null;
                    } else {
                        out.println("-1 -1");
                    }
                }
            }
        }
    }
}
