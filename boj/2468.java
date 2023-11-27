import java.util.*;
import java.io.*;

public class 2468 {
  static int[] dx = { -1, 0, 1, 0 };
  static int[] dy = { 0, 1, 0, -1 };

  static int N;
  static int[][] land;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    land = new int[N][N];
    int max = 0;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        land[i][j] = Integer.parseInt(st.nextToken());
        max = Math.max(max, land[i][j]);
      }
    }

    int safeArea = 0;
    for (int i = max; i >= 0; i--) {
      visited = new boolean[N][N];
      int count = 0;
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          if (!visited[j][k] && land[j][k] > i) {
            dfs(j, k, i);
            count++;
          }
        }
      }
      safeArea = Math.max(count, safeArea);

    }
    System.out.println(safeArea);

  }

  static void dfs(int x, int y, int height) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int mx = x + dx[i];
      int my = y + dy[i];

      if (mx >= 0 && mx < N && my >= 0 && my < N) {
        if (!visited[mx][my] && land[mx][my] > height) {
          dfs(mx, my, height);
        }
      }
    }
  }
}