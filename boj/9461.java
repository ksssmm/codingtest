import java.util.*;

public class 9461 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      if (N < 4) {
        System.out.println("1");
      } else {
        long[] P = new long[N + 1];
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;

        for (int j = 4; j <= N; j++) {
          P[j] = P[j - 2] + P[j - 3];
        }
        System.out.println(P[N]);
      }
    }

  }
}