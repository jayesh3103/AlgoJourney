import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            String[] names = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
            
            int copies = 1;
            
            while (n > 5 * copies) {
                n -= 5 * copies;
                copies *= 2;
            }
            
            int index = (n - 1) / copies;
            
            System.out.println(names[index]);
        }
        
        scanner.close();
    }
}
