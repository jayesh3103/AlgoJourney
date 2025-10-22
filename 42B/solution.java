import java.util.Scanner;

public class Main {

    private static boolean isBetween(int a, int mid, int b) {
        return (mid > Math.min(a, b) && mid < Math.max(a, b));
    }

    private static int[] parse(String s) {
        return new int[]{s.charAt(1) - '1', s.charAt(0) - 'a'};
    }

    private static boolean rookAtk(int r, int c, int[] rook, int[] b1, int[] b2, int[] b3) {
        if (r == rook[0] && c == rook[1]) return false;

        if (r == rook[0]) {
            if (b1[0] == r && isBetween(rook[1], b1[1], c)) return false;
            if (b2[0] == r && isBetween(rook[1], b2[1], c)) return false;
            if (b3[0] == r && isBetween(rook[1], b3[1], c)) return false;
            return true;
        }

        if (c == rook[1]) {
            if (b1[1] == c && isBetween(rook[0], b1[0], r)) return false;
            if (b2[1] == c && isBetween(rook[0], b2[0], r)) return false;
            if (b3[1] == c && isBetween(rook[0], b3[0], r)) return false;
            return true;
        }
        return false;
    }

    private static boolean isAttacked(int r, int c, int[] r1, int[] r2, int[] wk, int[] bk) {
        if (Math.abs(r - wk[0]) <= 1 && Math.abs(c - wk[1]) <= 1) {
            return true;
        }
        if (rookAtk(r, c, r1, r2, wk, bk)) {
            return true;
        }
        if (rookAtk(r, c, r2, r1, wk, bk)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] r1 = parse(in.next());
        int[] r2 = parse(in.next());
        int[] wk = parse(in.next());
        int[] bk = parse(in.next());
        in.close();

        boolean canEscape = false;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nr = bk[0] + dr;
                int nc = bk[1] + dc;

                if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) {
                    if (!isAttacked(nr, nc, r1, r2, wk, new int[]{nr, nc})) {
                        canEscape = true;
                        break;
                    }
                }
            }
            if (canEscape) {
                break;
            }
        }

        System.out.println(canEscape ? "OTHER" : "CHECKMATE");
    }
}
