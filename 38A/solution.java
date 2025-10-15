import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        
        int[] d = new int[n];
        for (int i = 1; i < n; i++) {
            d[i] = in.nextInt();
        }

        int a = in.nextInt();
        int b = in.nextInt();

        int years = 0;
        for (int i = a; i < b; i++) {
            years += d[i];
        }

        System.out.println(years);
        in.close();
    }
}
