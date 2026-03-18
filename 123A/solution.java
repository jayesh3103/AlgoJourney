import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNext()) return;
        String s = sc.next();
        int n = s.length();
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        boolean[] inComp = new boolean[n];
        int compSize = 0;
        
        for (int i = 1; i < n; i++) { 
            int pos = i + 1;
            if (isPrime(pos) && pos > n / 2) {
                inComp[i] = false;
            } else {
                inComp[i] = true;
                compSize++;
            }
        }
        
        int maxFreq = 0;
        int maxChar = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxFreq) {
                maxFreq = count[i];
                maxChar = i;
            }
        }
        
        if (maxFreq < compSize) {
            System.out.println("NO");
            return;
        }
        
        System.out.println("YES");
        char[] res = new char[n];
        
        for (int i = 0; i < n; i++) {
            if (inComp[i]) {
                res[i] = (char) (maxChar + 'a');
                count[maxChar]--;
            }
        }
        
        int currChar = 0;
        for (int i = 0; i < n; i++) {
            if (!inComp[i]) {
                while (count[currChar] == 0) {
                    currChar++;
                }
                res[i] = (char) (currChar + 'a');
                count[currChar]--;
            }
        }
        
        System.out.println(new String(res));
        sc.close();
    }
    
    static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
