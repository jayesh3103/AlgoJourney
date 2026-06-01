import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    static class Item implements Comparable<Item> {
        int id, price, type;
        
        Item(int id, int price, int type) {
            this.id = id;
            this.price = price;
            this.type = type;
        }
        
        public int compareTo(Item o) {
            return Integer.compare(o.price, this.price);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (st == null) return;
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        List<Item> stools = new ArrayList<>();
        List<Item> pencils = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if (t == 1) {
                stools.add(new Item(i, p, t));
            } else {
                pencils.add(new Item(i, p, t));
            }
        }
        
        Collections.sort(stools);
        Collections.sort(pencils);
        
        List<List<Item>> carts = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            carts.add(new ArrayList<>());
        }
        
        int cartIdx = 0;
        int stoolIdx = 0;
        
        while (stoolIdx < stools.size() && cartIdx < k - 1) {
            carts.get(cartIdx).add(stools.get(stoolIdx));
            stoolIdx++;
            cartIdx++;
        }
        
        int pencilIdx = 0;
        while (cartIdx < k - 1) {
            carts.get(cartIdx).add(pencils.get(pencilIdx));
            pencilIdx++;
            cartIdx++;
        }
        
        while (stoolIdx < stools.size()) {
            carts.get(k - 1).add(stools.get(stoolIdx++));
        }
        while (pencilIdx < pencils.size()) {
            carts.get(k - 1).add(pencils.get(pencilIdx++));
        }
        
        double totalCost = 0;
        for (int i = 0; i < k; i++) {
            List<Item> cart = carts.get(i);
            boolean hasStool = false;
            long sum = 0;
            long minP = Long.MAX_VALUE;
            
            for (Item item : cart) {
                if (item.type == 1) {
                    hasStool = true;
                }
                sum += item.price;
                minP = Math.min(minP, item.price);
            }
            
            if (hasStool) {
                totalCost += sum - minP / 2.0;
            } else {
                totalCost += sum;
            }
        }
        
        System.out.printf(Locale.US, "%.1f\n", totalCost);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            List<Item> cart = carts.get(i);
            sb.append(cart.size());
            for (Item item : cart) {
                sb.append(" ").append(item.id);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
