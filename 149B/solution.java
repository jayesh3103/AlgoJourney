import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String[] parts = sc.next().split(":");
        sc.close();
        
        String a = parts[0];
        String b = parts[1];

        int minR = 2;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            int d = (c >= '0' && c <= '9') ? (c - '0') : (c - 'A' + 10);
            if (d + 1 > minR) minR = d + 1;
        }
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            int d = (c >= '0' && c <= '9') ? (c - '0') : (c - 'A' + 10);
            if (d + 1 > minR) minR = d + 1;
        }

        if (val(a, 70) != -1 && val(a, 70) < 24 && val(b, 70) != -1 && val(b, 70) < 60) {
            System.out.println("-1");
            return;
        }

        List<Integer> valid = new ArrayList<>();
        for (int r = minR; r <= 60; r++) {
            int va = val(a, r);
            int vb = val(b, r);
            if (va != -1 && va < 24 && vb != -1 && vb < 60) {
                valid.add(r);
            }
        }

        if (valid.isEmpty()) {
            System.out.println("0");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < valid.size(); i++) {
                sb.append(valid.get(i));
                if (i < valid.size() - 1) sb.append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    private static int val(String s, int r) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = (c >= '0' && c <= '9') ? (c - '0') : (c - 'A' + 10);
            if (d >= r) return -1;
            res = res * r + d;
            if (res > 100) return 1000;
        }
        return res;
    }
}
