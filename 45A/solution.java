import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
            };
            
            String s = in.next();
            int k = in.nextInt();
            
            int start = 0;
            for (int i = 0; i < 12; i++) {
                if (months[i].equals(s)) {
                    start = i;
                    break;
                }
            }
            
            int end = (start + k) % 12;
            System.out.println(months[end]);
        }
    }
}
