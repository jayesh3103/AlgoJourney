import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        int threshold = scores[k - 1];
        int advancedCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (scores[i] >= threshold && scores[i] > 0) {
                advancedCount++;
            } else {
                break;
            }
        }
        
        System.out.println(advancedCount);
    }
}
