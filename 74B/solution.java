import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();
        
        String dummy = fs.next();
        String dirString = fs.next();
        
        int cDir = dirString.equals("head") ? -1 : 1;
        String s = fs.next();
        
        int cPos = k;
        boolean[] possible = new boolean[n + 1];
        possible[m] = true;
        
        for (int i = 0; i < s.length(); i++) {
            char type = s.charAt(i);
            
            int cStart = cPos;
            int cEnd = cPos + cDir;
            
            int nextDir = cDir;
            if (cEnd == 1) nextDir = 1;
            else if (cEnd == n) nextDir = -1;
            
            if (type == '1') {
                if (i == s.length() - 1) {
                    System.out.println("Stowaway");
                    return;
                }
                
                Arrays.fill(possible, true);
                possible[0] = false;
                possible[cEnd] = false;
                
            } else {
                boolean[] nextPossible = new boolean[n + 1];
                boolean anySafe = false;
                
                for (int p = 1; p <= n; p++) {
                    if (possible[p]) {
                        for (int move = -1; move <= 1; move++) {
                            int nextP = p + move;
                            if (nextP >= 1 && nextP <= n) {
                                if (nextP != cStart && nextP != cEnd) {
                                    if (!nextPossible[nextP]) {
                                        nextPossible[nextP] = true;
                                        anySafe = true;
                                    }
                                }
                            }
                        }
                    }
                }
                
                possible = nextPossible;
                
                if (!anySafe) {
                    System.out.println("Controller " + (i + 1));
                    return;
                }
            }
            
            cPos = cEnd;
            cDir = nextDir;
        }
        
        System.out.println("Stowaway");
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
    }
}
