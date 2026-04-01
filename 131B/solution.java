import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        long[] count = new long[21];
        
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            count[t + 10]++;
        }
        
        long totalPairs = 0;
        
        for (int i = 1; i <= 10; i++) {
            totalPairs += count[i + 10] * count[-i + 10];
        }
        
        totalPairs += (count[10] * (count[10] - 1)) / 2;
        
        System.out.println(totalPairs);
        
        sc.close();
    }
}
