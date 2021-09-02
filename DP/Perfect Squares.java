class Solution {
  public int numSquares(int n) {
    if (n <= 3)
      return n;
    int[] dp = new int[n + 1];
    for (int i = 0; i <= 3; i++) {
      dp[i] = i;
    }
    for (int i = 4; i <= n; i++) {
      dp[i] = i;
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
      }
    }
    return dp[n];
  }
}
