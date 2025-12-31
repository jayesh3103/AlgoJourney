import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Token {
        String content;
        boolean hasSpaceBefore;
        int type;

        Token(String content, boolean hasSpaceBefore, int type) {
            this.content = content;
            this.hasSpaceBefore = hasSpaceBefore;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) return;

        List<Token> tokens = new ArrayList<>();
        int n = s.length();
        int i = 0;

        while (i < n) {
            boolean spaceFound = false;
            while (i < n && s.charAt(i) == ' ') {
                spaceFound = true;
                i++;
            }
            if (i >= n) break;

            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                tokens.add(new Token(sb.toString(), spaceFound, 0));
            } else if (c == ',') {
                tokens.add(new Token(",", spaceFound, 1));
                i++;
            } else if (c == '.') {
                tokens.add(new Token("...", spaceFound, 2));
                i += 3;
            }
        }

        StringBuilder out = new StringBuilder();
        for (int k = 0; k < tokens.size(); k++) {
            Token curr = tokens.get(k);
            
            if (k > 0) {
                Token prev = tokens.get(k - 1);
                boolean addSpace = false;

                if (prev.type == 1) {
                    addSpace = true;
                }

                if (curr.type == 2) {
                    addSpace = true;
                }

                if (prev.type == 0 && curr.type == 0 && curr.hasSpaceBefore) {
                    addSpace = true;
                }

                if (addSpace) {
                    out.append(' ');
                }
            }
            out.append(curr.content);
        }

        System.out.println(out.toString());
    }
}
