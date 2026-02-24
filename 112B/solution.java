import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int size = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            int n = size / 2;
            
            if ((x == n || x == n + 1) && (y == n || y == n + 1)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        
        sc.close();
    }
}
