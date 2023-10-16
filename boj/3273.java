import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = sc.nextInt();
    }

    int x = sc.nextInt();
    Arrays.sort(num);
    int count = 0;
    int left = 0;
    int right = n - 1;
    while (left < right) {
      if (num[left] + num[right] == x) {
        count++;
        left++;
        right--;
      } else if (num[left] + num[right] > x) {
        right--;
      } else {
        left++;
      }
    }
    System.out.println(count);
  }
}