import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class TankTap implements Comparable<TankTap> {
        int tank;
        int tap;
        int minDiameter;

        public TankTap(int tank, int tap, int minDiameter) {
            this.tank = tank;
            this.tap = tap;
            this.minDiameter = minDiameter;
        }

        @Override
        public int compareTo(TankTap o) {
            return Integer.compare(this.tank, o.tank);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();

            int[] nextHouse = new int[n + 1];
            int[] pipeDiameter = new int[n + 1];
            int[] inDegree = new int[n + 1];

            for (int i = 0; i < p; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int d = scanner.nextInt();

                nextHouse[u] = v;
                pipeDiameter[u] = d;
                inDegree[v]++;
            }

            List<TankTap> results = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0 && nextHouse[i] != 0) {
                    int current = i;
                    int minDiam = Integer.MAX_VALUE;

                    while (nextHouse[current] != 0) {
                        minDiam = Math.min(minDiam, pipeDiameter[current]);
                        current = nextHouse[current];
                    }

                    results.add(new TankTap(i, current, minDiam));
                }
            }

            Collections.sort(results);

            System.out.println(results.size());
            
            for (TankTap res : results) {
                System.out.println(res.tank + " " + res.tap + " " + res.minDiameter);
            }
        }
    }
}
