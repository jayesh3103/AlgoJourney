import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        if (!sc.hasNext()) return;

        int n = sc.nextInt();
        int m = sc.nextInt();
        double k = sc.nextDouble();

        Map<String, Integer> skills = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int exp = sc.nextInt();
            int newExp = (int)(exp * k + 1e-7);
            
            if (newExp >= 100) {
                skills.put(name, newExp);
            }
        }

        for (int i = 0; i < m; i++) {
            String name = sc.next();
            if (!skills.containsKey(name)) {
                skills.put(name, 0);
            }
        }

        System.out.println(skills.size());
        for (Map.Entry<String, Integer> entry : skills.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
