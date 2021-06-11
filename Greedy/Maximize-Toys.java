class Solution {
    static int toyCount(int N, int K, int arr[]) {
        Arrays.sort(arr);
        int spent = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] + spent <= K) {
                spent += arr[i];
                count++;
            }
        }
        return count;
    }
}
