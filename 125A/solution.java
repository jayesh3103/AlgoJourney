import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            
            int totalInches = (n + 1) / 3;
            
            int feet = totalInches / 12;
            int inches = totalInches % 12;
            
            System.out.println(feet + " " + inches);
        }
        
        sc.close();
    }
}
