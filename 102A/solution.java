import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            
            int[] prices = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                prices[i] = scanner.nextInt();
            }
            
            boolean[][] isConnected = new boolean[n + 1][n + 1];
            int[] uArr = new int[m];
            int[] vArr = new int[m];
            
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                
                isConnected[u][v] = true;
                isConnected[v][u] = true;
                
                uArr[i] = u;
                vArr[i] = v;
            }
            
            int minSum = Integer.MAX_VALUE;
            boolean found = false;
            
            for (int i = 0; i < m; i++) {
                int u = uArr[i];
                int v = vArr[i];
                
                for (int w = 1; w <= n; w++) {
                    if (w == u || w == v) continue;
                    
                    if (isConnected[u][w] && isConnected[v][w]) {
                        int currentSum = prices[u] + prices[v] + prices[w];
                        if (currentSum < minSum) {
                            minSum = currentSum;
                            found = true;
                        }
                    }
                }
            }
            
            if (found) {
                System.out.println(minSum);
            } else {
                System.out.println("-1");
            }
        }
        scanner.close();
    }
}
