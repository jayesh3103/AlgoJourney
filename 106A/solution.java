import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String tStr = sc.next();
        char trump = tStr.charAt(0);
        
        String card1 = sc.next();
        String card2 = sc.next();
        
        char rank1 = card1.charAt(0);
        char suit1 = card1.charAt(1);
        
        char rank2 = card2.charAt(0);
        char suit2 = card2.charAt(1);
        
        String ranks = "6789TJQKA";
        
        if (suit1 == suit2) {
            if (ranks.indexOf(rank1) > ranks.indexOf(rank2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            if (suit1 == trump) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
