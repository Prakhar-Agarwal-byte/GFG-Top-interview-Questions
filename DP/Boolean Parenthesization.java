class Solution {
  private static HashMap<String, Integer> map = new HashMap<>();

  static int countWays(int N, String S) {
    return parenthesisCount(S, 0, S.length() - 1, true);
  }

  private static int parenthesisCount(String s, int i, int j, boolean isTrue) {
    if (i > j)
      return 0;
    if (i == j) {
      if (isTrue) {
        return s.charAt(i) == 'T' ? 1 : 0;
      } else {
        return s.charAt(i) == 'F' ? 1 : 0;
      }
    }
    String key = i + " " + j + " " + isTrue;
    if (map.containsKey(key)) {
      return map.get(key);
    }
    int ans = 0;
    for (int k = i + 1; k < j; k += 2) {
      int lt = parenthesisCount(s, i, k - 1, true);
      int lf = parenthesisCount(s, i, k - 1, false);
      int rt = parenthesisCount(s, k + 1, j, true);
      int rf = parenthesisCount(s, k + 1, j, false);
      if (s.charAt(k) == '&') {
        if (isTrue) {
          ans += lt * rt;
        } else {
          ans += lf * rf + lf * rt + lt * rf;
        }
      } else if (s.charAt(k) == '|') {
        if (isTrue) {
          ans += lt * rt + lt * rf + lf * rt;
        } else {
          ans += lf * rf;
        }
      } else if (s.charAt(k) == '^') {
        if (isTrue) {
          ans += lt * rf + lf * rt;
        } else {
          ans += lt * rt + lf * rf;
        }
      }
    }
    map.put(key, ans);
    return ans;
  }
}
