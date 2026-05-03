import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        
        if (text != null) {
            text = text.replaceAll("\\s+", " ");
            text = text.replaceAll(" ([.,!?])", "$1");
            text = text.replaceAll("([.,!?])([^ ])", "$1 $2");
            
            System.out.println(text.trim());
        }
    }
}
