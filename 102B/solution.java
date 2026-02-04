import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        if (s.length() == 1) {
            System.out.println(0);
            return;
        }
        
        int currentSum = 0;
        for (int i = 0; i < s.length(); i++) {
            currentSum += s.charAt(i) - '0';
        }
        
        int count = 1;
        
        while (currentSum >= 10) {
            int nextSum = 0;
            int temp = currentSum;
            
            while (temp > 0) {
                nextSum += temp % 10;
                temp /= 10;
            }
            
            currentSum = nextSum;
            count++;
        }
        
        System.out.println(count);
    }
}
