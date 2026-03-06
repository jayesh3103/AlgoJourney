import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNext()) {
            String s = sc.next().toLowerCase();
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'y') {
                    sb.append('.').append(c);
                }
            }
            
            System.out.println(sb.toString());
        }
        
        sc.close();
    }
}
