import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] targetCounts = {5, 7, 5};
        
        for (int i = 0; i < 3; i++) {
            if (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (countVowels(line) != targetCounts[i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        
        System.out.println("YES");
    }

    private static int countVowels(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
}
