import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        
        String s = sc.next();
        int n = s.length();
        long maxSum = -1;
        
        for (int i = 1; i <= Math.min(n - 2, 7); i++) {
            for (int j = i + 1; j <= Math.min(n - 1, i + 7); j++) {
                int len3 = n - j;
                if (len3 > 7) continue;
                
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, j);
                String s3 = s.substring(j, n);
                
                if (isValid(s1) && isValid(s2) && isValid(s3)) {
                    long currentSum = Long.parseLong(s1) + Long.parseLong(s2) + Long.parseLong(s3);
                    maxSum = Math.max(maxSum, currentSum);
                }
            }
        }
        
        System.out.println(maxSum);
        sc.close();
    }
    
    private static boolean isValid(String str) {
        if (str.length() == 0 || str.length() > 7) {
            return false;
        }
        
        if (str.length() > 1 && str.charAt(0) == '0') {
            return false;
        }
        
        long val = Long.parseLong(str);
        if (val > 1000000) {
            return false;
        }
        
        return true;
    }
}
