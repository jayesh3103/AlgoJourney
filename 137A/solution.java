import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNext()) return;
        String s = sc.next();
        
        int trips = 0;
        int count = 0;
        char type = s.charAt(0);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == type) {
                count++;
                if (count > 5) {
                    trips++;
                    count = 1;
                }
            } else {
                trips++;
                type = c;
                count = 1;
            }
        }
        
        trips++; 
        
        System.out.println(trips);
        sc.close();
    }
}
