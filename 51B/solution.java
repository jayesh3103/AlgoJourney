import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            sb.append(in.nextLine());
        }
        String s = sb.toString();
        in.close();

        Stack<Integer> stack = new Stack<>();
        List<Integer> sizes = new ArrayList<>();

        String[] tags = s.split("(?=<)");

        for (String tag : tags) {
            if (tag.equals("<table>")) {
                stack.push(0);
            } else if (tag.equals("</table>")) {
                if (!stack.isEmpty()) {
                    sizes.add(stack.pop());
                }
            } else if (tag.equals("<td>")) {
                if (!stack.isEmpty()) {
                    stack.push(stack.pop() + 1);
                }
            }
        }

        Collections.sort(sizes);

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < sizes.size(); i++) {
            out.append(sizes.get(i));
            if (i < sizes.size() - 1) {
                out.append(" ");
            }
        }
        
        System.out.println(out.toString());
    }
}
