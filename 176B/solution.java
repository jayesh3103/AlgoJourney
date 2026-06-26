import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        
        String start = sc.next();
        String end = sc.next();
        int k = sc.nextInt();
        
        int n = start.length();
        long mod = 1000000007;
        
        int c = 0;
        int m0 = 0;
        
        for (int i = 0; i < n; i++) {
            String shifted = start.substring(i) + start.substring(0, i);
            if (shifted.equals(end)) {
                c++;
                if (i == 0) {
                    m0 = 1;
                }
            }
        }
        
        long a = 1;
        long b = 0;
        
        for (int i = 0; i < k; i++) {
            long nextA = (n - 1) * b % mod;
            long nextB = (a + (n - 2) * b) % mod;
            a = nextA;
            b = nextB;
        }
        
        long ans = (m0 * a + (c - m0) * b) % mod;
        System.out.println(ans);
        
        sc.close();
    }
}
