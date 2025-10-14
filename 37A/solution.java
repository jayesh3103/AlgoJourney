import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] counts = new int[1001];

        for (int i = 0; i < n; i++) {
            counts[in.nextInt()]++;
        }

        int maxH = 0;
        int towers = 0;

        for (int c : counts) {
            if (c > 0) {
                towers++;
                maxH = Math.max(maxH, c);
            }
        }

        System.out.println(maxH + " " + towers);
        in.close();
    }
}
