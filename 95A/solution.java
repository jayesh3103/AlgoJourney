import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNext()) return;
        int n = sc.nextInt();
        
        String[] forbidden = new String[n];
        for (int i = 0; i < n; i++) {
            forbidden[i] = sc.next();
        }
        
        String w = sc.next();
        String letterStr = sc.next();
        char luckyLower = letterStr.toLowerCase().charAt(0);
        
        boolean[] isCovered = new boolean[w.length()];
        String wLower = w.toLowerCase();
        
        for (String s : forbidden) {
            String sLower = s.toLowerCase();
            int start = 0;
            while (start < w.length()) {
                int idx = wLower.indexOf(sLower, start);
                if (idx == -1) break;
                
                for (int k = 0; k < s.length(); k++) {
                    isCovered[idx + k] = true;
                }
                
                start = idx + 1;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < w.length(); i++) {
            char original = w.charAt(i);
            
            if (!isCovered[i]) {
                result.append(original);
            } else {
                boolean isUpper = Character.isUpperCase(original);
                char candidateLucky = isUpper ? Character.toUpperCase(luckyLower) : luckyLower;
                
                if (candidateLucky != original) {
                    result.append(candidateLucky);
                } else {
                    char candidateA = isUpper ? 'A' : 'a';
                    
                    if (candidateA != original) {
                        result.append(candidateA);
                    } else {
                        char candidateB = isUpper ? 'B' : 'b';
                        result.append(candidateB);
                    }
                }
            }
        }
        
        System.out.println(result.toString());
    }
}
