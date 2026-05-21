import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        
        char[] s = sc.next().toCharArray();
        char[] u = sc.next().toCharArray();
        
        int n = s.length;
        int m = u.length;
        
        int maxMatches = 0;
        
        for (int k = -m + 1; k < n; k++) {
            int matches = 0;
            for (int i = 0; i < m; i++) {
                int j = k + i;
                if (j >= 0 && j < n) {
                    if (u[i] == s[j]) {
                        matches++;
                    }
                }
            }
            if (matches > maxMatches) {
                maxMatches = matches;
            }
        }
        
        System.out.println(m - maxMatches);
    }
}
