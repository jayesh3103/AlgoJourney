import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String a = br.readLine();
        if (a == null || a.isEmpty()) return;
        String s = br.readLine();
        
        char[] aChars = a.toCharArray();
        char[] sChars = s.toCharArray();
        
        Arrays.sort(sChars);
        
        int sIndex = sChars.length - 1;
        
        for (int i = 0; i < aChars.length; i++) {
            if (sIndex >= 0 && sChars[sIndex] > aChars[i]) {
                aChars[i] = sChars[sIndex];
                sIndex--;
            }
        }
        
        System.out.println(new String(aChars));
    }
}
