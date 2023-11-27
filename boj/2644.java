import java.util.*;

public class 2644 {
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static boolean[] visited;
  static int result = -1;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    int m = sc.nextInt();
    visited = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int from = sc.nextInt();
      int to = sc.nextInt();

      graph.get(from).add(to);
      graph.get(to).add(from);

    }
    int count = 0;
    dfs(A, B, count);

    System.out.println(result);

  }

  static void dfs(int A, int B, int count) {
    visited[A] = true;

    if (A == B) {
      result = count;
      return;
    }
    for (int next : graph.get(A)) {
      if (!visited[next])
        dfs(next, B, count + 1);
    }

  }
}