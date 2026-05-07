import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextDouble()) return;
        
        double vp = sc.nextDouble();
        double vd = sc.nextDouble();
        double t = sc.nextDouble();
        double f = sc.nextDouble();
        double c = sc.nextDouble();
        sc.close();

        if (vp >= vd) {
            System.out.println(0);
            return;
        }

        int bijous = 0;
        double currentDistance = vp * t;

        while (currentDistance < c) {
            double timeToCatch = currentDistance / (vd - vp);
            double catchDistance = currentDistance + vp * timeToCatch;

            if (catchDistance >= c - 1e-9) {
                break;
            }

            bijous++;
            double timeToReturn = catchDistance / vd;
            currentDistance = catchDistance + vp * (timeToReturn + f);
        }

        System.out.println(bijous);
    }
}
