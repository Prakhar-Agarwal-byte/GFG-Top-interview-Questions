import java.util.Arrays;

class Solution {
  int[][] dp;

  public int minDistance(String word1, String word2) {
    dp = new int[word1.length() + 1][word2.length() + 1];
    for (int[] rows : dp) {
      Arrays.fill(rows, Integer.MAX_VALUE);
    }
    return util(word1, word2, word1.length(), word2.length());
  }

  private int util(String word1, String word2, int m, int n) {
    if (m == 0)
      return n;
    if (n == 0)
      return m;
    if (dp[m][n] != Integer.MAX_VALUE) {
      return dp[m][n];
    }
    if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
      return dp[m][n] = util(word1, word2, m - 1, n - 1);
    }
    return dp[m][n] = 1 + Math.min(util(word1, word2, m, n - 1),
        Math.min(util(word1, word2, m - 1, n), util(word1, word2, m - 1, n - 1)));
  }
}
