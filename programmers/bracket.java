import java.util.*;

class Solution {
  boolean solution(String s) {
    boolean answer = true;

    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(c);
      } else {
        if (stack.empty()) {
          return false;
        } else {
          stack.pop();
        }
      }
    }

    return stack.empty();
  }
}