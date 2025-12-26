import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        int[] wasteR = new int[k];
        int[] wasteC = new int[k];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            wasteR[i] = Integer.parseInt(st.nextToken());
            wasteC[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            boolean isWaste = false;
            int wasteCount = 0;
            
            for (int i = 0; i < k; i++) {
                if (wasteR[i] == r && wasteC[i] == c) {
                    isWaste = true;
                    break;
                }
                
                if (wasteR[i] < r || (wasteR[i] == r && wasteC[i] < c)) {
                    wasteCount++;
                }
            }
            
            if (isWaste) {
                sb.append("Waste\n");
            } else {
                int linearPos = (r - 1) * m + c;
                int effectiveIndex = linearPos - wasteCount;
                int type = effectiveIndex % 3;
                
                if (type == 1) sb.append("Carrots\n");
                else if (type == 2) sb.append("Kiwis\n");
                else sb.append("Grapes\n");
            }
        }
        
        System.out.print(sb);
    }
}
