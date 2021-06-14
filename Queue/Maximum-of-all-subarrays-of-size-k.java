import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        for (; i < n; i++) {
            ans.add(arr[q.peek()]);
            while (!q.isEmpty() && q.peek() <= i - k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        ans.add(arr[q.peek()]);
        return ans;
    }
}
