import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        
        Arrays.sort(h);
        
        int ways = h[b] - h[b - 1];
        System.out.println(ways);
        
        sc.close();
    }
}
