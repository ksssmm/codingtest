import java.util.*;

public class Solution {
  public int[] solution(int[] arr) {

    int cur = -1;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (cur == arr[i])
        continue;
      stack.push(arr[i]);
      cur = arr[i];
    }
    int[] answer = new int[stack.size()];
    for (int j = stack.size() - 1; j >= 0; j--) {
      answer[j] = stack.pop();
    }
    return answer;
  }
}