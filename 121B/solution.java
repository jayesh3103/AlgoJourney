import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        char[] s = br.readLine().toCharArray();
        
        for (int i = 0; i < n - 1 && k > 0; ) {
            if (s[i] == '4' && s[i + 1] == '7') {
                if (i % 2 == 0) {
                    s[i + 1] = '4';
                    k--;
                    i++; 
                } else {
                    if (i > 0 && s[i - 1] == '4') {
                        if (k % 2 == 1) {
                            s[i] = '7';
                        }
                        break; 
                    } else {
                        s[i] = '7';
                        k--;
                        i--; 
                    }
                }
            } else {
                i++;
            }
        }
        
        System.out.println(new String(s));
    }
}
