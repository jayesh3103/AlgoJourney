import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String line = br.readLine();
        
        if (line == null) return;
        
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] minPrime = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (minPrime[i] == 0) {
                for (int j = i; j <= n; j += i) {
                    if (minPrime[j] == 0) {
                        minPrime[j] = i;
                    }
                }
            }
        }
        
        boolean[] active = new boolean[n + 1];
        int[] factorUsed = new int[n + 1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);
            int x = Integer.parseInt(st.nextToken());
            
            if (op == '+') {
                if (active[x]) {
                    pw.println("Already on");
                } else {
                    int temp = x;
                    int conflict = 0;
                    while (temp > 1) {
                        int p = minPrime[temp];
                        if (factorUsed[p] != 0) {
                            conflict = factorUsed[p];
                            break;
                        }
                        while (temp % p == 0) temp /= p;
                    }
                    
                    if (conflict != 0) {
                        pw.println("Conflict with " + conflict);
                    } else {
                        active[x] = true;
                        temp = x;
                        while (temp > 1) {
                            int p = minPrime[temp];
                            factorUsed[p] = x;
                            while (temp % p == 0) temp /= p;
                        }
                        pw.println("Success");
                    }
                }
            } else if (op == '-') {
                if (!active[x]) {
                    pw.println("Already off");
                } else {
                    active[x] = false;
                    int temp = x;
                    while (temp > 1) {
                        int p = minPrime[temp];
                        factorUsed[p] = 0;
                        while (temp % p == 0) temp /= p;
                    }
                    pw.println("Success");
                }
            }
        }
        
        pw.flush();
        pw.close();
        br.close();
    }
}
