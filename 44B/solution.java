import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
      try (Scanner in = new Scanner(System.in)) {
          int n = in.nextInt();
          int a = in.nextInt();
          int b = in.nextInt();
          int c = in.nextInt();

          long count = 0;
          int target = n * 2; 

          for (int i = 0; i <= c; i++) {
              for (int j = 0; j <= b; j++) {
                  int rem = target - (i * 4) - (j * 2);

                  if (rem < 0) {
                      break;
                  }

                  if (rem <= a) {
                      count++;
                  }
              }
          }

          System.out.println(count);
      }
  }
}
