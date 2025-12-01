import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] ans = new int[n];
        int last = 1000;

        for (int i = 0; i < n; i++) {
            int current = arr[i];
            int best = 10000;

            if (current >= last && current <= 2011) {
                best = current;
            }

            int[] digits = new int[4];
            digits[0] = current / 1000;
            digits[1] = (current / 100) % 10;
            digits[2] = (current / 10) % 10;
            digits[3] = current % 10;

            for (int j = 0; j < 4; j++) {
                int original = digits[j];
                for (int k = 0; k <= 9; k++) {
                    digits[j] = k;
                    int val = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
                    
                    if (val >= last && val <= 2011) {
                        if (val < best) {
                            best = val;
                        }
                    }
                }
                digits[j] = original;
            }

            if (best == 10000) {
                System.out.println("No solution");
                return;
            }

            ans[i] = best;
            last = best;
        }

        for (int x : ans) {
            System.out.println(x);
        }
    }
}
