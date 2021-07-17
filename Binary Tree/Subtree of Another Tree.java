// 1st Approach TC n*m where n is the num of nodes in tree and m is the num of nodes in subtree. SC n

class Solution {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null)
      return false;
    if (isSame(root, subRoot))
      return true;
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public boolean isSame(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null)
      return true;
    if (node1 == null || node2 == null)
      return false;
    return (node1.val == node2.val) && isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
  }
}
