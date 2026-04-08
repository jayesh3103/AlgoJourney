import java.io.InputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        int n = readInt(in);
        if (n == -1) return;
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = readInt(in);
        }
        
        Arrays.sort(a);
        
        if (a[n - 1] == 1) {
            a[n - 1] = 2;
        } else {
            a[n - 1] = 1;
        }
        
        Arrays.sort(a);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(a[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
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
