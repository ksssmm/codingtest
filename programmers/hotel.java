import java.util.*;

class Solution {
  public int solution(String[][] book_time) {
    Arrays.sort(book_time, (a, b) -> timeToMinutes(a[0]) - timeToMinutes(b[0]));

    PriorityQueue<Integer> rooms = new PriorityQueue<>();

    for (String[] time : book_time) {
      int start = timeToMinutes(time[0]);
      int end = timeToMinutes(time[1]) + 10;

      if (!rooms.isEmpty() && rooms.peek() <= start) {
        rooms.poll();
      }

      rooms.add(end);
    }
    return rooms.size();
  }

  private static int timeToMinutes(String time) {
    String[] temp = time.split(":");
    int h = Integer.parseInt(temp[0]);
    int m = Integer.parseInt(temp[1]);
    return h * 60 + m;
  }
}