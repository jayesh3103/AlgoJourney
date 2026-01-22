import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        if (s == null) return;
        
        int n = s.length();
        int steps = 0;
        int carry = 0;
        
        for (int i = n - 1; i > 0; i--) {
            int digit = s.charAt(i) - '0';
            
            if (digit + carry == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps++;
            }
        }
        
        if (carry == 1) {
            steps++;
        }
        
        System.out.println(steps);
    }
}
