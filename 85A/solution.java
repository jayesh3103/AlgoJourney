import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            int[][] ids = new int[4][n];
            int currentId = 1;
            
            if (n % 2 == 0) {
                for (int r = 0; r <= 1; r++) {
                    for (int c = 0; c < n; c += 2) {
                        ids[r][c] = ids[r][c+1] = currentId++;
                    }
                }
                ids[2][0] = ids[3][0] = currentId++;
                ids[2][n-1] = ids[3][n-1] = currentId++;
                
                for (int c = 1; c < n - 1; c += 2) {
                    ids[2][c] = ids[2][c+1] = currentId++;
                    ids[3][c] = ids[3][c+1] = currentId++;
                }
            } else {
                ids[0][n-1] = ids[1][n-1] = currentId++; 
                for (int c = 0; c < n - 1; c += 2) {
                    ids[0][c] = ids[0][c+1] = currentId++;
                    ids[1][c] = ids[1][c+1] = currentId++;
                }
                
                ids[2][0] = ids[3][0] = currentId++; 
                for (int c = 1; c < n; c += 2) {
                    ids[2][c] = ids[2][c+1] = currentId++;
                    ids[3][c] = ids[3][c+1] = currentId++;
                }
            }
            
            char[][] result = new char[4][n];
            char[] idColor = new char[currentId]; 
            Arrays.fill(idColor, ' ');
            
            int[] dr = {0, 0, 1, -1};
            int[] dc = {1, -1, 0, 0};
            
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < n; c++) {
                    int id = ids[r][c];
                    if (idColor[id] == ' ') {
                        Set<Character> usedColors = new HashSet<>();
                        
                        for (int r2 = 0; r2 < 4; r2++) {
                            for (int c2 = 0; c2 < n; c2++) {
                                if (ids[r2][c2] == id) {
                                    for (int k = 0; k < 4; k++) {
                                        int nr = r2 + dr[k];
                                        int nc = c2 + dc[k];
                                        if (nr >= 0 && nr < 4 && nc >= 0 && nc < n) {
                                            int nid = ids[nr][nc];
                                            if (nid != id && idColor[nid] != ' ') {
                                                usedColors.add(idColor[nid]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        
                        char color = 'a';
                        while (usedColors.contains(color)) {
                            color++;
                        }
                        idColor[id] = color;
                    }
                    result[r][c] = idColor[id];
                }
            }
            
            for (int r = 0; r < 4; r++) {
                System.out.println(new String(result[r]));
            }
        }
    }
}
