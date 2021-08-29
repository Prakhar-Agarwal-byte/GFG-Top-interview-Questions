class Solution {
  static int[][] dp;

  static int matrixMultiplication(int N, int arr[]) {
    dp = new int[arr.length][arr.length];
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }
    return solve(arr, 1, arr.length - 1);
  }

  private static int solve(int[] arr, int i, int j) {
    if (i >= j)
      return 0;
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    int min = Integer.MAX_VALUE;
    for (int k = i; k < j; k++) {
      int tempAns = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
      min = Math.min(min, tempAns);
    }
    return dp[i][j] = min;
  }
}
