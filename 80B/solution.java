import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String time = br.readLine();
        if (time == null) return;
        
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        
        double hourAngle = (h % 12) * 30.0 + m * 0.5;
        double minuteAngle = m * 6.0;
        
        System.out.println(hourAngle + " " + minuteAngle);
    }
}
