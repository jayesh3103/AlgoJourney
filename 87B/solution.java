import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        
        Map<String, Integer> types = new HashMap<>();
        types.put("void", 0);
        types.put("errtype", -1);
        
        for (int i = 0; i < n; i++) {
            String op = sc.next();
            if (op.equals("typedef")) {
                String typeExpr = sc.next();
                String newName = sc.next();
                
                int val = evaluateType(typeExpr, types);
                types.put(newName, val);
            } else {
                String typeExpr = sc.next();
                
                int val = evaluateType(typeExpr, types);
                if (val == -1) {
                    System.out.println("errtype");
                } else {
                    System.out.print("void");
                    for (int k = 0; k < val; k++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }
        sc.close();
    }
    
    private static int evaluateType(String expr, Map<String, Integer> types) {
        int amps = 0;
        int stars = 0;
        int len = expr.length();
        
        int l = 0;
        while (l < len && expr.charAt(l) == '&') {
            amps++;
            l++;
        }
        
        int r = len - 1;
        while (r >= 0 && expr.charAt(r) == '*') {
            stars++;
            r--;
        }
        
        if (l > r) return -1;
        String baseName = expr.substring(l, r + 1);
        
        if (!types.containsKey(baseName)) {
            return -1;
        }
        
        int baseVal = types.get(baseName);
        
        if (baseVal == -1) {
            return -1;
        }
        
        int currentVal = baseVal + stars;
        
        if (currentVal < amps) {
            return -1;
        }
        
        return currentVal - amps;
    }
}
