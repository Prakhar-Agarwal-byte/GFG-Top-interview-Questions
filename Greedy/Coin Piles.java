class Solution {
  static int minSteps(int[] A, int N, int K) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      min = Math.min(min, A[i]);
    }
    int count = 0;
    for (int i = 0; i < N; i++) {
      if (A[i] - min > K) {
        count += A[i] - min - K;
      }
    }
    return count;
  }
}
