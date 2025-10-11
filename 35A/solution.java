import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {
            
            int pos = in.nextInt();
 
            for (int i = 0; i < 3; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
 
                if (pos == a) {
                    pos = b;
                } else if (pos == b) {
                    pos = a;
                }
            }
 
            out.println(pos);
        }
    }
}
