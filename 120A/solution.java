import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        
        String door = br.readLine().trim();
        int rail = Integer.parseInt(br.readLine().trim());
        
        if (door.equals("front")) {
            if (rail == 1) {
                pw.println("L");
            } else {
                pw.println("R");
            }
        } else if (door.equals("back")) {
            if (rail == 1) {
                pw.println("R");
            } else {
                pw.println("L");
            }
        }
        
        pw.close();
        br.close();
    }
}
