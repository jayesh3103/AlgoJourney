import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Team implements Comparable<Team> {
        int p;
        int t;

        Team(int p, int t) {
            this.p = p;
            this.t = t;
        }

        @Override
        public int compareTo(Team other) {
            if (this.p != other.p) {
                return Integer.compare(other.p, this.p);
            }
            return Integer.compare(this.t, other.t);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int k = sc.nextInt();

        Team[] teams = new Team[n];
        for (int i = 0; i < n; i++) {
            teams[i] = new Team(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(teams);

        Team target = teams[k - 1];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (teams[i].p == target.p && teams[i].t == target.t) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
