import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) return;
        String t = br.readLine();

        int n = s.length();
        int m = t.length();

        int[] prevSum = new int[m + 1];
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            int[] currSum = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                int currDp = 0;
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    currDp = (1 + prevSum[j - 1]) % MOD;
                    ans = (ans + currDp) % MOD;
                }
                currSum[j] = (currSum[j - 1] + currDp) % MOD;
            }
            prevSum = currSum;
        }

        System.out.println(ans);
    }
}
