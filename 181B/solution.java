import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int n = Integer.parseInt(line.trim());
        
        int[] x = new int[n];
        int[] y = new int[n];
        boolean[][] present = new boolean[2005][2005];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken()) + 1000;
            y[i] = Integer.parseInt(st.nextToken()) + 1000;
            present[x[i]][y[i]] = true;
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sumX = x[i] + x[j];
                int sumY = y[i] + y[j];
                
                if (sumX % 2 == 0 && sumY % 2 == 0) {
                    if (present[sumX / 2][sumY / 2]) {
                        count++;
                    }
                }
            }
        }
        
        System.out.println(count);
    }
}
