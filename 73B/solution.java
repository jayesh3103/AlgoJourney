import java.io.*;
import java.util.*;

public class Main {
    static class Racer {
        String name;
        int score;

        public Racer(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int n = Integer.parseInt(line.trim());
        Racer[] racers = new Racer[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            racers[i] = new Racer(name, score);
        }

        int m = Integer.parseInt(br.readLine().trim());
        ArrayList<Integer> points = new ArrayList<>();
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                points.add(Integer.parseInt(st.nextToken()));
            }
        }
        
        while (points.size() < n) {
            points.add(0);
        }
        Collections.sort(points);

        String vasyaName = br.readLine().trim();
        int vIdx = -1;
        for (int i = 0; i < n; i++) {
            if (racers[i].name.equals(vasyaName)) {
                vIdx = i;
                break;
            }
        }

        int maxPoints = points.get(n - 1);
        int vBestScore = racers[vIdx].score + maxPoints;
        ArrayList<Integer> limits = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (i == vIdx) continue;
            int diff = vBestScore - racers[i].score;
            if (vasyaName.compareTo(racers[i].name) > 0) {
                diff--;
            }
            limits.add(diff);
        }
        Collections.sort(limits);

        int keptBelow = 0;
        int pPtr = 0;
        int lPtr = 0;
        
        while (pPtr < n - 1 && lPtr < limits.size()) {
            if (points.get(pPtr) <= limits.get(lPtr)) {
                keptBelow++;
                pPtr++;
                lPtr++;
            } else {
                lPtr++;
            }
        }
        int bestRank = n - keptBelow;

        int minPoints = points.get(0);
        int vWorstScore = racers[vIdx].score + minPoints;
        ArrayList<Integer> needs = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (i == vIdx) continue;
            int need = vWorstScore - racers[i].score;
            if (racers[i].name.compareTo(vasyaName) < 0) {
                
            } else {
                need++;
            }
            needs.add(Math.max(0, need));
        }
        Collections.sort(needs);

        int pushedAbove = 0;
        pPtr = 1;
        int nPtr = 0;
        
        while (pPtr < n && nPtr < needs.size()) {
            if (points.get(pPtr) >= needs.get(nPtr)) {
                pushedAbove++;
                pPtr++;
                nPtr++;
            } else {
                pPtr++;
            }
        }
        int worstRank = 1 + pushedAbove;

        System.out.println(bestRank + " " + worstRank);
    }
}
