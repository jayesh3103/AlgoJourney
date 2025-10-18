import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int target = 1;
        List<Integer> years = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int income = in.nextInt();
            int year = 2001 + i;

            if (income == target) {
                years.add(year);
                target++;
            }
        }

        System.out.println(years.size());
        
        if (!years.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < years.size(); i++) {
                sb.append(years.get(i));
                if (i < years.size() - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
        
        in.close();
    }
}
