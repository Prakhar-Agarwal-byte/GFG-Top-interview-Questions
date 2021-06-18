class Solution {

  int celebrity(int M[][], int n) {
    int a = 0;
    int b = n - 1;
    while (a < b) {
      if (knows(a, b, M)) {
        a++;
      } else {
        b--;
      }
    }
    int numOfPeopleKnowingCelebrity = 0;
    for (int i = 0; i < n; i++) {
      if (knows(a, i, M)) {
        return -1;
      } else if (knows(i, a, M)) {
        numOfPeopleKnowingCelebrity++;
      }
    }
    if (numOfPeopleKnowingCelebrity == n - 1)
      return a;
    return -1;
  }

  boolean knows(int i, int j, int[][] M) {
    if (M[i][j] == 1)
      return true;
    return false;
  }
}
