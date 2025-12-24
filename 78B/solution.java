import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());
        
        StringBuilder sb = new StringBuilder();
        
        String base = "ROYGBIV";
        String cycle = "GBIV";
        
        sb.append(base);
        
        for (int i = 7; i < n; i++) {
            sb.append(cycle.charAt((i - 7) % 4));
        }
        
        System.out.println(sb.toString());
    }
}
