class Solution {
    long minCost(long arr[], int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long cost = 0;
        for (long e : arr) {
            minHeap.add(e);
        }
        while (minHeap.size() > 1) {
            long a = minHeap.remove();
            long b = minHeap.remove();
            long sum = a + b;
            cost += sum;
            minHeap.add(sum);
        }
        return cost;
    }
}
