import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            in.nextLine(); 

            HashSet<String> leaves = new HashSet<>();

            for (int i = 0; i < n; i++) {
                String line = in.nextLine();
                leaves.add(line);
            }

            System.out.println(leaves.size());
        }
    }
}
