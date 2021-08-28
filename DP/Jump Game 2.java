import java.util.Arrays;

class Solution {
  public int jump(int[] nums) {
    if (nums[0] == 0 && nums.length > 1)
      return -1;
    int[] dp = new int[nums.length];
    Arrays.fill(dp, Integer.MAX_VALUE - 1);
    dp[0] = 0;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (i <= j + nums[j]) {
          dp[i] = Math.min(dp[i], 1 + dp[j]);
        }
      }
    }
    return dp[nums.length - 1] == Integer.MAX_VALUE - 1 ? -1 : dp[nums.length - 1];
  }
}
