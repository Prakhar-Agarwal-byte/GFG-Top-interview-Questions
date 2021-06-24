class Solution {
   public int numTrees(int n) {
  long C = 1;
  for (int i = 0; i < n; ++i) { // i stops at n - 1
    C = C * 2 * (2 * i + 1) / (i + 2); // calculate C_i+1
  }
  return (int) C;
} 
}
