import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int c = n / k;
        
        int[] a = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        
        Set<String> knownCards = new HashSet<>();
        boolean[] used = new boolean[n + 1];
        
        double minKnownSum = Double.POSITIVE_INFINITY;
        double maxKnownSum = Double.NEGATIVE_INFINITY;
        
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int[] card = new int[c];
            double sum = 0;
            
            for (int j = 0; j < c; j++) {
                card[j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(card);
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < c; j++) {
                sb.append(card[j]).append(",");
                used[card[j]] = true;
                sum += a[card[j]];
            }
            
            String cardStr = sb.toString();
            if (!knownCards.contains(cardStr)) {
                knownCards.add(cardStr);
                minKnownSum = Math.min(minKnownSum, sum);
                maxKnownSum = Math.max(maxKnownSum, sum);
            }
        }
        
        double globalMinSum = minKnownSum;
        double globalMaxSum = maxKnownSum;
        
        if (knownCards.size() < k) {
            List<Integer> unused = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (!used[i]) {
                    unused.add(a[i]);
                }
            }
            
            Collections.sort(unused);
            
            double minUnknown = 0;
            for (int i = 0; i < c; i++) {
                minUnknown += unused.get(i);
            }
            
            double maxUnknown = 0;
            for (int i = 0; i < c; i++) {
                maxUnknown += unused.get(unused.size() - 1 - i);
            }
            
            globalMinSum = Math.min(globalMinSum, minUnknown);
            globalMaxSum = Math.max(globalMaxSum, maxUnknown);
        }
        
        System.out.printf(Locale.US, "%.10f %.10f\n", globalMinSum / c, globalMaxSum / c);
    }
}
