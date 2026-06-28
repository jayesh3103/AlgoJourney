import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int b = sc.nextInt();
        int d = sc.nextInt();
        
        int rem = b % d;
        int l2 = -1;
        for (int l = 1; l <= 100; l++) {
            if (rem == 0) {
                l2 = l;
                break;
            }
            rem = (rem * b) % d;
        }
        
        if (l2 != -1) {
            System.out.println("2-type");
            System.out.println(l2);
            return;
        }
        
        if ((b - 1) % d == 0) {
            System.out.println("3-type");
            return;
        }
        
        if ((b + 1) % d == 0) {
            System.out.println("11-type");
            return;
        }
        
        boolean is6 = true;
        int temp = d;
        for (int i = 2; i <= temp; i++) {
            if (temp % i == 0) {
                int pk = 1;
                while (temp % i == 0) {
                    pk *= i;
                    temp /= i;
                }
                if (!check2(b, pk) && (b - 1) % pk != 0 && (b + 1) % pk != 0) {
                    is6 = false;
                    break;
                }
            }
        }
        
        if (is6) {
            System.out.println("6-type");
            return;
        }
        
        System.out.println("7-type");
        sc.close();
    }
    
    static boolean check2(int b, int d) {
        int rem = b % d;
        for (int l = 1; l <= 100; l++) {
            if (rem == 0) return true;
            rem = (rem * b) % d;
        }
        return false;
    }
}
