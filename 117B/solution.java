import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) return;
        
        long a = sc.nextLong();
        long b = sc.nextLong();
        int mod = sc.nextInt();
        
        if (b >= mod - 1) {
            System.out.println("2");
            return;
        }
        
        int p = (int)(1000000000L % mod);
        int val = 0;
        long limit = Math.min(a, mod);
        
        for (long i = 1; i <= limit; i++) {
            val += p;
            if (val >= mod) {
                val -= mod;
            }
            
            int rem = (val == 0) ? 0 : (mod - val);
            
            if (rem > b) {
                System.out.printf("1 %09d\n", i);
                return;
            }
        }
        
        System.out.println("2");
    }
}
