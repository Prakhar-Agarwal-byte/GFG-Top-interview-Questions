import java.util.Arrays;

class Solution {
  int[] dp;

  public int jump(int[] nums) {
    dp = new int[nums.length + 1];
    Arrays.fill(dp, Integer.MAX_VALUE - 1);
    return util(nums, 0, nums.length - 1);
  }

  private int util(int[] nums, int i, int h) {
    if (i == h)
      return 0;
    if (nums[i] == 0)
      return Integer.MAX_VALUE - 1;
    if (dp[i] != Integer.MAX_VALUE - 1) {
      return dp[i];
    }
    int min = Integer.MAX_VALUE - 1;
    for (int k = i + 1; k <= h && k <= i + nums[i]; k++) {
      min = Math.min(min, 1 + util(nums, k, h));
    }
    return dp[i] = min;
  }
}
