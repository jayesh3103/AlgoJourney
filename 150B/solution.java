import java.util.Scanner;

public class Main {
    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        long ans;
        
        if (k > n || k == 1) {
            ans = modPow(m, n);
        } else if (k == n) {
            ans = modPow(m, (n + 1) / 2);
        } else {
            if (k % 2 == 1) {
                ans = modPow(m, 2);
            } else {
                ans = modPow(m, 1);
            }
        }

        System.out.println(ans);
    }

    private static long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) != 0) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}
