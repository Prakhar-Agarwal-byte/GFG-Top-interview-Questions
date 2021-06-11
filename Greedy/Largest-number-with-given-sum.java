class Solution {
    //Function to return the largest possible number of n digits
    //with sum equal to given sum.
    static String largestNumber(int n, int sum) {
        if (sum > n * 9) return "-1";
        int curSum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (sum - curSum >= 9) {
                sb.append(9);
                curSum += 9;
            } else {
                sb.append(sum - curSum);
                curSum += sum - curSum;
            }
        }
        return sb.toString();
    }
}
