class Solution {
  public TreeNode pruneTree(TreeNode root) {
    if (root == null)
      return null;
    if (!dfs(root))
      return null;
    return root;
  }

  private boolean dfs(TreeNode node) {
    if (node == null)
      return false;
    boolean leftContains = dfs(node.left);
    boolean rightContains = dfs(node.right);
    if (!leftContains) {
      node.left = null;
    }
    if (!rightContains) {
      node.right = null;
    }
    return node.val == 1 || leftContains || rightContains;
  }
}
