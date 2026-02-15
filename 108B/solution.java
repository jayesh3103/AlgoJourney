import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            long[] a = new long[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            
            Arrays.sort(a);
            
            boolean found = false;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] < a[i+1]) {
                    if (a[i] * 2 > a[i+1]) {
                        found = true;
                        break;
                    }
                }
            }
            
            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
