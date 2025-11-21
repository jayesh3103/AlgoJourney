import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int sum = 0;
        int minOdd = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            sum += val;
            
            if (val % 2 != 0) {
                minOdd = Math.min(minOdd, val);
            }
        }
        
        if (sum % 2 != 0) {
            System.out.println(sum);
        } else {
            if (minOdd == Integer.MAX_VALUE) {
                System.out.println(0);
            } else {
                System.out.println(sum - minOdd);
            }
        }
    }
}
