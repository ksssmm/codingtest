import java.util.*;

class Solution {
  static String[][] miro;
  static int[] dx = { 0, 0, -1, 1 };
  static int[] dy = { 1, -1, 0, 0 };

  public static int bfs(int[] start, String target, boolean[][] visit) {
    Queue<int[]> que = new LinkedList<>();
    que.add(new int[] { start[0], start[1], 0 });
    visit[start[0]][start[1]] = true;

    while (!que.isEmpty()) {
      int[] temp = que.poll();
      int x = temp[0];
      int y = temp[1];
      int count = temp[2];

      for (int i = 0; i < 4; i++) {
        int mx = x + dx[i];
        int my = y + dy[i];

        if (mx < 0 || mx >= miro.length || my < 0 || my >= miro[0].length)
          continue;
        if (!visit[mx][my] && !miro[mx][my].equals("X")) {
          visit[mx][my] = true;
          que.add(new int[] { mx, my, count + 1 });
          if (miro[mx][my].equals(target)) {
            return count + 1;
          }
        }
      }
    }
    return -1;
  }

  public int solution(String[] maps) {
    int n = maps.length;
    int m = maps[0].length();
    miro = new String[n][m];
    boolean[][] visit = new boolean[n][m];

    int[] start = new int[2];
    int[] lever = new int[2];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        miro[i][j] = Character.toString(maps[i].charAt(j));
        if (miro[i][j].equals("S")) {
          start[0] = i;
          start[1] = j;
        } else if (miro[i][j].equals("L")) {
          lever[0] = i;
          lever[1] = j;
        }
      }
    }

    int first = bfs(start, "L", visit);
    visit = new boolean[n][m];

    int second = bfs(lever, "E", visit);
    if (first == -1 || second == -1)
      return -1;
    return first + second;
  }
}
