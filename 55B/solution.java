import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static char[] ops = new char[3];
    static long minResult = Long.MAX_VALUE;

    private static void solve(List<Long> nums, int k) {
        if (k == 3) {
            minResult = Math.min(minResult, nums.get(0));
            return;
        }

        char op = ops[k];

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                
                List<Long> nextNums = new ArrayList<>();
                long res = (op == '+') ? (nums.get(i) + nums.get(j)) : (nums.get(i) * nums.get(j));
                nextNums.add(res);

                for (int m = 0; m < nums.size(); m++) {
                    if (m != i && m != j) {
                        nextNums.add(nums.get(m));
                    }
                }
                
                solve(nextNums, k + 1);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            
            List<Long> initialNums = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                initialNums.add(in.nextLong());
            }
            
            for (int i = 0; i < 3; i++) {
                ops[i] = in.next().charAt(0);
            }
            
            solve(initialNums, 0);
            System.out.println(minResult);
        }
    }
}
