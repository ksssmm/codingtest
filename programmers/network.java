import java.util.*;

class Solution {

  static boolean[] visit;

  static void dfs(int[][] computers, int i, int n) {
    visit[i] = true;

    for (int j = 0; j < n; j++) {
      if (visit[j] == false && computers[i][j] == 1) {
        dfs(computers, j, n);
      }
    }
  }

  public int solution(int n, int[][] computers) {
    int answer = 0;
    visit = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (visit[i] == false) {
        answer++;
        dfs(computers, i, n);
      }
    }
    return answer;

  }
}
