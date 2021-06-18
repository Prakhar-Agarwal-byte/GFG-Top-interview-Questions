import java.util.Stack;

class Solution {
  public int largestRectangleArea(int[] heights) {
    Stack<Pair> leftSt = new Stack();
    int[] leftIndex = new int[heights.length];
    for (int i = 0; i < heights.length; i++) {
      while (!leftSt.isEmpty() && leftSt.peek().height >= heights[i]) {
        leftSt.pop();
      }
      if (leftSt.isEmpty())
        leftIndex[i] = -1;
      else
        leftIndex[i] = leftSt.peek().index;
      leftSt.push(new Pair(heights[i], i));
    }
    Stack<Pair> rightSt = new Stack();
    int[] rightIndex = new int[heights.length];
    for (int i = heights.length - 1; i >= 0; i--) {
      while (!rightSt.isEmpty() && rightSt.peek().height >= heights[i]) {
        rightSt.pop();
      }
      if (rightSt.isEmpty())
        rightIndex[i] = heights.length;
      else
        rightIndex[i] = rightSt.peek().index;
      rightSt.push(new Pair(heights[i], i));
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < heights.length; i++) {
      max = Math.max(max, heights[i] * (rightIndex[i] - leftIndex[i] - 1));
    }
    return max;

  }
}

class Pair {
  int height;
  int index;

  Pair(int height, int index) {
    this.height = height;
    this.index = index;
  }
}
