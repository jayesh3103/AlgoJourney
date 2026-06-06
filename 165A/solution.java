import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        
        int supercentralCount = 0;
        
        for (int i = 0; i < n; i++) {
            boolean hasRight = false;
            boolean hasLeft = false;
            boolean hasUpper = false;
            boolean hasLower = false;
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                if (points[j][0] > points[i][0] && points[j][1] == points[i][1]) {
                    hasRight = true;
                }
                if (points[j][0] < points[i][0] && points[j][1] == points[i][1]) {
                    hasLeft = true;
                }
                if (points[j][0] == points[i][0] && points[j][1] > points[i][1]) {
                    hasUpper = true;
                }
                if (points[j][0] == points[i][0] && points[j][1] < points[i][1]) {
                    hasLower = true;
                }
            }
            
            if (hasRight && hasLeft && hasUpper && hasLower) {
                supercentralCount++;
            }
        }
        
        System.out.println(supercentralCount);
        sc.close();
    }
}
