// Based on LIS
class Solution {
  public int AlternatingaMaxLength(int[] nums) {
    int[][] dp = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++)
        dp[i][0] = dp[i][1] = 1;
    int max = 1;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i][0] = Math.max(dp[i][0], 1 + dp[j][1]);
        } else {
          dp[i][1] = Math.max(dp[i][1], 1 + dp[j][0]);
        }
      }
      max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
    }
    return max;
  }
}

// Optimised
int LAS(int arr[], int n)
{

    // "inc" and "dec" initialized as 1
    // as single element is still LAS
    int inc = 1;
    int dec = 1;

    // Iterate from second element
    for (int i = 1; i < n; i++) 
    {

        if (arr[i] > arr[i - 1]) 
        {

            // "inc" changes iff "dec" 
            // changes
            inc = dec + 1;
        }

        else if (arr[i] < arr[i - 1]) 
        {

            // "dec" changes iff "inc" 
            // changes
            dec = inc + 1;
        }
    }

    // Return the maximum length
    return max(inc, dec);
}
