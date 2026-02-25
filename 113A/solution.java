import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        if (line == null || line.trim().isEmpty()) {
            System.out.println("NO");
            return;
        }
        
        StringTokenizer st = new StringTokenizer(line);
        int n = st.countTokens();
        
        if (n == 0) {
            System.out.println("NO");
            return;
        }
        
        int expectedGender = -1;
        int nounCount = 0;
        int prevType = 0;
        
        for (int i = 0; i < n; i++) {
            String w = st.nextToken();
            int[] info = getWordInfo(w);
            
            if (info == null) {
                System.out.println("NO");
                return;
            }
            
            if (n == 1) {
                System.out.println("YES");
                return;
            }
            
            int gender = info[0];
            int type = info[1];
            
            if (expectedGender == -1) {
                expectedGender = gender;
            } else if (expectedGender != gender) {
                System.out.println("NO");
                return;
            }
            
            if (type < prevType) {
                System.out.println("NO");
                return;
            }
            
            if (type == 2) {
                nounCount++;
            }
            
            prevType = type;
        }
        
        if (n > 1 && nounCount != 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
    
    private static int[] getWordInfo(String w) {
        if (w.endsWith("initis")) return new int[]{0, 3};
        if (w.endsWith("inites")) return new int[]{1, 3};
        if (w.endsWith("liala")) return new int[]{1, 1};
        if (w.endsWith("etra")) return new int[]{1, 2};
        if (w.endsWith("lios")) return new int[]{0, 1};
        if (w.endsWith("etr")) return new int[]{0, 2};
        
        return null;
    }
}
