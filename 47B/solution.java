import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            Map<Character, Integer> scores = new HashMap<>();
            scores.put('A', 0);
            scores.put('B', 0);
            scores.put('C', 0);

            for (int i = 0; i < 3; i++) {
                String s = in.next();
                char c1 = s.charAt(0);
                char op = s.charAt(1);
                char c2 = s.charAt(2);

                if (op == '>') {
                    scores.put(c1, scores.get(c1) + 1);
                } else {
                    scores.put(c2, scores.get(c2) + 1);
                }
            }

            int scoreA = scores.get('A');
            int scoreB = scores.get('B');
            int scoreC = scores.get('C');

            if (scoreA == scoreB || scoreB == scoreC || scoreA == scoreC) {
                System.out.println("Impossible");
            } else {
                char[] res = new char[3];
                res[scoreA] = 'A';
                res[scoreB] = 'B';
                res[scoreC] = 'C';
                
                System.out.println(new String(res));
            }
        }
    }
}
