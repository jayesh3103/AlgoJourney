import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            
            int currentPassengers = 0;
            int maxCapacity = 0;
            
            for (int i = 0; i < n; i++) {
                int exit = sc.nextInt();
                int enter = sc.nextInt();
                
                currentPassengers -= exit;
                currentPassengers += enter;
                
                if (currentPassengers > maxCapacity) {
                    maxCapacity = currentPassengers;
                }
            }
            
            System.out.println(maxCapacity);
        }
        
        sc.close();
    }
}
