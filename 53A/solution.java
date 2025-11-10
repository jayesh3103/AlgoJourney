import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            int n = in.nextInt();
            
            List<String> matches = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String page = in.next();
                if (page.startsWith(s)) {
                    matches.add(page);
                }
            }
            
            if (matches.isEmpty()) {
                System.out.println(s);
            } else {
                Collections.sort(matches);
                System.out.println(matches.get(0));
            }
        }
    }
}
