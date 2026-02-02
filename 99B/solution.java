import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] cups = new int[n];
            long sum = 0;
            
            for (int i = 0; i < n; i++) {
                cups[i] = sc.nextInt();
                sum += cups[i];
            }
            
            if (sum % n != 0) {
                System.out.println("Unrecoverable configuration.");
                return;
            }
            
            int target = (int) (sum / n);
            ArrayList<Integer> diffIndices = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                if (cups[i] != target) {
                    diffIndices.add(i);
                }
            }
            
            if (diffIndices.isEmpty()) {
                System.out.println("Exemplary pages.");
            } else if (diffIndices.size() == 2) {
                int idx1 = diffIndices.get(0);
                int idx2 = diffIndices.get(1);
                
                int val1 = cups[idx1];
                
                int sourceIdx, destIdx, amount;
                
                if (val1 < target) {
                    sourceIdx = idx1 + 1;
                    destIdx = idx2 + 1;
                    amount = target - val1;
                } else {
                    sourceIdx = idx2 + 1;
                    destIdx = idx1 + 1;
                    amount = val1 - target;
                }
                
                System.out.println(amount + " ml. from cup #" + sourceIdx + " to cup #" + destIdx + ".");
            } else {
                System.out.println("Unrecoverable configuration.");
            }
        }
    }
}
