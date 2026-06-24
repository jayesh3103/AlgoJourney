import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        Map<String, Integer> playerMaxScores = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            playerMaxScores.put(name, Math.max(playerMaxScores.getOrDefault(name, 0), score));
        }
        
        int m = playerMaxScores.size();
        System.out.println(m);
        
        List<Integer> allScores = new ArrayList<>(playerMaxScores.values());
        
        for (Map.Entry<String, Integer> entry : playerMaxScores.entrySet()) {
            String name = entry.getKey();
            int score = entry.getValue();
            
            int betterCount = 0;
            for (int s : allScores) {
                if (s > score) {
                    betterCount++;
                }
            }
            
            String category;
            if (betterCount * 2 > m) {
                category = "noob";
            } else if (betterCount * 5 > m) {
                category = "random";
            } else if (betterCount * 10 > m) {
                category = "average";
            } else if (betterCount * 100 > m) {
                category = "hardcore";
            } else {
                category = "pro";
            }
            
            System.out.println(name + " " + category);
        }
        
        sc.close();
    }
}
