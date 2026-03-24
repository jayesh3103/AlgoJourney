import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        if (s == null || s.isEmpty()) return;
        
        int n = s.length();
        if (n < 3) {
            System.out.println("Just a legend");
            return;
        }
        
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        
        int l1 = pi[n - 1];
        if (l1 == 0) {
            System.out.println("Just a legend");
            return;
        }
        
        int max_pi = 0;
        for (int i = 1; i < n - 1; i++) {
            if (pi[i] > max_pi) {
                max_pi = pi[i];
            }
        }
        
        if (max_pi >= l1) {
            System.out.println(s.substring(0, l1));
        } else {
            int l2 = pi[l1 - 1];
            if (l2 > 0) {
                System.out.println(s.substring(0, l2));
            } else {
                System.out.println("Just a legend");
            }
        }
    }
}
