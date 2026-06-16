import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int n = Integer.parseInt(line.trim());
        String first = br.readLine();
        int prefixLen = first.length();
        
        for (int i = 1; i < n; i++) {
            String current = br.readLine();
            int j = 0;
            while (j < prefixLen && j < current.length() && first.charAt(j) == current.charAt(j)) {
                j++;
            }
            prefixLen = j;
            if (prefixLen == 0) {
                break;
            }
        }
        
        System.out.println(prefixLen);
    }
}
