import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        char[] stack = new char[s.length()];
        int top = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (top >= 0 && stack[top] == c) {
                top--;
            } else {
                stack[++top] = c;
            }
        }
        
        System.out.println(new String(stack, 0, top + 1));
    }
}
