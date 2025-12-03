import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] h = new int[n];
        
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        
        int maxCount = 0;
        
        for (int i = 0; i < n; i++) {
            int count = 1;
            
            for (int j = i - 1; j >= 0; j--) {
                if (h[j] <= h[j + 1]) {
                    count++;
                } else {
                    break;
                }
            }
            
            for (int j = i + 1; j < n; j++) {
                if (h[j] <= h[j - 1]) {
                    count++;
                } else {
                    break;
                }
            }
            
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        System.out.println(maxCount);
    }
}
