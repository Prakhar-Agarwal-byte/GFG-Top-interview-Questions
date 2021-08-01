class Solution {
  static int ret = Integer.MIN_VALUE;

  public static int minTime(Node root, int target) {
    if (root == null)
      return 0;
    if (root.data == target) {
      return 1;
    }
    int val = minTime(root.left, target);
    if (val != 0) {
      ret = Math.max(ret, val + height(root.right));
      return val + 1;
    }
    val = minTime(root.right, target);
    if (val != 0) {
      ret = Math.max(ret, val + height(root.left));
      return val + 1;
    }
    return 0;
  }

  private static int height(Node node) {
    if (node == null)
      return 0;
    return 1 + Math.max(height(node.left), height(node.right));
  }
}
