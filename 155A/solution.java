import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        if (n <= 0) return;
        
        int currentScore = sc.nextInt();
        int min = currentScore;
        int max = currentScore;
        int amazingCount = 0;
        
        for (int i = 1; i < n; i++) {
            currentScore = sc.nextInt();
            if (currentScore > max) {
                max = currentScore;
                amazingCount++;
            } else if (currentScore < min) {
                min = currentScore;
                amazingCount++;
            }
        }
        
        System.out.println(amazingCount);
        sc.close();
    }
}
