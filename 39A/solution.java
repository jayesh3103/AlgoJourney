import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Term implements Comparable<Term> {
        int coeff;
        boolean isPreIncrement;

        Term(int coeff, boolean isPreIncrement) {
            this.coeff = coeff;
            this.isPreIncrement = isPreIncrement;
        }

        @Override
        public int compareTo(Term other) {
            return Integer.compare(this.coeff, other.coeff);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        String expr = in.next();

        if (expr.charAt(0) != '+' && expr.charAt(0) != '-') {
            expr = "+" + expr;
        }

        List<Term> terms = new ArrayList<>();
        int i = 0;
        while (i < expr.length()) {
            int sign = (expr.charAt(i) == '+') ? 1 : -1;
            i++;

            int numStart = i;
            while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                i++;
            }

            int coeff = 1;
            if (i > numStart) {
                coeff = Integer.parseInt(expr.substring(numStart, i));
            }
            
            if (i < expr.length() && expr.charAt(i) == '*') {
                i++;
            }
            
            boolean isPre = (expr.charAt(i) == '+');
            i += 3;

            terms.add(new Term(sign * coeff, isPre));
        }

        Collections.sort(terms);

        long total = 0;
        for (Term t : terms) {
            if (t.isPreIncrement) {
                a++;
                total += (long)t.coeff * a;
            } else {
                total += (long)t.coeff * a;
                a++;
            }
        }

        System.out.println(total);
        in.close();
    }
}
