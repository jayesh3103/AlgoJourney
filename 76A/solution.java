import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    
    static class Edge {
        int u, v;
        long g, s;
        
        public Edge(int u, int v, long g, long s) {
            this.u = u;
            this.v = v;
            this.g = g;
            this.s = s;
        }
    }
    
    static class DSU {
        int[] parent;
        
        public DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }
        
        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        
        String line1 = sc.next();
        if (line1 == null) return;
        int n = Integer.parseInt(line1);
        int m = sc.nextInt();
        
        long G = sc.nextLong();
        long S = sc.nextLong();
        
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextLong(), sc.nextLong());
        }
        
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Long.compare(o1.g, o2.g);
            }
        });
        
        ArrayList<Edge> currentEdges = new ArrayList<>();
        long minTotalCost = -1;
        
        for (Edge e : edges) {
            currentEdges.add(e);
            
            Collections.sort(currentEdges, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return Long.compare(o1.s, o2.s);
                }
            });
            
            DSU dsu = new DSU(n);
            ArrayList<Edge> nextEdges = new ArrayList<>();
            long maxS = 0;
            int edgesCount = 0;
            
            for (Edge cand : currentEdges) {
                if (dsu.union(cand.u, cand.v)) {
                    nextEdges.add(cand);
                    maxS = Math.max(maxS, cand.s);
                    edgesCount++;
                }
            }
            
            currentEdges = nextEdges;
            
            if (edgesCount == n - 1) {
                long currentCost = e.g * G + maxS * S;
                if (minTotalCost == -1 || currentCost < minTotalCost) {
                    minTotalCost = currentCost;
                }
            }
        }
        
        System.out.println(minTotalCost);
    }
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
