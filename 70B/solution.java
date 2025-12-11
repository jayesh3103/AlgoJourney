import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String line1 = reader.readLine();
        if (line1 == null) return;
        int n = Integer.parseInt(line1);
        
        String text = reader.readLine();
        if (text == null) return;
        
        int ans = 0;
        int currentLen = 0;
        int lastStart = 0;
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            
            if (c == '.' || c == '?' || c == '!') {
                int len = i - lastStart + 1;
                
                if (len > n) {
                    System.out.println("Impossible");
                    return;
                }
                
                if (ans == 0) {
                    ans = 1;
                    currentLen = len;
                } else {
                    if (currentLen + 1 + len <= n) {
                        currentLen += 1 + len;
                    } else {
                        ans++;
                        currentLen = len;
                    }
                }
                
                lastStart = i + 2;
                i++;
            }
        }
        
        System.out.println(ans);
    }
}
