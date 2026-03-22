import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNext()) {
            String s = sc.next();
            int depth = 0;
            
            for (int i = 0; i < s.length(); ) {
                if (s.charAt(i + 1) == '/') {
                    depth--;
                    printIndent(depth);
                    System.out.println(s.substring(i, i + 4));
                    i += 4;
                } else {
                    printIndent(depth);
                    System.out.println(s.substring(i, i + 3));
                    depth++;
                    i += 3;
                }
            }
        }
        
        sc.close();
    }
    
    static void printIndent(int depth) {
        for (int i = 0; i < depth * 2; i++) {
            System.out.print(" ");
        }
    }
}
