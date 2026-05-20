import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Card implements Comparable<Card> {
        int a;
        int b;

        public Card(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Card other) {
            if (this.b != other.b) {
                return Integer.compare(other.b, this.b);
            }
            return Integer.compare(other.a, this.a);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        Card[] cards = new Card[n];
        
        for (int i = 0; i < n; i++) {
            cards[i] = new Card(sc.nextInt(), sc.nextInt());
        }
        sc.close();

        Arrays.sort(cards);

        int counter = 1;
        int score = 0;

        for (int i = 0; i < n; i++) {
            if (counter == 0) {
                break;
            }
            score += cards[i].a;
            counter += cards[i].b - 1;
        }

        System.out.println(score);
    }
}
