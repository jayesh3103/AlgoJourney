import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        
        long totalMagicalSubarrays = 0;
        long currentLength = 1;
        
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                currentLength++;
            } else {
                totalMagicalSubarrays += (currentLength * (currentLength + 1)) / 2;
                currentLength = 1;
            }
        }
        
        totalMagicalSubarrays += (currentLength * (currentLength + 1)) / 2;
        
        System.out.println(totalMagicalSubarrays);
    }
}
