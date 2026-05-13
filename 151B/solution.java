import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Friend {
        String name;
        int taxi = 0;
        int pizza = 0;
        int girl = 0;

        public Friend(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        List<Friend> friends = new ArrayList<>();
        int maxTaxi = -1;
        int maxPizza = -1;
        int maxGirl = -1;

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            String name = sc.next();
            Friend f = new Friend(name);
            
            for (int j = 0; j < s; j++) {
                String phone = sc.next().replace("-", "");
                if (isTaxi(phone)) {
                    f.taxi++;
                } else if (isPizza(phone)) {
                    f.pizza++;
                } else {
                    f.girl++;
                }
            }
            
            friends.add(f);
            if (f.taxi > maxTaxi) maxTaxi = f.taxi;
            if (f.pizza > maxPizza) maxPizza = f.pizza;
            if (f.girl > maxGirl) maxGirl = f.girl;
        }
        sc.close();

        List<String> taxiNames = new ArrayList<>();
        List<String> pizzaNames = new ArrayList<>();
        List<String> girlNames = new ArrayList<>();

        for (Friend f : friends) {
            if (f.taxi == maxTaxi) taxiNames.add(f.name);
            if (f.pizza == maxPizza) pizzaNames.add(f.name);
            if (f.girl == maxGirl) girlNames.add(f.name);
        }

        System.out.println("If you want to call a taxi, you should call: " + String.join(", ", taxiNames) + ".");
        System.out.println("If you want to order a pizza, you should call: " + String.join(", ", pizzaNames) + ".");
        System.out.println("If you want to go to a cafe with a wonderful girl, you should call: " + String.join(", ", girlNames) + ".");
    }

    static boolean isTaxi(String s) {
        for (int i = 1; i < 6; i++) {
            if (s.charAt(i) != s.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPizza(String s) {
        for (int i = 1; i < 6; i++) {
            if (s.charAt(i) >= s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
