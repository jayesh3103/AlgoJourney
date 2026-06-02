import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        
        int n = scanner.nextInt();
        int pentagonalNumber = (3 * n * n - n) / 2;
        
        System.out.println(pentagonalNumber);
        
        scanner.close();
    }
}
