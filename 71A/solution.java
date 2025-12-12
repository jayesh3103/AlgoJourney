import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            while (n-- > 0) {
                String s = sc.next();
                if (s.length() > 10) {
                    System.out.print(s.charAt(0));
                    System.out.print(s.length() - 2);
                    System.out.println(s.charAt(s.length() - 1));
                } else {
                    System.out.println(s);
                }
            }
        }
    }
}
