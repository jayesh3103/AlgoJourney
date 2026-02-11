import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            
            int[] speed = new int[n];
            int[] ram = new int[n];
            int[] hdd = new int[n];
            int[] cost = new int[n];
            
            for (int i = 0; i < n; i++) {
                speed[i] = sc.nextInt();
                ram[i] = sc.nextInt();
                hdd[i] = sc.nextInt();
                cost[i] = sc.nextInt();
            }
            
            int ans = -1;
            int minCost = Integer.MAX_VALUE;
            
            for (int i = 0; i < n; i++) {
                boolean outdated = false;
                for (int j = 0; j < n; j++) {
                    if (speed[i] < speed[j] && ram[i] < ram[j] && hdd[i] < hdd[j]) {
                        outdated = true;
                        break;
                    }
                }
                
                if (!outdated) {
                    if (cost[i] < minCost) {
                        minCost = cost[i];
                        ans = i + 1;
                    }
                }
            }
            
            System.out.println(ans);
        }
    }
}
