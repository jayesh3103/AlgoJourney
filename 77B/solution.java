import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line == null) break;

            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (b == 0) {
                out.println("1.0000000000");
            } else if (a == 0) {
                out.println("0.5000000000");
            } else {
                if (4L * b <= a) {
                    double ans = 1.0 - (double) b / a;
                    out.printf(Locale.US, "%.10f%n", ans);
                } else {
                    double ans = 0.5 + (double) a / (16.0 * b);
                    out.printf(Locale.US, "%.10f%n", ans);
                }
            }
        }
        out.flush();
    }
}
