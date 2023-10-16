import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] num = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(num);

    int left = 0;
    int right = n - 1;
    int min = Integer.MAX_VALUE;
    int[] result = new int[2];

    while (left < right) {
      int sum = num[left] + num[right];

      if (min > Math.abs(sum)) {
        min = Math.abs(sum);
        result[0] = num[left];
        result[1] = num[right];
      }

      if (sum < 0) {
        left++;
      } else if (sum > 0) {
        right--;
      } else {
        break;
      }
    }

    System.out.println(result[0] + " " + result[1]);

  }
}
