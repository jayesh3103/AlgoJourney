import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    static class Item implements Comparable<Item> {
        int profit;
        int count;
        
        public Item(int profit, int count) {
            this.profit = profit;
            this.count = count;
        }
        
        @Override
        public int compareTo(Item other) {
            return Integer.compare(other.profit, this.profit);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        int[][][] planetData = new int[n][m][3];
        String[] planetNames = new String[n];
        
        for (int i = 0; i < n; i++) {
            planetNames[i] = sc.next();
            for (int j = 0; j < m; j++) {
                planetData[i][j][0] = sc.nextInt();
                planetData[i][j][1] = sc.nextInt();
                planetData[i][j][2] = sc.nextInt();
            }
        }
        
        int maxTotalProfit = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                List<Item> profitableItems = new ArrayList<>();
                for (int itemType = 0; itemType < m; itemType++) {
                    int costToBuy = planetData[i][itemType][0];
                    int sellPrice = planetData[j][itemType][1];
                    int availableAmount = planetData[i][itemType][2];
                    
                    int profit = sellPrice - costToBuy;
                    if (profit > 0 && availableAmount > 0) {
                        profitableItems.add(new Item(profit, availableAmount));
                    }
                }
                
                Collections.sort(profitableItems);
                
                int currentProfit = 0;
                int currentCapacity = 0;
                
                for (Item item : profitableItems) {
                    if (currentCapacity >= k) break;
                    
                    int takeAmount = Math.min(item.count, k - currentCapacity);
                    currentProfit += takeAmount * item.profit;
                    currentCapacity += takeAmount;
                }
                
                if (currentProfit > maxTotalProfit) {
                    maxTotalProfit = currentProfit;
                }
            }
        }
        
        System.out.println(maxTotalProfit);
        sc.close();
    }
}
