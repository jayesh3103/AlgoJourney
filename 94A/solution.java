import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.next();
        
        String[] codes = new String[10];
        for (int i = 0; i < 10; i++) {
            codes[i] = scanner.next();
        }
        
        StringBuilder password = new StringBuilder();
        
        for (int i = 0; i < 8; i++) {
            String chunk = s.substring(i * 10, (i + 1) * 10);
            
            for (int j = 0; j < 10; j++) {
                if (codes[j].equals(chunk)) {
                    password.append(j);
                    break;
                }
            }
        }
        
        System.out.println(password.toString());
    }
}
