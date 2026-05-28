import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        if (line == null) return;
        
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] markerDC = new int[1001][1001];
        int[] markerD = new int[1001];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            markerDC[d][c]++;
            markerD[d]++;
        }

        int[][] capDC = new int[1001][1001];
        int[] capD = new int[1001];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            capDC[d][c]++;
            capD[d]++;
        }

        int totalClosed = 0;
        int beautifulClosed = 0;

        for (int d = 1; d <= 1000; d++) {
            totalClosed += Math.min(markerD[d], capD[d]);
            
            for (int c = 1; c <= 1000; c++) {
                beautifulClosed += Math.min(markerDC[d][c], capDC[d][c]);
            }
        }

        System.out.println(totalClosed + " " + beautifulClosed);
    }
}
