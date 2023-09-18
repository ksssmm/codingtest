class Solution {
  public int[] solution(int brown, int yellow) {

    for (int height = 1; height <= yellow; height++) {
      if (yellow % height == 0) {
        int width = yellow / height;

        if (2 * width + 2 * height + 4 == brown) {
          return new int[] { width + 2, height + 2 };
        }
      }

    }

    return new int[] {};
  }
}