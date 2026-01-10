import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};
        
        String s1 = scanner.next();
        String s2 = scanner.next();
        String s3 = scanner.next();
        
        int i1 = getIndex(notes, s1);
        int i2 = getIndex(notes, s2);
        int i3 = getIndex(notes, s3);
        
        int[] idx = {i1, i2, i3};
        
        int[][] permutations = {
            {0, 1, 2}, {0, 2, 1},
            {1, 0, 2}, {1, 2, 0},
            {2, 0, 1}, {2, 1, 0}
        };
        
        for (int[] p : permutations) {
            int a = idx[p[0]];
            int b = idx[p[1]];
            int c = idx[p[2]];
            
            int dist1 = (b - a + 12) % 12;
            int dist2 = (c - b + 12) % 12;
            
            if (dist1 == 4 && dist2 == 3) {
                System.out.println("major");
                return;
            }
            if (dist1 == 3 && dist2 == 4) {
                System.out.println("minor");
                return;
            }
        }
        
        System.out.println("strange");
    }
    
    private static int getIndex(String[] notes, String target) {
        for (int i = 0; i < notes.length; i++) {
            if (notes[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
