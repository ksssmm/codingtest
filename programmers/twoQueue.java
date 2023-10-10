import java.util.Queue;
import java.util.LinkedList;

class Solution {
  public int solution(int[] queue1, int[] queue2) {
    int n = queue1.length;
    long sum1 = 0, sum2 = 0;

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      q1.offer(queue1[i]);
      q2.offer(queue2[i]);
      sum1 += queue1[i];
      sum2 += queue2[i];
    }

    if ((sum1 + sum2) % 2 != 0)
      return -1;

    long target = (sum1 + sum2) / 2;
    int answer = 0;

    while (answer < n * 4) {
      int diff = (int) (sum1 - target);
      if (diff == 0)
        return answer;

      if (diff < 0) {
        int temp = q2.poll();
        sum2 -= temp;
        sum1 += temp;
        q1.offer(temp);
      } else {
        int temp = q1.poll();
        sum1 -= temp;
        sum2 += temp;
        q2.offer(temp);
      }
      answer++;
    }

    return -1;
  }
}
