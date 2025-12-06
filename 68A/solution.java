import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        int p3 = sc.nextInt();
        int p4 = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int minVal = p1;
        if (p2 < minVal) minVal = p2;
        if (p3 < minVal) minVal = p3;
        if (p4 < minVal) minVal = p4;

        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i < minVal) {
                count++;
            }
        }

        System.out.println(count);
    }
}
