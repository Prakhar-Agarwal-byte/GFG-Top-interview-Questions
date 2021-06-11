class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        for (int i = 0; i < n - 1; i++) {
            int a = arr[i];
            int b = arr[i+1];
            int high = Math.max(arr[n-1] - k, a + k);
            int low = Math.min(arr[0] + k, b - k);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }
}
