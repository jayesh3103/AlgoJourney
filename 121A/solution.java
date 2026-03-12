import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Long> luckyNumbers = new ArrayList<>();

    public static void main(String[] args) {
        // A. Lucky Sum uses standard System.in, unlike the previous problems
        Scanner sc = new Scanner(System.in);
        
        long l = sc.nextLong();
        long r = sc.nextLong();
        
        generateLuckyNumbers(0);
        Collections.sort(luckyNumbers);
        
        long totalSum = 0;
        
        for (long L : luckyNumbers) {
            if (L >= l) {
                long rightBound = Math.min(r, L);
                long count = rightBound - l + 1;
                
                totalSum += count * L;
                
                l = rightBound + 1;
                
                if (l > r) {
                    break;
                }
            }
        }
        
        System.out.println(totalSum);
        sc.close();
    }

    private static void generateLuckyNumbers(long current) {
        if (current > 10000000000L) {
            return;
        }
        if (current > 0) {
            luckyNumbers.add(current);
        }
        
        generateLuckyNumbers(current * 10 + 4);
        generateLuckyNumbers(current * 10 + 7);
    }
}
