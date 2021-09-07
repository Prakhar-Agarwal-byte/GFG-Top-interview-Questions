class Solution {
  private static int[][] dp;

  static int palindromicPartition(String str) {
    dp = new int[str.length() + 1][str.length() + 1];
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }
    return util(str, 0, str.length() - 1);
  }

  private static int util(String str, int i, int j) {
    if (i >= j)
      return 0;
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    if (isPalindrome(str.substring(i, j + 1)))
      return 0;
    int min = Integer.MAX_VALUE;
    for (int k = i; k < j; k++) {
      int temp = util(str, i, k) + util(str, k + 1, j) + 1;
      min = Math.min(min, temp);
    }
    return dp[i][j] = min;
  }

  private static boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i <= j) {
      if (s.charAt(i) != s.charAt(j))
        return false;
      i++;
      j--;
    }
    return true;
  }
}
