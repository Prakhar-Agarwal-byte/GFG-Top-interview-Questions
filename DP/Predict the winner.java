class Solution {
  public boolean PredictTheWinner(int[] nums) {
    int sum = 0;
    for (int e : nums) {
      sum += e;
    }
    int[][] dp = new int[nums.length][nums.length];
    for (int g = 0; g < dp.length; g++) {
      for (int i = 0, j = g; j < dp.length; i++, j++) {
        if (g == 0) {
          dp[i][j] = nums[i];
        }
        if (g == 1) {
          dp[i][j] = Math.max(nums[i], nums[j]);
        }
        if (g > 1) {
          int val1 = nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
          int val2 = nums[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
          dp[i][j] = Math.max(val1, val2);
        }
      }
    }
    return dp[0][nums.length - 1] * 2 >= sum;
  }
}
