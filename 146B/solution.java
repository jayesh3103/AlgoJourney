import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        
        for (int c = a + 1; ; c++) {
            int mask = 0;
            int multiplier = 1;
            int temp = c;
            
            while (temp > 0) {
                int digit = temp % 10;
                if (digit == 4 || digit == 7) {
                    mask = mask + digit * multiplier;
                    multiplier *= 10;
                }
                temp /= 10;
            }
            
            if (mask == b) {
                System.out.println(c);
                break;
            }
        }
    }
}
