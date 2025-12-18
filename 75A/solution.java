import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a + b;
        
        int aa = removeZeros(a);
        int bb = removeZeros(b);
        int cc = removeZeros(c);
        
        if (aa + bb == cc) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    
    public static int removeZeros(int n) {
        String s = String.valueOf(n);
        String res = s.replace("0", "");
        return Integer.parseInt(res);
    }
}
