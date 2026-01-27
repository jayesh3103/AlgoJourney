import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int len = n.length();

        if (len % 2 != 0) {
            printSmallest(len + 1);
            return;
        }

        int count4 = 0;
        int count7 = 0;
        int p = 0;
        int limit = len / 2;

        for (int i = 0; i < len; i++) {
            char c = n.charAt(i);
            if (c == '4') {
                if (count4 + 1 <= limit) {
                    count4++;
                    p++;
                } else {
                    break;
                }
            } else if (c == '7') {
                if (count7 + 1 <= limit) {
                    count7++;
                    p++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        if (p == len && count4 == limit && count7 == limit) {
            System.out.println(n);
            return;
        }

        for (int i = p; i >= 0; i--) {
            if (i < len && n.charAt(i) < '4' && count4 + 1 <= limit) {
                printRest(n, i, '4', count4, count7, limit);
                return;
            }
            
            if (i < len && n.charAt(i) < '7' && count7 + 1 <= limit) {
                printRest(n, i, '7', count4, count7, limit);
                return;
            }

            if (i > 0) {
                char c = n.charAt(i - 1);
                if (c == '4') count4--;
                else if (c == '7') count7--;
            }
        }

        printSmallest(len + 2);
    }

    private static void printSmallest(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length / 2; i++) sb.append('4');
        for (int i = 0; i < length / 2; i++) sb.append('7');
        System.out.println(sb.toString());
    }

    private static void printRest(String n, int idx, char digit, int c4, int c7, int limit) {
        StringBuilder sb = new StringBuilder();
        sb.append(n, 0, idx);
        sb.append(digit);
        
        if (digit == '4') c4++;
        else c7++;
        
        int rem4 = limit - c4;
        int rem7 = limit - c7;
        
        for (int k = 0; k < rem4; k++) sb.append('4');
        for (int k = 0; k < rem7; k++) sb.append('7');
        
        System.out.println(sb.toString());
    }
}
