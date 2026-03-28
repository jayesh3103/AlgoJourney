import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        boolean[][] adj = new boolean[n + 1][n + 1];
        int[] degree = new int[n + 1];
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = true;
            adj[v][u] = true;
            degree[u]++;
            degree[v]++;
        }
        
        int groups = 0;
        
        while (true) {
            List<Integer> toRemove = new ArrayList<>();
            
            for (int i = 1; i <= n; i++) {
                if (degree[i] == 1) {
                    toRemove.add(i);
                }
            }
            
            if (toRemove.isEmpty()) {
                break;
            }
            
            groups++;
            
            for (int u : toRemove) {
                degree[u] = 0; 
                for (int v = 1; v <= n; v++) {
                    if (adj[u][v]) {
                        adj[u][v] = false;
                        adj[v][u] = false;
                        degree[v]--;
                    }
                }
            }
        }
        
        System.out.println(groups);
        sc.close();
    }
}
