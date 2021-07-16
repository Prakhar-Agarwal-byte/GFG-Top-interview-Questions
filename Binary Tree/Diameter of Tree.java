class Solution {
  int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null)
      return 0;
    dfs(root);
    return diameter;
  }

  public int dfs(TreeNode node) {
    if (node == null)
      return 0;
    int leftHeight = dfs(node.left);
    int rightHeight = dfs(node.right);
    diameter = Math.max(diameter, leftHeight + rightHeight);
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
