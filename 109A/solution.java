import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = n / 7; i >= 0; i--) {
            int rem = n - i * 7;
            if (rem % 4 == 0) {
                int count4 = rem / 4;
                StringBuilder sb = new StringBuilder();
                sb.append("4".repeat(count4));
                sb.append("7".repeat(i));
                System.out.println(sb);
                return;
            }
        }
        
        System.out.println("-1");
    }
}
