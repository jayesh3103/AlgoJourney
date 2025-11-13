import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static char[][] grid;
    static int A, B;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            A = in.nextInt();
            B = in.nextInt();
            grid = new char[A][B];

            for (int i = 0; i < A; i++) {
                grid[i] = in.next().toCharArray();
            }

            int count = 0;
            int minArea = Integer.MAX_VALUE;
            int minX = A;
            int minY = B;

            for (int x = 1; x <= A; x++) {
                if (A % x != 0) continue;
                
                for (int y = 1; y <= B; y++) {
                    if (B % y != 0) continue;
                    
                    if (isGood(x, y)) {
                        count++;
                        int area = x * y;
                        if (area < minArea) {
                            minArea = area;
                            minX = x;
                            minY = y;
                        } else if (area == minArea) {
                            if (x < minX) {
                                minX = x;
                                minY = y;
                            }
                        }
                    }
                }
            }

            System.out.println(count);
            System.out.println(minX + " " + minY);
        }
    }

    private static boolean isGood(int x, int y) {
        Set<String> pieces = new HashSet<>();
        
        for (int i = 0; i <= A - x; i += x) {
            for (int j = 0; j <= B - y; j += y) {
                
                char[][] piece = new char[x][y];
                for (int r = 0; r < x; r++) {
                    for (int c = 0; c < y; c++) {
                        piece[r][c] = grid[i + r][j + c];
                    }
                }
                
                String canonical = getCanonical(piece, x, y);
                if (!pieces.add(canonical)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String getCanonical(char[][] p, int h, int w) {
        String[] rots = new String[4];
        
        rots[0] = stringify(p, h);
        char[][] p180 = rotate180(p, h, w);
        rots[1] = stringify(p180, h);
        
        if (h == w) {
            char[][] p90 = rotate90(p, h, w);
            rots[2] = stringify(p90, w);
            char[][] p270 = rotate180(p90, w, h);
            rots[3] = stringify(p270, w);
        } else {
            rots[2] = "~"; 
            rots[3] = "~";
        }
        
        Arrays.sort(rots);
        return rots[0];
    }

    private static String stringify(char[][] g, int h) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < h; r++) {
            sb.append(g[r]);
        }
        return sb.toString();
    }

    private static char[][] rotate90(char[][] g, int h, int w) {
        char[][] res = new char[w][h];
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                res[c][h - 1 - r] = g[r][c];
            }
        }
        return res;
    }

    private static char[][] rotate180(char[][] g, int h, int w) {
        char[][] res = new char[h][w];
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                res[h - 1 - r][w - 1 - c] = g[r][c];
            }
        }
        return res;
    }
}
