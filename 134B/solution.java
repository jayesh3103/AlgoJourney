import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        
        if (n == 1) {
            System.out.println(0);
            return;
        }
        
        int minSteps = Integer.MAX_VALUE;
        
        for (int i = 1; i < n; i++) {
            int a = n;
            int b = i;
            int steps = 0;
            
            while (a > 1 && b > 1) {
                if (a > b) {
                    steps += a / b;
                    a %= b;
                } else {
                    steps += b / a;
                    b %= a;
                }
            }
            
            if (a == 1) {
                steps += b - 1;
            } else if (b == 1) {
                steps += a - 1;
            } else {
                continue;
            }
            
            if (steps < minSteps) {
                minSteps = steps;
            }
        }
        
        System.out.println(minSteps);
        
        sc.close();
    }
}
