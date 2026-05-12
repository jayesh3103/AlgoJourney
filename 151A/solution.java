import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int nl = sc.nextInt();
        int np = sc.nextInt();
        sc.close();
        
        int toastsFromDrink = (k * l) / nl;
        int toastsFromLimes = c * d;
        int toastsFromSalt = p / np;
        
        int totalToasts = Math.min(toastsFromDrink, Math.min(toastsFromLimes, toastsFromSalt));
        
        System.out.println(totalToasts / n);
    }
}
