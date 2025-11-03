import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String line = in.nextLine();
            
            char lastLetter = ' ';
            
            for (int i = line.length() - 2; i >= 0; i--) {
                char c = line.charAt(i);
                if (Character.isLetter(c)) {
                    lastLetter = Character.toUpperCase(c);
                    break;
                }
            }
            
            String vowels = "AEIOUY";
            if (vowels.indexOf(lastLetter) != -1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
