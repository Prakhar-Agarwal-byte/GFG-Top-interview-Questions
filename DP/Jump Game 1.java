class Solution {
  public boolean canJump(int[] nums) {
    boolean[] dp = new boolean[nums.length + 1];
    dp[0] = true;
    for (int i = 1; i <= nums.length; i++) {
      int max = nums[i-1];
      while (max-- > 0) {
        if (i - max >= 0) {
          dp[i] = dp[i] || dp[i - max];
        }
      }
    }
    return dp[nums.length];
  }
}
