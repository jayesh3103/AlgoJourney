import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int sum = 0;
        for (int k = 1; sum < n; k++) {
            sum += k;
        }
        
        if (sum == n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        in.close();
    }
}
