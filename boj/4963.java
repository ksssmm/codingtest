import java.util.Scanner;

public class Main {

  static int[][] map;
  static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
  static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
  static boolean[][] visited;

  static int w, h;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      w = sc.nextInt();
      h = sc.nextInt();

      if (w == 0 && h == 0)
        break;

      map = new int[h][w];
      visited = new boolean[h][w];
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          map[i][j] = sc.nextInt();
        }
      }
      int count = 0;
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (!visited[i][j] && map[i][j] == 1) {
            count++;
            dfs(i, j);
          }
        }
      }
      System.out.println(count);
    }
  }

  public static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int i = 0; i < 8; i++) {
      int mx = x + dx[i];
      int my = y + dy[i];
      if (mx >= 0 && mx < h && my >= 0 && my < w) {
        if (!visited[mx][my] && map[mx][my] == 1) {
          dfs(mx, my);
        }
      }
    }
  }
}
