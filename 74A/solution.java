import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            
            String bestHandle = "";
            long maxScore = Long.MIN_VALUE;
            
            for (int i = 0; i < n; i++) {
                String handle = sc.next();
                int plus = sc.nextInt();
                int minus = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                int d = sc.nextInt();
                int e = sc.nextInt();
                
                long score = (long)plus * 100 - (long)minus * 50 + a + b + c + d + e;
                
                if (score > maxScore) {
                    maxScore = score;
                    bestHandle = handle;
                }
            }
            
            System.out.println(bestHandle);
        }
    }
}
