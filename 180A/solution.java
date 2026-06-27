import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] disk = new int[n + 1];
        int[] pos = new int[n + 1];
        
        int target = 1;
        
        for (int i = 0; i < m; i++) {
            int count = sc.nextInt();
            for (int j = 0; j < count; j++) {
                int c = sc.nextInt();
                disk[c] = target;
                pos[target] = c;
                target++;
            }
        }
        
        int S = target - 1;
        List<String> moves = new ArrayList<>();
        
        while (true) {
            boolean moved = false;
            
            for (int i = 1; i <= S; i++) {
                if (disk[i] == 0 && pos[i] != i) {
                    moves.add(pos[i] + " " + i);
                    disk[i] = i;
                    disk[pos[i]] = 0;
                    pos[i] = i;
                    moved = true;
                    break;
                }
            }
            
            if (moved) continue;
            
            int misplacedTarget = -1;
            for (int i = 1; i <= S; i++) {
                if (pos[i] != i) {
                    misplacedTarget = i;
                    break;
                }
            }
            
            if (misplacedTarget == -1) break; 
            
            int emptyCluster = -1;
            for (int i = 1; i <= n; i++) {
                if (disk[i] == 0) {
                    emptyCluster = i;
                    break;
                }
            }
            
            int itemToMove = disk[misplacedTarget];
            moves.add(misplacedTarget + " " + emptyCluster);
            disk[emptyCluster] = itemToMove;
            pos[itemToMove] = emptyCluster;
            disk[misplacedTarget] = 0;
        }
        
        System.out.println(moves.size());
        for (String move : moves) {
            System.out.println(move);
        }
        
        sc.close();
    }
}
