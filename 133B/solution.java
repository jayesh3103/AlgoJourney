import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNext()) {
            String p = sc.next();
            long result = 0;
            long mod = 1000003;
            
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                int val = 0;
                
                switch (c) {
                    case '>': val = 8; break;
                    case '<': val = 9; break;
                    case '+': val = 10; break;
                    case '-': val = 11; break;
                    case '.': val = 12; break;
                    case ',': val = 13; break;
                    case '[': val = 14; break;
                    case ']': val = 15; break;
                }
                
                result = (result * 16 + val) % mod;
            }
            
            System.out.println(result);
        }
        
        sc.close();
    }
}
