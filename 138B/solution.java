import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) return;
        s = s.trim();
        int n = s.length();
        
        int[] C = new int[10];
        for (int i = 0; i < n; i++) {
            C[s.charAt(i) - '0']++;
        }

        int best_zeros = C[0];
        int best_x = -1;
        int best_k = C[0];

        for (int x = 1; x <= 9; x++) {
            if (C[x] == 0 || C[10 - x] == 0) continue;
            
            int[] CA = Arrays.copyOf(C, 10);
            int[] CB = Arrays.copyOf(C, 10);
            
            CA[x]--; 
            CB[10 - x]--;
            
            int limit = Math.min(CA[0], CB[0]);
            for (int k = 0; k <= limit; k++) {
                int zeros = 1 + k;
                zeros += Math.min(CA[0] - k, CB[9]);
                zeros += Math.min(CA[9], CB[0] - k);
                for (int a = 1; a <= 8; a++) {
                    zeros += Math.min(CA[a], CB[9 - a]);
                }
                
                if (zeros > best_zeros) {
                    best_zeros = zeros;
                    best_x = x;
                    best_k = k;
                }
            }
        }

        int[] CA = Arrays.copyOf(C, 10);
        int[] CB = Arrays.copyOf(C, 10);
        char[] A = new char[n];
        char[] B = new char[n];
        int idx = n - 1;

        if (best_x != -1) {
            for (int i = 0; i < best_k; i++) {
                A[idx] = '0'; B[idx] = '0'; idx--;
                CA[0]--; CB[0]--;
            }
            
            A[idx] = (char)('0' + best_x);
            B[idx] = (char)('0' + 10 - best_x);
            CA[best_x]--; CB[10 - best_x]--;
            idx--;
            
            int p09 = Math.min(CA[0], CB[9]);
            for (int i = 0; i < p09; i++) { A[idx] = '0'; B[idx] = '9'; idx--; }
            CA[0] -= p09; CB[9] -= p09;
            
            int p90 = Math.min(CA[9], CB[0]);
            for (int i = 0; i < p90; i++) { A[idx] = '9'; B[idx] = '0'; idx--; }
            CA[9] -= p90; CB[0] -= p90;
            
            for (int a = 1; a <= 8; a++) {
                int pa = Math.min(CA[a], CB[9 - a]);
                for (int i = 0; i < pa; i++) { A[idx] = (char)('0' + a); B[idx] = (char)('0' + 9 - a); idx--; }
                CA[a] -= pa; CB[9 - a] -= pa;
            }
        } else {
            for (int i = 0; i < best_k; i++) {
                A[idx] = '0'; B[idx] = '0'; idx--;
                CA[0]--; CB[0]--;
            }
        }

        int a_ptr = 0, b_ptr = 0;
        while (idx >= 0) {
            while (a_ptr <= 9 && CA[a_ptr] == 0) a_ptr++;
            while (b_ptr <= 9 && CB[b_ptr] == 0) b_ptr++;
            A[idx] = (char)('0' + a_ptr);
            B[idx] = (char)('0' + b_ptr);
            CA[a_ptr]--; CB[b_ptr]--;
            idx--;
        }

        System.out.println(new String(A));
        System.out.println(new String(B));
    }
}
