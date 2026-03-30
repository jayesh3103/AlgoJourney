import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int k;
    static char[] s;
    static int n;
    static String answer = null;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str == null) return;
        
        s = str.toCharArray();
        n = s.length;
        k = Integer.parseInt(br.readLine().trim());
        
        long total = (long) n * (n + 1) / 2;
        if (k > total) {
            System.out.println("No such line.");
            return;
        }
        
        int[] initial_count = new int[26];
        for (int i = 0; i < n; i++) {
            initial_count[s[i] - 'a']++;
        }
        
        int[] initial_indices = new int[n];
        int[] offset = new int[26];
        int[] start = new int[26];
        int curr = 0;
        
        for (int c = 0; c < 26; c++) {
            start[c] = curr;
            offset[c] = curr;
            curr += initial_count[c];
        }
        
        for (int i = 0; i < n; i++) {
            initial_indices[offset[s[i] - 'a']++] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < 26; c++) {
            if (initial_count[c] > 0) {
                sb.append((char)('a' + c));
                if (dfs(initial_indices, start[c], offset[c], sb)) {
                    System.out.println(answer);
                    return;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    
    static boolean dfs(int[] indices, int left, int right, StringBuilder current_string) {
        k -= (right - left);
        if (k <= 0) {
            answer = current_string.toString();
            return true;
        }
        
        int[] count = new int[26];
        int total_next = 0;
        
        for (int i = left; i < right; i++) {
            int idx = indices[i];
            if (idx + 1 < n) {
                count[s[idx + 1] - 'a']++;
                total_next++;
            }
        }
        
        if (total_next == 0) return false;
        
        int[] next_indices = new int[total_next];
        int[] offset = new int[26];
        int[] start = new int[26];
        int curr = 0;
        
        for (int c = 0; c < 26; c++) {
            start[c] = curr;
            offset[c] = curr;
            curr += count[c];
        }
        
        for (int i = left; i < right; i++) {
            int idx = indices[i];
            if (idx + 1 < n) {
                int c = s[idx + 1] - 'a';
                next_indices[offset[c]++] = idx + 1;
            }
        }
        
        for (int c = 0; c < 26; c++) {
            if (count[c] > 0) {
                current_string.append((char)('a' + c));
                if (dfs(next_indices, start[c], offset[c], current_string)) return true;
                current_string.deleteCharAt(current_string.length() - 1);
            }
        }
        return false;
    }
}
