import java.util.*;

public class Main {
    static Map<String, Integer> map = new HashMap<>();
    static boolean[][] adj = new boolean[7][7];
    static int[] teams = new int[7];
    static long A, B, C;
    static long minDiff = Long.MAX_VALUE;
    static int maxLiking = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Anka", "Chapay", "Cleo", "Troll", "Dracul", "Snowy", "Hexadecimal"};
        for (int i = 0; i < 7; i++) map.put(names[i], i);

        if (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String u = sc.next();
                sc.next(); 
                String v = sc.next();
                adj[map.get(u)][map.get(v)] = true;
            }
            A = sc.nextLong();
            B = sc.nextLong();
            C = sc.nextLong();

            solve(0);
            System.out.println(minDiff + " " + maxLiking);
        }
    }

    static void solve(int idx) {
        if (idx == 7) {
            int c0 = 0, c1 = 0, c2 = 0;
            for (int i = 0; i < 7; i++) {
                if (teams[i] == 0) c0++;
                else if (teams[i] == 1) c1++;
                else c2++;
            }
            if (c0 > 0 && c1 > 0 && c2 > 0) {
                long ea = A / c0;
                long eb = B / c1;
                long ec = C / c2;
                long min = Math.min(ea, Math.min(eb, ec));
                long max = Math.max(ea, Math.max(eb, ec));
                long diff = max - min;
                
                int like = 0;
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 7; j++) {
                        if (i != j && teams[i] == teams[j] && adj[i][j]) {
                            like++;
                        }
                    }
                }

                if (diff < minDiff) {
                    minDiff = diff;
                    maxLiking = like;
                } else if (diff == minDiff) {
                    maxLiking = Math.max(maxLiking, like);
                }
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            teams[idx] = i;
            solve(idx + 1);
        }
    }
}
