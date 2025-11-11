import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            long h = in.nextLong();
            long w = in.nextLong();

            long bestH = 0;
            long bestW = 0;
            long bestArea = -1; 

            for (long ch = 1; ch <= h; ch *= 2) {
                long minW = (ch * 4 + 4) / 5;
                long maxW = (ch * 5) / 4;
                long cw = Math.min(w, maxW);
                
                if (cw >= minW) {
                    long area = ch * cw;
                    if (area > bestArea) {
                        bestArea = area;
                        bestH = ch;
                        bestW = cw;
                    } else if (area == bestArea) {
                        if (ch > bestH) {
                            bestH = ch;
                            bestW = cw;
                        }
                    }
                }
            }
            
            for (long cw = 1; cw <= w; cw *= 2) {
                long minH = (cw * 4 + 4) / 5;
                long maxH = (cw * 5) / 4;
                long ch = Math.min(h, maxH);
                
                if (ch >= minH) {
                    long area = ch * cw;
                    if (area > bestArea) {
                        bestArea = area;
                        bestH = ch;
                        bestW = cw;
                    } else if (area == bestArea) {
                        if (ch > bestH) {
                            bestH = ch;
                            bestW = cw;
                        }
                    }
                }
            }
            
            System.out.println(bestH + " " + bestW);
        }
    }
}
