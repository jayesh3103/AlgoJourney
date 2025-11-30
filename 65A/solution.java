import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        if (d == 0) {
            System.out.println("Hermione");
        } else if (c == 0) {
            System.out.println("Ron");
        } else if (a == 0) {
            System.out.println(b > 0 ? "Ron" : "Hermione");
        } else if (e == 0) {
            System.out.println(f > 0 && b > 0 ? "Ron" : "Hermione");
        } else {
            if ((long)b * d * f > (long)a * c * e) {
                System.out.println("Ron");
            } else {
                System.out.println("Hermione");
            }
        }
    }
}
