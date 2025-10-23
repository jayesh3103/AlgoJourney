import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();

            String team1 = in.next();
            int score1 = 1;

            String team2 = "";
            int score2 = 0;

            for (int i = 1; i < n; i++) {
                String team = in.next();
                if (team.equals(team1)) {
                    score1++;
                } else {
                    team2 = team;
                    score2++;
                }
            }

            if (score1 > score2) {
                System.out.println(team1);
            } else {
                System.out.println(team2);
            }
        }
    }
}
