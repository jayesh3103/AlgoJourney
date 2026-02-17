import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Long> lucky = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;

        long pl = sc.nextLong();
        long pr = sc.nextLong();
        long vl = sc.nextLong();
        long vr = sc.nextLong();
        int k = sc.nextInt();

        generate(0);
        Collections.sort(lucky);
        
        lucky.add(0, 0L);
        lucky.add(2000000000L); 

        long fav = 0;
        
        for (int i = 1; i + k < lucky.size(); i++) {
            long l1 = lucky.get(i - 1) + 1;
            long r1 = lucky.get(i);
            long l2 = lucky.get(i + k - 1);
            long r2 = lucky.get(i + k) - 1;

            long pIn1 = intersect(pl, pr, l1, r1);
            long vIn2 = intersect(vl, vr, l2, r2);
            long vIn1 = intersect(vl, vr, l1, r1);
            long pIn2 = intersect(pl, pr, l2, r2);

            fav += pIn1 * vIn2;
            fav += vIn1 * pIn2;

            if (k == 1) {
                long val = lucky.get(i);
                if (val >= pl && val <= pr && val >= vl && val <= vr) {
                    fav--;
                }
            }
        }

        double total = (double)(pr - pl + 1) * (vr - vl + 1);
        System.out.printf("%.12f\n", fav / total);
    }

    static void generate(long cur) {
        if (cur > 1000000000L) return;
        if (cur > 0) lucky.add(cur);
        generate(cur * 10 + 4);
        generate(cur * 10 + 7);
    }

    static long intersect(long a, long b, long x, long y) {
        long l = Math.max(a, x);
        long r = Math.min(b, y);
        return Math.max(0, r - l + 1);
    }
}
