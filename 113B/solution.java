import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        if (t == null) return;
        String sbegin = br.readLine();
        String send = br.readLine();

        int n = t.length();
        int n1 = sbegin.length();
        int n2 = send.length();

        List<Integer> starts = new ArrayList<>();
        for (int i = 0; i <= n - n1; i++) {
            if (t.startsWith(sbegin, i)) {
                starts.add(i);
            }
        }

        List<Integer> ends = new ArrayList<>();
        for (int i = 0; i <= n - n2; i++) {
            if (t.startsWith(send, i)) {
                ends.add(i);
            }
        }

        long P1 = 313, M1 = 1000000007L;
        long P2 = 317, M2 = 1000000009L;

        long[] H1 = new long[n + 1];
        long[] H2 = new long[n + 1];
        long[] P1_pow = new long[n + 1];
        long[] P2_pow = new long[n + 1];

        P1_pow[0] = 1;
        P2_pow[0] = 1;

        for (int i = 1; i <= n; i++) {
            H1[i] = (H1[i - 1] * P1 + t.charAt(i - 1)) % M1;
            H2[i] = (H2[i - 1] * P2 + t.charAt(i - 1)) % M2;
            P1_pow[i] = (P1_pow[i - 1] * P1) % M1;
            P2_pow[i] = (P2_pow[i - 1] * P2) % M2;
        }

        long[] hashes = new long[starts.size() * ends.size()];
        int count = 0;

        for (int i : starts) {
            for (int j : ends) {
                if (j >= i && j + n2 - i >= n1) {
                    int L = i + 1;
                    int R = j + n2;

                    long h1 = (H1[R] - (H1[L - 1] * P1_pow[R - L + 1]) % M1 + M1) % M1;
                    long h2 = (H2[R] - (H2[L - 1] * P2_pow[R - L + 1]) % M2 + M2) % M2;

                    hashes[count++] = (h1 << 32) | h2;
                }
            }
        }

        Arrays.sort(hashes, 0, count);

        int unique = 0;
        for (int k = 0; k < count; k++) {
            if (k == 0 || hashes[k] != hashes[k - 1]) {
                unique++;
            }
        }

        System.out.println(unique);
    }
}
