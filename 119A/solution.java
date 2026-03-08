import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            
            int turn = 0; 
            
            while (true) {
                int fixedNumber = (turn == 0) ? a : b;
                int requiredStones = gcd(fixedNumber, n);
                
                if (requiredStones > n) {
                    System.out.println(turn == 0 ? 1 : 0);
                    break;
                }
                
                n -= requiredStones;
                turn = 1 - turn;
            }
        }
        
        sc.close();
    }
    
    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
