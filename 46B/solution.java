import java.util.Scanner;

public class Main {
    
    static int[] counts = new int[5];

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            
            for (int i = 0; i < 5; i++) {
                counts[i] = in.nextInt();
            }
            
            int k = in.nextInt();
            
            for (int i = 0; i < k; i++) {
                String s = in.next();
                int idx = 0;
                
                if (s.equals("M")) idx = 1;
                else if (s.equals("L")) idx = 2;
                else if (s.equals("XL")) idx = 3;
                else if (s.equals("XXL")) idx = 4;
                
                System.out.println(findShirt(idx));
            }
        }
    }

    private static String findShirt(int idx) {
        for (int dist = 0; dist < 5; dist++) {
            int high = idx + dist;
            int low = idx - dist;
            
            if (high < 5 && counts[high] > 0) {
                counts[high]--;
                return toSize(high);
            }
            if (low >= 0 && low != high && counts[low] > 0) {
                counts[low]--;
                return toSize(low);
            }
        }
        return ""; 
    }

    private static String toSize(int idx) {
        if (idx == 0) return "S";
        if (idx == 1) return "M";
        if (idx == 2) return "L";
        if (idx == 3) return "XL";
        return "XXL";
    }
}
