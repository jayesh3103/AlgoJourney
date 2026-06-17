import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        
        int[] pos = new int[m];
        Arrays.fill(pos, -1);
        
        pos[r] = 0;
        int i = 1;
        
        while (true) {
            r = (a * r + b) % m;
            
            if (pos[r] != -1) {
                System.out.println(i - pos[r]);
                break;
            }
            
            pos[r] = i;
            i++;
        }
        
        sc.close();
    }
}
