import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class BigFraction {
        BigInteger num;
        BigInteger den;

        public BigFraction(BigInteger n, BigInteger d) {
            if (d.equals(BigInteger.ZERO)) throw new ArithmeticException("Division by zero");
            if (d.signum() < 0) {
                n = n.negate();
                d = d.negate();
            }
            BigInteger g = n.gcd(d);
            this.num = n.divide(g);
            this.den = d.divide(g);
        }

        public static BigFraction add(BigFraction a, BigFraction b) {
            BigInteger newNum = a.num.multiply(b.den).add(b.num.multiply(a.den));
            BigInteger newDen = a.den.multiply(b.den);
            return new BigFraction(newNum, newDen);
        }

        public static BigFraction multiply(BigFraction a, BigFraction b) {
            return new BigFraction(a.num.multiply(b.num), a.den.multiply(b.den));
        }

        @Override
        public String toString() {
            return num + "/" + den;
        }
    }

    static class Edge {
        int k;
        int nextNode;
        BigInteger v;

        public Edge(int k, int nextNode, BigInteger v) {
            this.k = k;
            this.nextNode = nextNode;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());

        if (n == 1) {
            System.out.println("0/1");
            return;
        }

        Edge[] adj = new Edge[n]; 
        
        for (int u = 1; u < n; u++) {
            int k = 0;
            long val = u;
            while (val < n) {
                val <<= 1;
                k++;
            }
            adj[u] = new Edge(k, (int)(val % n), BigInteger.valueOf(val));
        }

        int[] visitedAtStep = new int[n]; 
        Arrays.fill(visitedAtStep, -1);
        List<Integer> path = new ArrayList<>();
        int curr = 1;
        int cycleStartNode = -1;

        while (true) {
            if (curr == 0) {
                break;
            }
            if (visitedAtStep[curr] != -1) {
                cycleStartNode = curr;
                break;
            }
            visitedAtStep[curr] = path.size();
            path.add(curr);
            curr = adj[curr].nextNode;
        }

        BigFraction resultVal;

        if (curr == 0) {
            resultVal = new BigFraction(BigInteger.ZERO, BigInteger.ONE);
        } else {
            int startIndex = visitedAtStep[cycleStartNode];
            List<Integer> cycle = new ArrayList<>();
            for (int i = startIndex; i < path.size(); i++) {
                cycle.add(path.get(i));
            }
            
            int K = 0;
            for (int u : cycle) {
                K += adj[u].k;
            }
            
            BigInteger numSum = BigInteger.ZERO;
            int currentT = 0;
            
            for (int u : cycle) {
                int k = adj[u].k;
                int exponent = K - currentT;
                BigInteger term = BigInteger.valueOf(k).multiply(BigInteger.valueOf(u));
                term = term.shiftLeft(exponent);
                numSum = numSum.add(term);
                
                currentT += k;
            }
            
            BigInteger u0 = BigInteger.valueOf(cycleStartNode);
            BigInteger twoPowK = BigInteger.ONE.shiftLeft(K);
            BigInteger denomPart = twoPowK.subtract(BigInteger.ONE).multiply(u0);
            
            resultVal = new BigFraction(numSum, denomPart);
            
            while (path.size() > startIndex) {
                path.remove(path.size() - 1);
            }
        }
        
        for (int i = path.size() - 1; i >= 0; i--) {
            int u = path.get(i);
            Edge e = adj[u];
            
            BigFraction kFrac = new BigFraction(BigInteger.valueOf(e.k), BigInteger.ONE);
            BigInteger wBI = BigInteger.valueOf(e.nextNode);
            BigFraction coeff = new BigFraction(wBI, e.v);
            
            BigFraction term2 = BigFraction.multiply(coeff, resultVal);
            resultVal = BigFraction.add(kFrac, term2);
        }
        
        System.out.println(resultVal);
    }
}
