import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();
        int a4 = sc.nextInt();
        sc.close();

        if (Math.abs(a3 - a4) > 1) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();

        if (a3 == a4) {
            if (a1 >= a3 + 1 && a2 >= a3) {
                append(sb, "4", a1 - a3);
                append(sb, "74", a3 - 1);
                append(sb, "7", a2 - a3 + 1);
                sb.append("4");
            } 
            else if (a1 >= a3 && a2 >= a3 + 1) {
                sb.append("7");
                append(sb, "4", a1 - a3 + 1);
                append(sb, "74", a3 - 1);
                append(sb, "7", a2 - a3);
            } else {
                System.out.println("-1");
                return;
            }
        } 
        else if (a3 == a4 + 1) {
            if (a1 >= a3 && a2 >= a3) {
                append(sb, "4", a1 - a3 + 1);
                append(sb, "74", a3 - 1);
                append(sb, "7", a2 - a3 + 1);
            } else {
                System.out.println("-1");
                return;
            }
        } 
        else if (a4 == a3 + 1) {
            if (a1 >= a4 && a2 >= a4) {
                sb.append("7");
                append(sb, "4", a1 - a4 + 1);
                append(sb, "74", a4 - 2);
                append(sb, "7", a2 - a4 + 1);
                sb.append("4");
            } else {
                System.out.println("-1");
                return;
            }
        }

        System.out.println(sb.toString());
    }

    private static void append(StringBuilder sb, String s, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(s);
        }
    }
}
