import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        if (!sc.hasMore()) return;
        
        int n = sc.nextInt();
        
        if (n == 2) {
            int k = sc.nextInt();
            int[] nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = sc.nextInt();
            }
            
            System.out.println("1 " + nums[0]);
            
            System.out.print((k - 1));
            for (int i = 1; i < k; i++) {
                System.out.print(" " + nums[i]);
            }
            System.out.println();
            return;
        }

        int totalLines = n * (n - 1) / 2;
        Map<Integer, List<Integer>> occurrences = new HashMap<>();

        for (int lineIdx = 0; lineIdx < totalLines; lineIdx++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int val = sc.nextInt();
                occurrences.putIfAbsent(val, new ArrayList<>());
                occurrences.get(val).add(lineIdx);
            }
        }

        Map<List<Integer>, List<Integer>> recoveredSets = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : occurrences.entrySet()) {
            int number = entry.getKey();
            List<Integer> signature = entry.getValue();
            
            recoveredSets.putIfAbsent(signature, new ArrayList<>());
            recoveredSets.get(signature).add(number);
        }

        StringBuilder sb = new StringBuilder();
        for (List<Integer> setContents : recoveredSets.values()) {
            sb.append(setContents.size());
            for (int num : setContents) {
                sb.append(" ").append(num);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        boolean hasMore() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return false;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return false;
                }
            }
            return true;
        }

        String next() {
            if (hasMore()) return st.nextToken();
            return null;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
