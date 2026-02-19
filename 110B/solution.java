import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            
            StringBuilder sb = new StringBuilder(n);
            char[] pattern = {'a', 'b', 'c', 'd'};
            
            for (int i = 0; i < n; i++) {
                sb.append(pattern[i % 4]);
            }
            
            System.out.println(sb.toString());
        }
        
        sc.close();
    }
}
