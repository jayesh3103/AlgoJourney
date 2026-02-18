import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNext()) {
            String n = sc.next();
            int count = 0;
            
            for (int i = 0; i < n.length(); i++) {
                char c = n.charAt(i);
                if (c == '4' || c == '7') {
                    count++;
                }
            }
            
            if (count == 4 || count == 7) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
