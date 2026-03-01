import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            
            int[] p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = sc.nextInt();
            }
            
            int maxDepth = 0;
            
            for (int i = 1; i <= n; i++) {
                int current = i;
                int depth = 0;
                
                while (current != -1) {
                    depth++;
                    current = p[current];
                }
                
                maxDepth = Math.max(maxDepth, depth);
            }
            
            System.out.println(maxDepth);
        }
        
        sc.close();
    }
}
