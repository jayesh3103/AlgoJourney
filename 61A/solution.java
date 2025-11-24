import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s1 = sc.next();
        String s2 = sc.next();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        
        System.out.println(sb);
    }
}
