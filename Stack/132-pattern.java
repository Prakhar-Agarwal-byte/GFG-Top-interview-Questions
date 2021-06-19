import java.util.Stack;

class Solution {
  public boolean find132pattern(int[] nums) {
    Stack<Integer> st = new Stack<>();
    int second = Integer.MIN_VALUE;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] < second)
        return true;
      while (!st.isEmpty() && st.peek() < nums[i])
        second = st.pop();
      st.push(nums[i]);
    }
    return false;
  }
}
