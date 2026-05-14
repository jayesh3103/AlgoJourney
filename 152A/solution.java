import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] marks = new String[n];
        
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.next();
        }
        scanner.close();
        
        char[] maxMarks = new char[m];
        for (int j = 0; j < m; j++) {
            char max = '0';
            for (int i = 0; i < n; i++) {
                if (marks[i].charAt(j) > max) {
                    max = marks[i].charAt(j);
                }
            }
            maxMarks[j] = max;
        }
        
        int successfulStudents = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (marks[i].charAt(j) == maxMarks[j]) {
                    successfulStudents++;
                    break;
                }
            }
        }
        
        System.out.println(successfulStudents);
    }
}
