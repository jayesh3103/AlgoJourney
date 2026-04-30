import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();
        int a4 = sc.nextInt();

        StringBuilder res = new StringBuilder();

        if (a3 == a4) {
            if (a1 >= a3 + 1 && a2 >= a3) {
                for (int i = 0; i < a3; i++) res.append("47");
                res.append("4");
                fill(res, a1, a2, true);
            } else if (a2 >= a3 + 1 && a1 >= a3) {
                res.append("7");
                for (int i = 0; i < a3; i++) res.append("47");
                fill(res, a1, a2, false);
            } else {
                System.out.println("-1");
                return;
            }
        } else if (a3 == a4 + 1) {
            if (a1 >= a3 && a2 >= a3) {
                for (int i = 0; i < a3; i++) res.append("47");
                fill(res, a1, a2, true);
            } else {
                System.out.println("-1");
                return;
            }
        } else if (a4 == a3 + 1) {
            if (a1 >= a4 && a2 >= a4) {
                for (int i = 0; i < a4; i++) res.append("74");
                fill(res, a1, a2, false);
            } else {
                System.out.println("-1");
                return;
            }
        } else {
            System.out.println("-1");
            return;
        }

        if (res.length() > 0) {
            System.out.println(res.toString());
        }
    }

    private static void fill(StringBuilder sb, int a1, int a2, boolean startsWithFour) {
        int c4 = 0, c7 = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '4') c4++;
            else c7++;
        }

        int rem4 = a1 - c4;
        int rem7 = a2 - c7;

        if (rem4 < 0 || rem7 < 0) {
            sb.setLength(0);
            sb.append("-1");
            return;
        }

        if (startsWithFour) {
            int first4 = sb.indexOf("4");
            sb.insert(first4 + 1, "4".repeat(rem4));
            int last7 = sb.lastIndexOf("7");
            sb.insert(last7, "7".repeat(rem7));
        } else {
            int last4 = sb.lastIndexOf("4");
            sb.insert(last4, "4".repeat(rem4));
            int first7 = sb.indexOf("7");
            sb.insert(first7 + 1, "7".repeat(rem7));
        }
    }
}
