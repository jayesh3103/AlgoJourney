import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            String t = in.next();

            String reversedS = new StringBuilder(s).reverse().toString();

            if (reversedS.equals(t)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
