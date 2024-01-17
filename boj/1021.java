import java.util.*;

public class 1021 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] find = new int[M];
    for (int i = 0; i < M; i++) {
      find[i] = sc.nextInt();
    }
    LinkedList<Integer> q = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      q.add(i);
    }

    int count = 0;

    for (int i = 0; i < M; i++) {
      int target = find[i];

      int idx = q.indexOf(target);

      int rotateLeft = idx;
      int rotateRight = q.size() - idx;
      int min = Math.min(rotateLeft, rotateRight);

      count += min;

      while (min > 0) {
        if (rotateLeft <= rotateRight) {
          int data = q.removeFirst();
          q.addLast(data);
        } else {
          int data = q.removeLast();
          q.addFirst(data);
        }
        min--;
      }
      q.removeFirst();
    }
    System.out.println(count);

  }
}