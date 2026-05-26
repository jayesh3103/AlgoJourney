import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int[] count = new int[5];
        
        for (int i = 0; i < n; i++) {
            count[sc.nextInt()]++;
        }
        
        sc.close();
        
        int taxis = count[4];
        
        taxis += count[3];
        count[1] = Math.max(0, count[1] - count[3]);
        
        taxis += count[2] / 2;
        if (count[2] % 2 != 0) {
            taxis++;
            count[1] = Math.max(0, count[1] - 2);
        }
        
        taxis += (count[1] + 3) / 4;
        
        System.out.println(taxis);
    }
}
