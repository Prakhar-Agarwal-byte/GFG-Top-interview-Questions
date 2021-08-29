class Solution {
  public int minInsertions(String s) {
    String revStr = new StringBuilder(s).reverse().toString();
    int[][] dp = new int[s.length() + 1][revStr.length() + 1];
    for (int i = 0; i <= s.length(); i++) {
      dp[i][0] = 0;
    }
    for (int i = 0; i <= revStr.length(); i++) {
      dp[0][i] = 0;
    }
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= revStr.length(); j++) {
        if (s.charAt(i - 1) == revStr.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return s.length() - dp[s.length()][revStr.length()];
  }
}
