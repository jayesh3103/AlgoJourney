import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static class Message {
        String from;
        String to;
        int t;

        Message(String from, String to, int t) {
            this.from = from;
            this.to = to;
            this.t = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int d = sc.nextInt();

        Message[] messages = new Message[n];
        for (int i = 0; i < n; i++) {
            messages[i] = new Message(sc.next(), sc.next(), sc.nextInt());
        }
        sc.close();

        Set<String> friends = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (messages[i].from.equals(messages[j].to) && messages[i].to.equals(messages[j].from)) {
                    int timeDiff = messages[j].t - messages[i].t;
                    if (timeDiff > 0 && timeDiff <= d) {
                        String u = messages[i].from;
                        String v = messages[i].to;
                        if (u.compareTo(v) > 0) {
                            String temp = u;
                            u = v;
                            v = temp;
                        }
                        friends.add(u + " " + v);
                    }
                }
            }
        }

        System.out.println(friends.size());
        for (String pair : friends) {
            System.out.println(pair);
        }
    }
}
