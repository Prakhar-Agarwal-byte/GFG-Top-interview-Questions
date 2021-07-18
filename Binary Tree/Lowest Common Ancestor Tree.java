class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)
      return null;
    if (root == p || root == q) {
      return root;
    }
    TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
    TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
    if (leftNode != null && rightNode != null)
      return root;
    return leftNode == null ? rightNode : leftNode;
  }
}
