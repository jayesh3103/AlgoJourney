import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNext()) return;
        
        String myName = sc.next();
        int n = sc.nextInt();
        sc.nextLine(); 
        
        Map<String, Integer> scores = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            
            String name1 = parts[0];
            String name2Raw = "";
            int points = 0;
            
            if (parts[1].equals("posted")) {
                name2Raw = parts[3];
                points = 15;
            } else if (parts[1].equals("commented")) {
                name2Raw = parts[3];
                points = 10;
            } else if (parts[1].equals("likes")) {
                name2Raw = parts[2];
                points = 5;
            }
            
            String name2 = name2Raw.substring(0, name2Raw.length() - 2);
            
            scores.putIfAbsent(name1, 0);
            scores.putIfAbsent(name2, 0);
            
            if (name1.equals(myName)) {
                scores.put(name2, scores.get(name2) + points);
            }
            
            if (name2.equals(myName)) {
                scores.put(name1, scores.get(name1) + points);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (String name : scores.keySet()) {
            if (!name.equals(myName)) {
                result.add(name);
            }
        }
        
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int score1 = scores.get(s1);
                int score2 = scores.get(s2);
                
                if (score1 != score2) {
                    return score2 - score1;
                }
                return s1.compareTo(s2);
            }
        });
        
        for (String name : result) {
            System.out.println(name);
        }
    }
}
