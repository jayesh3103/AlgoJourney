import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String f = in.next();
            String m = in.next();
            String s = in.next();

            boolean fWins = (f.equals("rock") && m.equals("scissors") && s.equals("scissors")) ||
                            (f.equals("scissors") && m.equals("paper") && s.equals("paper")) ||
                            (f.equals("paper") && m.equals("rock") && s.equals("rock"));

            boolean mWins = (m.equals("rock") && f.equals("scissors") && s.equals("scissors")) ||
                            (m.equals("scissors") && f.equals("paper") && s.equals("paper")) ||
                            (m.equals("paper") && f.equals("rock") && s.equals("rock"));

            boolean sWins = (s.equals("rock") && f.equals("scissors") && m.equals("scissors")) ||
                            (s.equals("scissors") && f.equals("paper") && m.equals("paper")) ||
                            (s.equals("paper") && f.equals("rock") && m.equals("rock"));

            if (fWins) {
                System.out.println("F");
            } else if (mWins) {
                System.out.println("M");
            } else if (sWins) {
                System.out.println("S");
            } else {
                System.out.println("?");
            }
        }
    }
}
