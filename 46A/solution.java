import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int pos = 0;
        int dist = 1;
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            pos = (pos + dist) % n;
            sb.append(pos + 1);
            if (i < n - 2) {
                sb.append(" ");
            }
            dist++;
        }

        System.out.println(sb.toString());
        in.close();
    }
}
