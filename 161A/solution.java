import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();

        int i = 0; 
        int j = 0; 

        ArrayList<String> matches = new ArrayList<>();

        while (i < n && j < m) {
            long minSize = (long) a[i] - x;
            long maxSize = (long) a[i] + y;

            if (b[j] >= minSize && b[j] <= maxSize) {
                matches.add((i + 1) + " " + (j + 1));
                i++;
                j++;
            } else if (b[j] < minSize) {
                j++;
            } else {
                i++;
            }
        }

        System.out.println(matches.size());
        for (String match : matches) {
            System.out.println(match);
        }
    }
}
