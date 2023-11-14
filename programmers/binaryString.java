class Solution {
  public int[] solution(String s) {
    int zero = 0;
    int count = 0;
    while (!s.equals("1")) {
      int length = s.length();
      s = s.replaceAll("0", "");
      zero += length - s.length();
      s = Integer.toBinaryString(s.length());
      count++;
    }
    return new int[] { count, zero };
  }

}
