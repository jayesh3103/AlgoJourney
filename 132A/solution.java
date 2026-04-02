import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        if (s == null) return;
        
        int prev = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            
            int curr = reverse8(c);
            
            int ans = (prev - curr + 256) % 256;
            System.out.println(ans);
            
            prev = curr;
        }
    }
    
    static int reverse8(int x) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            res <<= 1;
            res |= (x & 1);
            x >>= 1;
        }
        return res;
    }
}
