import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] dp = new int[n];
    int max = -1001;

    dp[0] = sc.nextInt();
    for (int i = 1; i < n; i++) {
      int temp = sc.nextInt();
      dp[i] = Math.max(dp[i - 1] + temp, temp);
    }
    Arrays.sort(dp);
    System.out.println(dp[n - 1]);
  }
}