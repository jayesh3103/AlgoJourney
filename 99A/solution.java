import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int dotIndex = s.indexOf('.');
        String integerPart = s.substring(0, dotIndex);
        char firstFractionDigit = s.charAt(dotIndex + 1);
        char lastIntDigit = integerPart.charAt(integerPart.length() - 1);
        
        if (lastIntDigit == '9') {
            System.out.println("GOTO Vasilisa.");
        } else {
            if (firstFractionDigit < '5') {
                System.out.println(integerPart);
            } else {
                StringBuilder sb = new StringBuilder(integerPart);
                sb.setCharAt(sb.length() - 1, (char)(lastIntDigit + 1));
                System.out.println(sb.toString());
            }
        }
    }
}
