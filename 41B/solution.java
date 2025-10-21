import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int b = in.nextInt();
            
            int maxMoney = b;
            int minPrice = 2001; 

            for (int i = 0; i < n; i++) {
                int price = in.nextInt();
                minPrice = Math.min(minPrice, price);
                
                int dollars = b / minPrice;
                int leftover = b % minPrice;
                int currentTotal = dollars * price + leftover;
                
                maxMoney = Math.max(maxMoney, currentTotal);
            }

            System.out.println(maxMoney);
        }
    }
}
