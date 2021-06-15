class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        int[] ans = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (pq.size() < k) {
                pq.add(arr[i]);
            } else {
                if (arr[i] > pq.peek()) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
            if (pq.size() < k) {
                ans[i] = -1;
            } else {
                ans[i] = pq.peek();
            }
        }
        return ans;
    }
}
