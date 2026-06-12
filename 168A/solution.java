import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int required = (n * y + 99) / 100;
        int clones = Math.max(0, required - x);
        
        System.out.println(clones);
        sc.close();
    }
}
