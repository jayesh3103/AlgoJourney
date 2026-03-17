import java.util.Scanner;

public class Main {
    static int minDiff = Integer.MAX_VALUE;
    static int n, k;
    static String[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            n = sc.nextInt();
            k = sc.nextInt();
            nums = new String[n];
            
            for (int i = 0; i < n; i++) {
                nums[i] = sc.next();
            }

            int[] p = new int[k];
            for (int i = 0; i < k; i++) {
                p[i] = i;
            }

            permute(p, 0);

            System.out.println(minDiff);
        }
        
        sc.close();
    }

    static void permute(int[] p, int idx) {
        if (idx == k) {
            evaluate(p);
            return;
        }
        for (int i = idx; i < k; i++) {
            swap(p, i, idx);
            permute(p, idx + 1);
            swap(p, i, idx); 
        }
    }

    static void swap(int[] p, int i, int j) {
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }

    static void evaluate(int[] p) {
        int maxVal = -1;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int val = 0;
            for (int j = 0; j < k; j++) {
                val = val * 10 + (nums[i].charAt(p[j]) - '0');
            }
            if (val > maxVal) maxVal = val;
            if (val < minVal) minVal = val;
        }

        if (maxVal - minVal < minDiff) {
            minDiff = maxVal - minVal;
        }
    }
}
