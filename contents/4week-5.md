# 섬의 개수

## baekjoon 4963

## 문제

<img src="./images/islands-1.png" width="70%">

이 문제는 섬의 개수를 구하는 문제이다. 섬들은 그림에서 처럼 칠해진 땅이 이어져서 만들어진다.

땅들은 상하좌우 외에도 대각선 방향으로 이어져 있으면 같은 섬으로 취급한다.

### 풀이 
-----

걸어서 갈 수 있는 경로는 총 8방향이다. 따라서 다음과 같이 설정해줬다.
```
static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
```

이 방향을 가지고 dfs를 수행하면서 방문한 땅들의 `visited`를 `true` 처리했다.





```
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

```