import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        List<Integer>[] positions = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            positions[i] = new ArrayList<>();
        }

        for (int i = 0; i < s1.length(); i++) {
            positions[s1.charAt(i) - 'a'].add(i);
        }

        for (int i = 0; i < s2.length(); i++) {
            if (positions[s2.charAt(i) - 'a'].isEmpty()) {
                System.out.println("-1");
                return;
            }
        }

        int count = 1;
        int currentIdx = -1;

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            List<Integer> occurrences = positions[c - 'a'];

            int searchRes = Collections.binarySearch(occurrences, currentIdx);
            
            int nextIdxInList;
            if (searchRes >= 0) {
                nextIdxInList = searchRes + 1;
            } else {
                nextIdxInList = -(searchRes + 1);
            }

            if (nextIdxInList < occurrences.size()) {
                currentIdx = occurrences.get(nextIdxInList);
            } else {
                count++;
                currentIdx = occurrences.get(0);
            }
        }

        System.out.println(count);
    }
}
