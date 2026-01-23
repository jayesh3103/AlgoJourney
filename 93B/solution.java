import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EndOfExams {
    static class Pour {
        int bottleIndex;
        double amount;

        public Pour(int bottleIndex, double amount) {
            this.bottleIndex = bottleIndex;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        
        int n = fs.nextInt();
        int w = fs.nextInt();
        int m = fs.nextInt();

        double totalVolume = (double) n * w;
        double targetPerCup = totalVolume / m;

        List<List<Pour>> cupPours = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            cupPours.add(new ArrayList<>());
        }

        int currentBottleIndex = 1; 
        double currentBottleRemaining = w;
        int[] bottleUsageCount = new int[n + 1];

        for (int i = 0; i < m; i++) {
            double spaceInCup = targetPerCup;

            while (spaceInCup > 1e-9) {
                if (currentBottleRemaining < 1e-9) {
                    currentBottleIndex++;
                    currentBottleRemaining = w;
                }

                double pourAmount = Math.min(spaceInCup, currentBottleRemaining);

                cupPours.get(i).add(new Pour(currentBottleIndex, pourAmount));
                
                bottleUsageCount[currentBottleIndex]++;
                spaceInCup -= pourAmount;
                currentBottleRemaining -= pourAmount;
            }
        }

        boolean possible = true;
        for (int b = 1; b <= n; b++) {
            if (bottleUsageCount[b] > 2) {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println("YES");
            for (List<Pour> pours : cupPours) {
                StringBuilder sb = new StringBuilder();
                for (Pour p : pours) {
                    sb.append(p.bottleIndex)
                      .append(" ")
                      .append(String.format("%.6f", p.amount))
                      .append(" ");
                }
                System.out.println(sb.toString().trim());
            }
        } else {
            System.out.println("NO");
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
