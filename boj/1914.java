import java.util.*;
import java.math.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    System.out.println((new BigInteger("2")).pow(N).subtract(BigInteger.ONE));
    if (N <= 20) {
      hanoi(N, 1, 2, 3);
    }
  }

  public static void hanoi(int N, int from, int mid, int to) {
    if (N == 1) {
      System.out.println(from + " " + to);
      return;
    } else {
      hanoi(N - 1, from, to, mid);
      System.out.println(from + " " + to);
      hanoi(N - 1, mid, from, to);
    }
  }
}