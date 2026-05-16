import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) return;
        s = s.trim();
        
        String kStr = br.readLine();
        if (kStr == null) return;
        int k = Integer.parseInt(kStr.trim());
        
        String[] pairs = new String[k];
        for (int i = 0; i < k; i++) {
            pairs[i] = br.readLine().trim();
        }
        
        int totalRemoved = 0;
        
        for (int i = 0; i < k; i++) {
            char x = pairs[i].charAt(0);
            char y = pairs[i].charAt(1);
            
            int countX = 0;
            int countY = 0;
            
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == x) {
                    countX++;
                } else if (c == y) {
                    countY++;
                } else {
                    totalRemoved += Math.min(countX, countY);
                    countX = 0;
                    countY = 0;
                }
            }
            totalRemoved += Math.min(countX, countY);
        }
        
        System.out.println(totalRemoved);
    }
}
