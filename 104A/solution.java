import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int diff = n - 10;
        
        if (diff <= 0 || diff > 11) {
            System.out.println(0);
        } else if (diff == 1 || diff == 11) {
            System.out.println(4);
        } else if (diff >= 2 && diff <= 9) {
            System.out.println(4);
        } else {
            System.out.println(15);
        }
    }
}
