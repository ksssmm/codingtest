import java.util.*;

class Solution {
  public int solution(int[][] board, int[] moves) {
    int count = 0;

    Stack<Integer> stack = new Stack<>();
    stack.push(101); // 의미 없는 데이터
    for (int i = 0; i < moves.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[j][moves[i] - 1] != 0) {
          if (stack.peek() == board[j][moves[i] - 1]) {// 연속된 인형인지
            stack.pop();
            count += 2;// 폭파
          } else {
            stack.push(board[j][moves[i] - 1]);
          }
          board[j][moves[i] - 1] = 0;// 뽑은 인형 처리
          break;
        }
      }

    }

    return count;
  }
}