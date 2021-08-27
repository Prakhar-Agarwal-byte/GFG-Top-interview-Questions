import java.util.Arrays;

class Solution {
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length + 1];
    Arrays.fill(dp, 1);
    dp[0] = 0;
    int max = 1;
    for (int i = 2; i <= nums.length; i++) {
      for (int j = 1; j < i; j++) {
        if (nums[j - 1] < nums[i - 1]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
