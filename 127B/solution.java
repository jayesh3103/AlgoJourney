import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] counts = new int[101];
            
            for (int i = 0; i < n; i++) {
                counts[sc.nextInt()]++;
            }
            
            int totalPairs = 0;
            for (int i = 1; i <= 100; i++) {
                totalPairs += counts[i] / 2;
            }
            
            System.out.println(totalPairs / 2);
        }
        
        sc.close();
    }
}
