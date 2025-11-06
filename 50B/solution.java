import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            
            Map<Character, Integer> counts = new HashMap<>();
            
            for (char c : s.toCharArray()) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
            
            long total = 0;
            for (int count : counts.values()) {
                total += (long)count * count;
            }
            
            System.out.println(total);
        }
    }
}
