import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int[] roomL = new int[n];
        int[] roomW = new int[n];
        int[] roomH = new int[n];
        
        for (int i = 0; i < n; i++) {
            roomL[i] = sc.nextInt();
            roomW[i] = sc.nextInt();
            roomH[i] = sc.nextInt();
        }
        
        int m = sc.nextInt();
        int[] wpL = new int[m];
        int[] wpW = new int[m];
        long[] wpP = new long[m];
        
        for (int i = 0; i < m; i++) {
            wpL[i] = sc.nextInt();
            wpW[i] = sc.nextInt();
            wpP[i] = sc.nextLong();
        }
        
        long totalCost = 0;
        
        for (int i = 0; i < n; i++) {
            long minCostForRoom = Long.MAX_VALUE;
            long perimeter = 2L * (roomL[i] + roomW[i]);
            
            for (int j = 0; j < m; j++) {
                if (wpL[j] < roomH[i]) continue;
                
                long stripsPerRoll = wpL[j] / roomH[i];
                long widthPerRoll = stripsPerRoll * wpW[j];
                
                long rollsNeeded = (perimeter + widthPerRoll - 1) / widthPerRoll;
                long cost = rollsNeeded * wpP[j];
                
                if (cost < minCostForRoom) {
                    minCostForRoom = cost;
                }
            }
            
            totalCost += minCostForRoom;
        }
        
        System.out.println(totalCost);
        sc.close();
    }
}
