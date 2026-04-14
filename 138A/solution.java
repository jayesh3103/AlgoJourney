import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (!st.hasMoreTokens()) return;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean can_aabb = true;
        boolean can_abab = true;
        boolean can_abba = true;

        for (int i = 0; i < n; i++) {
            String[] s = new String[4];
            for (int j = 0; j < 4; j++) {
                s[j] = getSuffix(br.readLine().trim(), k);
            }

            boolean r01 = rhymes(s[0], s[1]);
            boolean r02 = rhymes(s[0], s[2]);
            boolean r03 = rhymes(s[0], s[3]);
            boolean r12 = rhymes(s[1], s[2]);
            boolean r13 = rhymes(s[1], s[3]);
            boolean r23 = rhymes(s[2], s[3]);

            boolean is_aaaa = r01 && r02 && r03 && r12 && r13 && r23;
            boolean is_aabb = r01 && r23;
            boolean is_abab = r02 && r13;
            boolean is_abba = r03 && r12;

            if (!is_aaaa) {
                can_aabb &= is_aabb;
                can_abab &= is_abab;
                can_abba &= is_abba;
            }
        }

        if (can_aabb && can_abab && can_abba) {
            System.out.println("aaaa");
        } else if (can_aabb) {
            System.out.println("aabb");
        } else if (can_abab) {
            System.out.println("abab");
        } else if (can_abba) {
            System.out.println("abba");
        } else {
            System.out.println("NO");
        }
    }

    static String getSuffix(String s, int k) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
                if (count == k) {
                    return s.substring(i);
                }
            }
        }
        return null;
    }

    static boolean rhymes(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        return s1.equals(s2);
    }
}
