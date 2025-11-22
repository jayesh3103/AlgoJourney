import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        
        int l = 1;
        int r = n;
        
        for (int k = 0; k < m; k++) {
            in.next(); 
            in.next(); 
            String dir = in.next();
            in.next(); 
            int val = in.nextInt();
            
            if (dir.equals("left")) {
                r = Math.min(r, val - 1);
            } else {
                l = Math.max(l, val + 1);
            }
        }
        
        if (l > r) {
            System.out.println("-1");
        } else {
            System.out.println(r - l + 1);
        }
    }
}
