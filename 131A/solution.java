import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNext()) {
            String s = sc.next();
            boolean isAccident = true;
            
            for (int i = 1; i < s.length(); i++) {
                if (Character.isLowerCase(s.charAt(i))) {
                    isAccident = false;
                    break;
                }
            }
            
            if (isAccident) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (Character.isUpperCase(chars[i])) {
                        chars[i] = Character.toLowerCase(chars[i]);
                    } else {
                        chars[i] = Character.toUpperCase(chars[i]);
                    }
                }
                System.out.println(new String(chars));
            } else {
                System.out.println(s);
            }
        }
        
        sc.close();
    }
}
