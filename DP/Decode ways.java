class Solution {
  public int numDecodings(String str) {
    int[] dp = new int[str.length() + 1];
    dp[0] = 1;
    dp[1] = str.charAt(0) == '0' ? 0 : 1;
    for (int i = 2; i <= str.length(); i++) {
      int oneDigit = Integer.valueOf(str.substring(i - 1, i));
      int twoDigit = Integer.valueOf(str.substring(i - 2, i));
      if (oneDigit >= 1) {
        dp[i] += dp[i - 1];
      }
      if (twoDigit >= 10 && twoDigit <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[str.length()];
  }
}
