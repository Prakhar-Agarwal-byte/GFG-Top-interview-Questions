class Solution {
  public int maxProfit(int k, int[] prices) {
    int[][] dp = new int[k + 1][prices.length+1];
    for (int i = 1; i <= k; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 2; j <= prices.length; j++) {
        max = Math.max(max, dp[i - 1][j - 1] - prices[j - 2]);
        dp[i][j] = Math.max(dp[i][j - 1], max + prices[j - 1]);
      }
    }
    return dp[k][prices.length];
  }
}
