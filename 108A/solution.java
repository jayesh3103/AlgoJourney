import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNext()) {
            String s = sc.next();
            String[] parts = s.split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);

            while (true) {
                m++;
                if (m == 60) {
                    m = 0;
                    h++;
                }
                if (h == 24) {
                    h = 0;
                }

                if (h / 10 == m % 10 && h % 10 == m / 10) {
                    System.out.printf("%02d:%02d\n", h, m);
                    break;
                }
            }
        }
    }
}
