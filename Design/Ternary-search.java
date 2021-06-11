class Solution {
    static int ternarySearch(int arr[], int N, int K) {
        int left = 0;
        int right = N-1;
        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = right - (right - left) / 2;
            if (K == arr[mid1]) return 1;
            if (K == arr[mid2]) return 1;
            if (K < arr[mid1]) {
                right = mid1 - 1;
            } else if (K > arr[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1;
    }
}
