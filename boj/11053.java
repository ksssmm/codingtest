import java.util.*;

public class 11053 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[] A = new int[N];
    int[] length = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
      length[i] = 1;
    }

    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        if (A[i] < A[j]) {
          length[j] = Math.max(length[j], length[i] + 1);
        }
      }
    }
    int max = 0;
    for (int len : length) {
      if (max < len){
        max = len;
      }
    }
    System.out.println(max);
  }
}