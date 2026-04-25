import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNext()) return;
        String s = sc.next();
        
        boolean isNegative = false;
        if (s.startsWith("-")) {
            isNegative = true;
            s = s.substring(1);
        }
        
        int dotIndex = s.indexOf('.');
        String intPart;
        String fracPart;
        
        if (dotIndex != -1) {
            intPart = s.substring(0, dotIndex);
            String f = s.substring(dotIndex + 1);
            if (f.length() >= 2) {
                fracPart = f.substring(0, 2);
            } else if (f.length() == 1) {
                fracPart = f + "0";
            } else {
                fracPart = "00";
            }
        } else {
            intPart = s;
            fracPart = "00";
        }
        
        StringBuilder formattedInt = new StringBuilder();
        int count = 0;
        for (int i = intPart.length() - 1; i >= 0; i--) {
            formattedInt.append(intPart.charAt(i));
            count++;
            if (count % 3 == 0 && i != 0) {
                formattedInt.append(',');
            }
        }
        formattedInt.reverse();
        
        StringBuilder result = new StringBuilder();
        if (isNegative) {
            result.append('(');
        }
        result.append('$');
        result.append(formattedInt);
        result.append('.');
        result.append(fracPart);
        if (isNegative) {
            result.append(')');
        }
        
        System.out.println(result.toString());
        
        sc.close();
    }
}
