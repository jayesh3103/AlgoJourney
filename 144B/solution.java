import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int xa = sc.nextInt();
        int ya = sc.nextInt();
        int xb = sc.nextInt();
        int yb = sc.nextInt();
        
        int xMin = Math.min(xa, xb);
        int xMax = Math.max(xa, xb);
        int yMin = Math.min(ya, yb);
        int yMax = Math.max(ya, yb);
        
        int n = sc.nextInt();
        int[][] radiators = new int[n][3];
        for (int i = 0; i < n; i++) {
            radiators[i][0] = sc.nextInt(); // x
            radiators[i][1] = sc.nextInt(); // y
            radiators[i][2] = sc.nextInt(); // r
        }
        
        List<int[]> generals = new ArrayList<>();
        
        for (int x = xMin; x <= xMax; x++) {
            generals.add(new int[]{x, yMin});
            generals.add(new int[]{x, yMax});
        }
        for (int y = yMin + 1; y < yMax; y++) {
            generals.add(new int[]{xMin, y});
            generals.add(new int[]{xMax, y});
        }
        
        int blankets = 0;
        for (int[] g : generals) {
            boolean warm = false;
            for (int i = 0; i < n; i++) {
                long dx = g[0] - radiators[i][0];
                long dy = g[1] - radiators[i][1];
                long r = radiators[i][2];
                if (dx * dx + dy * dy <= r * r) {
                    warm = true;
                    break;
                }
            }
            if (!warm) {
                blankets++;
            }
        }
        
        System.out.println(blankets);
        sc.close();
    }
}
