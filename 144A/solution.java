import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int maxVal = -1;
        int maxIdx = -1;
        int minVal = 101;
        int minIdx = -1;
        
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            
            if (a > maxVal) {
                maxVal = a;
                maxIdx = i;
            }
            
            if (a <= minVal) {
                minVal = a;
                minIdx = i;
            }
        }
        
        int swaps = maxIdx + (n - 1 - minIdx);
        
        if (maxIdx > minIdx) {
            swaps--;
        }
        
        System.out.println(swaps);
        
        sc.close();
    }
}
