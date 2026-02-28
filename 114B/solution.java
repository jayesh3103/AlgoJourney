import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                names[i] = sc.next();
            }
            
            Arrays.sort(names);
            
            HashMap<String, Integer> nameToId = new HashMap<>();
            for (int i = 0; i < n; i++) {
                nameToId.put(names[i], i);
            }
            
            int[] conflictMask = new int[n];
            for (int i = 0; i < m; i++) {
                String u = sc.next();
                String v = sc.next();
                int idU = nameToId.get(u);
                int idV = nameToId.get(v);
                
                conflictMask[idU] |= (1 << idV);
                conflictMask[idV] |= (1 << idU);
            }
            
            int bestMask = 0;
            int maxSize = 0;
            int totalCombinations = 1 << n; 
            
            for (int mask = 0; mask < totalCombinations; mask++) {
                boolean valid = true;
                
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        if ((mask & conflictMask[i]) != 0) {
                            valid = false;
                            break;
                        }
                    }
                }
                
                if (valid) {
                    int size = Integer.bitCount(mask);
                    if (size > maxSize) {
                        maxSize = size;
                        bestMask = mask;
                    }
                }
            }
            
            System.out.println(maxSize);
            for (int i = 0; i < n; i++) {
                if ((bestMask & (1 << i)) != 0) {
                    System.out.println(names[i]);
                }
            }
        }
        
        sc.close();
    }
}
