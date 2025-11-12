import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();
            int c = in.nextInt();
            
            int[] holidays = new int[n + 1];
            for (int i = 0; i < c; i++) {
                holidays[in.nextInt()] = 1;
            }
            
            int presents = 0;
            int lastDay = 0; 
            
            for (int day = 1; day <= n; day++) {
                if (holidays[day] == 1) {
                    presents++;
                    lastDay = day;
                } else if (day - lastDay == k) {
                    presents++;
                    lastDay = day;
                }
            }
            
            System.out.println(presents);
        }
    }
}
