import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            
            Set<String> piles = new HashSet<>();
            
            for (int i = 0; i < n; i++) {
                String r1 = in.next();
                String r2 = in.next();
                
                char a = r1.charAt(0);
                char b = r1.charAt(1);
                char c = r2.charAt(0);
                char d = r2.charAt(1);
                
                String s1 = "" + a + b + c + d;
                String s2 = "" + c + a + d + b;
                String s3 = "" + d + c + b + a;
                String s4 = "" + b + d + a + c;
                
                String[] rotations = {s1, s2, s3, s4};
                Arrays.sort(rotations);
                
                piles.add(rotations[0]);
                
                if (i < n - 1) {
                    in.next();
                }
            }
            
            System.out.println(piles.size());
        }
    }
}
