import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextLong()) return;
        
        long t1 = sc.nextLong();
        long t2 = sc.nextLong();
        long x1 = sc.nextLong();
        long x2 = sc.nextLong();
        long t0 = sc.nextLong();
        
        if (t1 == t0 && t2 == t0) {
            System.out.println(x1 + " " + x2);
            return;
        }
        if (t1 == t0) {
            System.out.println(x1 + " 0");
            return;
        }
        if (t2 == t0) {
            System.out.println("0 " + x2);
            return;
        }
        
        long A = t2 - t0;
        long B = t0 - t1;
        
        long best_y1 = 0;
        long best_y2 = x2;
        long best_num = A * x2;
        long best_den = x2;
        
        for (long y2 = 1; y2 <= x2; y2++) {
            long y1 = (A * y2) / B;
            if (y1 > x1) {
                y1 = x1;
            }
            
            long num = A * y2 - B * y1;
            long den = y1 + y2;
            
            if (num * best_den < best_num * den) {
                best_num = num;
                best_den = den;
                best_y1 = y1;
                best_y2 = y2;
            } else if (num * best_den == best_num * den) {
                if (den > best_den) {
                    best_num = num;
                    best_den = den;
                    best_y1 = y1;
                    best_y2 = y2;
                }
            }
        }
        
        System.out.println(best_y1 + " " + best_y2);
        sc.close();
    }
}
