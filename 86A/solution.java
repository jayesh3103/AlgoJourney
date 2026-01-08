import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLong()) {
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            
            long maxWeight = 0;
            
            long tempL = l;
            int lenL = 0;
            while (tempL > 0) {
                tempL /= 10;
                lenL++;
            }
            if (l == 0) lenL = 1;
            
            long tempR = r;
            int lenR = 0;
            while (tempR > 0) {
                tempR /= 10;
                lenR++;
            }
            if (r == 0) lenR = 1;
            
            long start = 1;
            for(int i = 1; i < lenL; i++) start *= 10;
            
            for (int len = lenL; len <= lenR; len++) {
                long K = start * 10 - 1;
                
                long low = Math.max(l, start);
                long high = Math.min(r, K);
                
                if (low <= high) {
                    long mid = K / 2;
                    
                    long wLow = low * (K - low);
                    if (wLow > maxWeight) maxWeight = wLow;
                    
                    long wHigh = high * (K - high);
                    if (wHigh > maxWeight) maxWeight = wHigh;
                    
                    if (mid >= low && mid <= high) {
                        long wMid = mid * (K - mid);
                        if (wMid > maxWeight) maxWeight = wMid;
                    }
                    if (mid + 1 >= low && mid + 1 <= high) {
                        long wMidPlus = (mid + 1) * (K - (mid + 1));
                        if (wMidPlus > maxWeight) maxWeight = wMidPlus;
                    }
                }
                
                if (len < lenR) {
                    start *= 10;
                }
            }
            
            System.out.println(maxWeight);
        }
        scanner.close();
    }
}
