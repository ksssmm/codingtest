import java.util.*;

public class Main {
  static boolean[] visited;
  static ArrayList<Integer>[] list;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 정점의 개수
    int M = sc.nextInt(); // 간선의 개수

    list = new ArrayList[N + 1];
    visited = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      list[i] = new ArrayList<Integer>();
    }

    for (int j = 0; j < M; j++) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      list[x].add(y);
      list[y].add(x);
    }
    int count = 0;
    for (int k = 1; k <= N; k++) {
      if (!visited[k]) {
        bfs(k);
        count++;
      }
    }
    System.out.println(count);
  }

  public static void bfs(int start) {
    Queue<Integer> que = new LinkedList<>();
    visited[start] = true;
    que.add(start);

    while (!que.isEmpty()) {
      int temp = que.poll();
      for (int i : list[temp]) {
        if (!visited[i]) {
          visited[i] = true;
          que.add(i);
        }
      }
    }
  }
}
