import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            
            for (int r = 0; r <= 2 * n; r++) {
                int max_val = n - Math.abs(n - r);
                StringBuilder sb = new StringBuilder();
                
                for (int i = 0; i < n - max_val; i++) {
                    sb.append("  ");
                }
                
                sb.append(0);
                for (int i = 1; i <= max_val; i++) {
                    sb.append(" ").append(i);
                }
                
                for (int i = max_val - 1; i >= 0; i--) {
                    sb.append(" ").append(i);
                }
                
                System.out.println(sb.toString());
            }
        }
        
        sc.close();
    }
}
