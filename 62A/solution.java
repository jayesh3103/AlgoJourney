import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int al = sc.nextInt();
        int ar = sc.nextInt();
        int bl = sc.nextInt();
        int br = sc.nextInt();
        
        if (check(al, br) || check(ar, bl)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    
    static boolean check(int g, int b) {
        return g <= b + 1 && b <= 2 * g + 2;
    }
}
