import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[] lastSeen = new int[100001];
        
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            List<Integer> divisors = getDivisors(x);
            int count = 0;
            int threshold = i - y;

            for (int d : divisors) {
                if (lastSeen[d] < threshold) {
                    count++;
                }
                lastSeen[d] = i;
            }
            out.println(count);
        }

        out.flush();
        out.close();
    }

    private static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i * i != n) {
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }
}
