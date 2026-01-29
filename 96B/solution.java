import java.util.Scanner;

public class Main {
    static long n;
    static long result = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLong()) {
            n = sc.nextLong();
            dfs(0, 0, 0);
            System.out.println(result);
        }
    }

    static void dfs(long current, int c4, int c7) {
        if (current > result || c4 + c7 > 10) {
            return;
        }
        
        if (current >= n && c4 == c7 && c4 > 0) {
            result = current;
        }
        
        dfs(current * 10 + 4, c4 + 1, c7);
        dfs(current * 10 + 7, c4, c7 + 1);
    }
}
