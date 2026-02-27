import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextLong()) {
            long k = sc.nextLong();
            long l = sc.nextLong();
            
            long current = k;
            int importance = 0;
            
            while (current < l) {
                current *= k;
                importance++;
            }
            
            if (current == l) {
                System.out.println("YES");
                System.out.println(importance);
            } else {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }
}
