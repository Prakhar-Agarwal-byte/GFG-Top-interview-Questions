import java.util.Arrays;

class Solution {
  public boolean canJump(int[] nums) {
    if (nums[0] == 0 && nums.length > 1) return false;
    int[] dp = new int[nums.length];
    Arrays.fill(dp, Integer.MAX_VALUE-1);
    dp[0] = 0;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (i <= j + nums[j]) {
            dp[i] = Math.min(dp[i], 1 + dp[j]);
        }
      }
    }
    return dp[nums.length-1] == Integer.MAX_VALUE-1 ? false : true;
  }
}
