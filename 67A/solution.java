import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == 'R') {
                ans[i + 1] = ans[i] + 1;
            } else if (s.charAt(i) == '=') {
                ans[i + 1] = ans[i];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == 'L') {
                ans[i] = Math.max(ans[i], ans[i + 1] + 1);
            } else if (s.charAt(i) == '=') {
                ans[i] = ans[i + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
