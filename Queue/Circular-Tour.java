// Has nothing to do with stack or queue. Can only be solved easily by loops.

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance = 0;
        int cur = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            balance += gas[i] - cost[i];
            if (cur < 0) {
                index = i + 1;
                cur = 0;
            }
        }
        if (balance < 0)
            return -1;
        return index;
    }
}
