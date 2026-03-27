import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int evenCount = 0;
            int oddCount = 0;
            
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (a % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
            
            if (oddCount % 2 == 0) {
                System.out.println(evenCount);
            } else {
                System.out.println(oddCount);
            }
        }
        
        sc.close();
    }
}
