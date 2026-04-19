import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int[][] fRank = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int card = sc.nextInt();
                fRank[i][card] = j;
            }
        }

        int[] aRank = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            int card = sc.nextInt();
            aRank[card] = j;
        }

        int[] ansT = new int[n + 1];
        int[] bestFRank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bestFRank[i] = Integer.MAX_VALUE;
        }

        int bestC = -1;
        int secondBestC = -1;

        for (int t = 1; t <= n; t++) {
            if (bestC == -1 || aRank[t] < aRank[bestC]) {
                secondBestC = bestC;
                bestC = t;
            } else if (secondBestC == -1 || aRank[t] < aRank[secondBestC]) {
                secondBestC = t;
            }

            for (int i = 1; i <= n; i++) {
                int c = -1;
                
                if (bestC != -1 && bestC != i) {
                    c = bestC;
                } else if (secondBestC != -1 && secondBestC != i) {
                    c = secondBestC;
                }

                if (c != -1) {
                    if (fRank[i][c] < bestFRank[i]) {
                        bestFRank[i] = fRank[i][c];
                        ansT[i] = t;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ansT[i]).append(i == n ? "" : " ");
        }
        System.out.println(sb.toString());

        sc.close();
    }
}
