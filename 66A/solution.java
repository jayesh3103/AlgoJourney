import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        try {
            long n = Long.parseLong(s);
            
            if (n <= 127) {
                System.out.println("byte");
            } else if (n <= 32767) {
                System.out.println("short");
            } else if (n <= 2147483647) {
                System.out.println("int");
            } else {
                System.out.println("long");
            }
        } catch (Exception e) {
            System.out.println("BigInteger");
        }
    }
}
