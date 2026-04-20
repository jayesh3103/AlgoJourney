import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNext()) {
            String guest = sc.next();
            String host = sc.next();
            String pile = sc.next();
            
            String combined = guest + host;
            
            if (combined.length() != pile.length()) {
                System.out.println("NO");
            } else {
                char[] c1 = combined.toCharArray();
                char[] c2 = pile.toCharArray();
                
                Arrays.sort(c1);
                Arrays.sort(c2);
                
                if (Arrays.equals(c1, c2)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        
        sc.close();
    }
}
