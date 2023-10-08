import java.util.*;

class Solution {
  public String[] solution(String[][] plans) {
    String[] answer = new String[plans.length];

    Stack<String[]> stop = new Stack<>();

    Arrays.sort(plans, (a, b) -> ToSec(a[1]) - (ToSec(b[1])));

    int size = plans.length;

    int z = 0;
    int idx = 0;
    int current = 0;
    String name = "";
    int time = 0;
    int period = 0;
    int next = 0;
    while (size != idx) {

      name = plans[idx][0];
      time = ToSec(plans[idx][1]);
      period = Integer.parseInt(plans[idx][2]);

      current = time + period;// 끝나는 시간

      if (size - 1 != idx) { // 마지막 과제인지 체크
        next = ToSec(plans[idx + 1][1]);
        if (current > next) {// 진행중인 과제 종료시간이 나중이면

          stop.push(new String[] { name, current - next + "" });// 진행 중이던 과제 중단후 이름과 남은 진행시간 push
          current = next;
          idx++;

          continue;

        }
      }

      answer[z++] = name; // 완료 과제

      while (!stop.isEmpty()) {

        int remain = next - current;// 다음 과제 시작시간까지 남은 시간

        String[] work = stop.pop();

        int re_playtime = Integer.parseInt(work[1]);

        if (remain >= re_playtime) {// 남은 시간동안 중단한 과제 완료 가능

          answer[z++] = work[0];
          current += re_playtime;
        } else {

          stop.push(new String[] { work[0], re_playtime - remain + "" });
          break;
        }

      }

      idx++;
    }

    while (!stop.isEmpty()) {
      answer[z++] = stop.pop()[0];
    }

    return answer;
  }

  public int ToSec(String time) {

    String[] t = time.split(":");
    int h = Integer.parseInt(t[0]) * 60;
    int m = Integer.parseInt(t[1]);

    return h + m;
  }
}