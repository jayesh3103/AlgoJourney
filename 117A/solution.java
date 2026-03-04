import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line);
        
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        
        long L = 2L * m - 2;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long f = Long.parseLong(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            
            if (s == f) {
                sb.append(t).append("\n");
                continue;
            }
            
            long B;
            if (s < f) {
                B = s - 1;
            } else {
                B = 2L * m - s - 1;
            }
            
            long currentCycleTime = t % L;
            long waitTime = (B - currentCycleTime + L) % L;
            
            long arriveTime = t + waitTime + Math.abs(s - f);
            sb.append(arriveTime).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
