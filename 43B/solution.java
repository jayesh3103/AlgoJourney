import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String heading = in.nextLine();
            String letter = in.nextLine();

            Map<Character, Integer> counts = new HashMap<>();
            for (char c : heading.toCharArray()) {
                if (c != ' ') {
                    counts.put(c, counts.getOrDefault(c, 0) + 1);
                }
            }

            boolean ok = true;
            for (char c : letter.toCharArray()) {
                if (c == ' ') {
                    continue;
                }

                int count = counts.getOrDefault(c, 0);
                if (count > 0) {
                    counts.put(c, count - 1);
                } else {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
