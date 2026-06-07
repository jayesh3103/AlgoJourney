import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) return;
        
        long n = sc.nextLong();
        long k = sc.nextLong();
        
        long left = 1;
        long right = n;
        long ans = n;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(mid, n, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(ans);
        sc.close();
    }
    
    private static boolean check(long v, long n, long k) {
        long sum = 0;
        long currentV = v;
        while (currentV > 0) {
            sum += currentV;
            currentV /= k;
        }
        return sum >= n;
    }
}
