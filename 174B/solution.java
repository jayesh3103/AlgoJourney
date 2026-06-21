import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null || s.isEmpty()) return;
        
        List<Integer> dots = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                dots.add(i);
            }
        }
        
        if (dots.isEmpty()) {
            System.out.println("NO");
            return;
        }
        
        int firstDot = dots.get(0);
        if (firstDot < 1 || firstDot > 8) {
            System.out.println("NO");
            return;
        }
        
        int lastDot = dots.get(dots.size() - 1);
        int lastExtLen = s.length() - 1 - lastDot;
        if (lastExtLen < 1 || lastExtLen > 3) {
            System.out.println("NO");
            return;
        }
        
        for (int i = 0; i < dots.size() - 1; i++) {
            int l = dots.get(i + 1) - dots.get(i) - 1;
            if (l < 2 || l > 11) {
                System.out.println("NO");
                return;
            }
        }
        
        StringBuilder out = new StringBuilder();
        out.append("YES\n");
        
        int start = 0;
        for (int i = 0; i < dots.size() - 1; i++) {
            int curDot = dots.get(i);
            int l = dots.get(i + 1) - curDot - 1;
            int e = Math.min(3, l - 1);
            out.append(s, start, curDot + e + 1).append("\n");
            start = curDot + e + 1;
        }
        out.append(s, start, s.length()).append("\n");
        
        System.out.print(out.toString());
    }
}
