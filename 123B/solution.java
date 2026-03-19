import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextLong()) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long x1 = sc.nextLong();
            long y1 = sc.nextLong();
            long x2 = sc.nextLong();
            long y2 = sc.nextLong();
            
            long u1 = x1 + y1;
            long v1 = x1 - y1;
            long u2 = x2 + y2;
            long v2 = x2 - y2;
            
            long periodA = 2 * a;
            long periodB = 2 * b;
            
            long bu = Math.abs(Math.floorDiv(u1, periodA) - Math.floorDiv(u2, periodA));
            long bv = Math.abs(Math.floorDiv(v1, periodB) - Math.floorDiv(v2, periodB));
            
            System.out.println(Math.max(bu, bv));
        }
        
        sc.close();
    }
}
