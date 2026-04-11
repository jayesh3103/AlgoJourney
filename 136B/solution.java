import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextLong()) {
            long a = sc.nextLong();
            long c = sc.nextLong();
            
            long b = 0;
            long power = 1;
            
            while (a > 0 || c > 0) {
                long digitA = a % 3;
                long digitC = c % 3;
                
                long digitB = (digitC - digitA + 3) % 3;
                b += digitB * power;
                
                a /= 3;
                c /= 3;
                power *= 3;
            }
            
            System.out.println(b);
        }
        
        sc.close();
    }
}
