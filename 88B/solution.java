import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        List<Point>[] letterPositions = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            letterPositions[i] = new ArrayList<>();
        }
        List<Point> shifts = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = row.charAt(j);
                if (c == 'S') {
                    shifts.add(new Point(i, j));
                } else {
                    letterPositions[c - 'a'].add(new Point(i, j));
                }
            }
        }
        
        int q = Integer.parseInt(br.readLine());
        String text = br.readLine();
        
        boolean[] canTypeOneHand = new boolean[26];
        int xSq = x * x;
        
        for (int i = 0; i < 26; i++) {
            if (!letterPositions[i].isEmpty() && !shifts.isEmpty()) {
                boolean possible = false;
                searchLoop:
                for (Point p : letterPositions[i]) {
                    for (Point s : shifts) {
                        int dr = p.r - s.r;
                        int dc = p.c - s.c;
                        if (dr * dr + dc * dc <= xSq) {
                            possible = true;
                            break searchLoop;
                        }
                    }
                }
                canTypeOneHand[i] = possible;
            }
        }
        
        int otherHandCount = 0;
        
        for (int i = 0; i < q; i++) {
            char c = text.charAt(i);
            
            if (Character.isLowerCase(c)) {
                if (letterPositions[c - 'a'].isEmpty()) {
                    System.out.println("-1");
                    return;
                }
            } else {
                int idx = c - 'A';
                
                if (letterPositions[idx].isEmpty()) {
                    System.out.println("-1");
                    return;
                }
                if (shifts.isEmpty()) {
                    System.out.println("-1");
                    return;
                }
                
                if (!canTypeOneHand[idx]) {
                    otherHandCount++;
                }
            }
        }
        
        System.out.println(otherHandCount);
    }
}
