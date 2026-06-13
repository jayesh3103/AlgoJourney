import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line;
        boolean in_common_block = false;
        
        while ((line = br.readLine()) != null) {
            boolean is_amp = false;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c != ' ') {
                    if (c == '#') {
                        is_amp = true;
                    }
                    break;
                }
            }
            
            if (is_amp) {
                if (in_common_block) {
                    bw.write('\n');
                    in_common_block = false;
                }
                bw.write(line);
                bw.write('\n');
            } else {
                in_common_block = true;
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c != ' ') {
                        bw.write(c);
                    }
                }
            }
        }
        if (in_common_block) {
            bw.write('\n');
        }
        bw.flush();
    }
}
