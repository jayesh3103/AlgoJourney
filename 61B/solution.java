import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s1 = clean(sc.next());
        String s2 = clean(sc.next());
        String s3 = clean(sc.next());
        
        HashSet<String> valid = new HashSet<>();
        valid.add(s1 + s2 + s3);
        valid.add(s1 + s3 + s2);
        valid.add(s2 + s1 + s3);
        valid.add(s2 + s3 + s1);
        valid.add(s3 + s1 + s2);
        valid.add(s3 + s2 + s1);
        
        int n = sc.nextInt();
        while (n-- > 0) {
            String ans = clean(sc.next());
            if (valid.contains(ans)) {
                System.out.println("ACC");
            } else {
                System.out.println("WA");
            }
        }
    }
    
    static String clean(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '-' && c != '_' && c != ';') {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
