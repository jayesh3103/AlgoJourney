import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            
            int c47 = 0; // '4' in a, '7' in b
            int c74 = 0; // '7' in a, '4' in b
            
            for (int i = 0; i < a.length(); i++) {
                char charA = a.charAt(i);
                char charB = b.charAt(i);
                
                if (charA == '4' && charB == '7') {
                    c47++;
                } else if (charA == '7' && charB == '4') {
                    c74++;
                }
            }
            
            
            System.out.println(Math.max(c47, c74));
        }
        
        sc.close();
    }
}
