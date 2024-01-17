import java.util.*;

class Solution {
  public int[] solution(int[] progresses, int[] speeds) {

    ArrayList<Integer> al = new ArrayList<>();

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < progresses.length; i++) {
      q.add(i);
    }

    while (!q.isEmpty()) {
      int count = 0;
      while (!q.isEmpty() && progresses[(int) q.peek()] >= 100) {
        q.poll();
        count++;
      }
      if (count > 0) {
        al.add(count);
      } else {
        for (int i = 0; i < progresses.length; i++) {
          progresses[i] += speeds[i];
        }
      }
    }

    int[] answer = new int[al.size()];

    for (int i = 0; i < answer.length; i++) {
      answer[i] = al.get(i);
    }

    return answer;
  }
}