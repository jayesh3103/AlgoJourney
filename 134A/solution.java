import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        int n = readInt(in);
        if (n == -1) return;
        
        int[] a = new int[n];
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            a[i] = readInt(in);
            sum += a[i];
        }
        
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        if (sum % n == 0) {
            int target = sum / n;
            for (int i = 0; i < n; i++) {
                if (a[i] == target) {
                    count++;
                    sb.append(i + 1).append(" ");
                }
            }
        }
        
        System.out.println(count);
        if (count > 0) {
            System.out.println(sb.toString().trim());
        }
    }
    
    static int readInt(InputStream in) throws Exception {
        int c = in.read();
        while (c <= 32) {
            if (c == -1) return -1;
            c = in.read();
        }
        int res = 0;
        while (c > 32) {
            res = res * 10 + c - '0';
            c = in.read();
        }
        return res;
    }
}
