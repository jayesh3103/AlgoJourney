import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] rowAdj = new ArrayList[n];
        for (int i = 0; i < n; i++) rowAdj[i] = new ArrayList<>();
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] colAdj = new ArrayList[m];
        for (int i = 0; i < m; i++) colAdj[i] = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '#') {
                    rowAdj[i].add(j);
                    colAdj[j].add(i);
                }
            }
        }
        
        int[] dist = new int[n + m];
        Arrays.fill(dist, -1);
        
        dist[n - 1] = 0; 
        
        int[] q = new int[n + m];
        int head = 0, tail = 0;
        
        q[tail++] = n - 1;
        
        while (head < tail) {
            int u = q[head++];
            
            if (u == 0) {
                System.out.println(dist[0]);
                return;
            }
            
            if (u < n) {
                for (int c : rowAdj[u]) {
                    if (dist[n + c] == -1) {
                        dist[n + c] = dist[u] + 1;
                        q[tail++] = n + c;
                    }
                }
            } else {
                int c = u - n;
                for (int r : colAdj[c]) {
                    if (dist[r] == -1) {
                        dist[r] = dist[u] + 1;
                        q[tail++] = r;
                    }
                }
            }
        }
        
        System.out.println(-1);
    }
}
