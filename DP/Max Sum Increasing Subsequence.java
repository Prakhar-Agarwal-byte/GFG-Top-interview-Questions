class Solution {
  public int maxSumIS(int arr[], int n) {
    int[] dp = new int[n];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      dp[i] = arr[i];
      max = Math.max(max, arr[i]);
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          dp[i] = Math.max(dp[i], arr[i] + dp[j]);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
