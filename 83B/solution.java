import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();
        long k = fs.nextLong();
        long[] a = new long[n];
        long sum = 0;
        
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
            sum += a[i];
        }

        if (sum < k) {
            out.println("-1");
            out.flush();
            return;
        }
        
        long low = 0, high = 2000000000L; 
        long L = 0;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long val = getSum(a, mid);
            if (val <= k) {
                L = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        long spent = getSum(a, L);
        long rem = k - spent;
        
        int[] survivors = new int[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (a[i] > L) {
                survivors[count++] = i + 1;
            }
        }
        
        for (int i = (int)rem; i < count; i++) {
            out.print(survivors[i] + " ");
        }
        
        for (int i = 0; i < (int)rem; i++) {
            if (a[survivors[i]-1] > L + 1) {
                out.print(survivors[i] + " ");
            }
        }
        
        out.flush();
    }
    
    static long getSum(long[] a, long limit) {
        long total = 0;
        for (long val : a) {
            total += Math.min(val, limit);
        }
        return total;
    }
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        
        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
