import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNext()) {
            String s = sc.next();
            
            int count4 = 0;
            int count7 = 0;
            
            for (char c : s.toCharArray()) {
                if (c == '4') {
                    count4++;
                } else if (c == '7') {
                    count7++;
                }
            }
            
            if (count4 == 0 && count7 == 0) {
                System.out.println("-1");
            } else if (count4 >= count7) {
                System.out.println("4");
            } else {
                System.out.println("7");
            }
        }
        
        sc.close();
    }
}
