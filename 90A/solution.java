import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int r = scanner.nextInt();
            int g = scanner.nextInt();
            int b = scanner.nextInt();
            
            long tripsR = (r + 1) / 2;
            long tripsG = (g + 1) / 2;
            long tripsB = (b + 1) / 2;
            
            long maxTime = 0;
            
            if (tripsR > 0) {
                long timeR = (tripsR - 1) * 3 + 30;
                if (timeR > maxTime) maxTime = timeR;
            }
            
            if (tripsG > 0) {
                long timeG = (tripsG - 1) * 3 + 1 + 30;
                if (timeG > maxTime) maxTime = timeG;
            }
            
            if (tripsB > 0) {
                long timeB = (tripsB - 1) * 3 + 2 + 30;
                if (timeB > maxTime) maxTime = timeB;
            }
            
            System.out.println(maxTime);
        }
        scanner.close();
    }
}
