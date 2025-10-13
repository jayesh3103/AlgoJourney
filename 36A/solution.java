import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            in.nextInt();
            String s = in.next();

            List<Integer> ones = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    ones.add(i);
                }
            }

            boolean ok = true;
            int diff = ones.get(1) - ones.get(0);
            for (int i = 2; i < ones.size(); i++) {
                if (ones.get(i) - ones.get(i - 1) != diff) {
                    ok = false;
                    break;
                }
            }
            
            out.println(ok ? "YES" : "NO");
        }
    }
}
