import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            boolean[][] friends = new boolean[6][6];
            
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                friends[u][v] = true;
                friends[v][u] = true;
            }
            
            for (int i = 1; i <= 5; i++) {
                for (int j = i + 1; j <= 5; j++) {
                    for (int k = j + 1; k <= 5; k++) {
                        boolean allFriends = friends[i][j] && friends[j][k] && friends[i][k];
                        boolean noneFriends = !friends[i][j] && !friends[j][k] && !friends[i][k];
                        
                        if (allFriends || noneFriends) {
                            System.out.println("WIN");
                            return;
                        }
                    }
                }
            }
            
            System.out.println("FAIL");
        }
        scanner.close();
    }
}
