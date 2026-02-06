import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            if (m != n) {
                System.out.println("NO");
                return;
            }
            
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            
            boolean[] visited = new boolean[n + 1];
            dfs(1, adj, visited);
            
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    System.out.println("NO");
                    return;
                }
            }
            
            System.out.println("FHTAGN!");
        }
    }
    
    private static void dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
}
