class Solution {
  private boolean result = true;

  public boolean isBalanced(TreeNode root) {
    height(root);
    return result;
  }

  public int height(TreeNode node) {
    if (!result)
      return 0;
    if (node == null)
      return 0;
    int lH = height(node.left);
    int rH = height(node.right);
    if (Math.abs(lH - rH) > 1) {
      result = false;
    }
    return Math.max(lH, rH) + 1;
  }
}
