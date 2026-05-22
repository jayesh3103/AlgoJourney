import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        String[] parts = line.trim().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int[] a = new int[n + 1];
        int[] pos = new int[n + 1];
        int[] neg = new int[n + 1];
        int totalNeg = 0;

        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            a[i] = x;
            if (x > 0) {
                pos[x]++;
            } else {
                neg[-x]++;
                totalNeg++;
            }
        }

        boolean[] canBe = new boolean[n + 1];
        int possibleCount = 0;

        for (int i = 1; i <= n; i++) {
            if (pos[i] + totalNeg - neg[i] == m) {
                canBe[i] = true;
                possibleCount++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int statement = a[i];
            if (statement > 0) {
                if (!canBe[statement]) {
                    sb.append("Lie\n");
                } else {
                    if (possibleCount == 1) {
                        sb.append("Truth\n");
                    } else {
                        sb.append("Not defined\n");
                    }
                }
            } else {
                int x = -statement;
                if (!canBe[x]) {
                    sb.append("Truth\n");
                } else {
                    if (possibleCount == 1) {
                        sb.append("Lie\n");
                    } else {
                        sb.append("Not defined\n");
                    }
                }
            }
        }
        System.out.print(sb.toString());
    }
}
