public class Solution {
  public TreeNode inorderSucAndPre(TreeNode root, TreeNode node) {
    if (node.right != null) {
      TreeNode cur = node.right;
      while (cur.left != null) {
        cur = cur.left;
      }
      return cur;
    }
    if (node.left != null) {
      TreeNode cur = node.left;
      while (cur.right != null) {
        cur = cur.right;
      }
      return cur;
    }
    TreeNode suc = null;
    TreeNode pre = null;
    TreeNode anc = root;
    while (anc != node) {
      if (anc.val > node.val) {
        suc = anc;
        anc = anc.left;
      } else {
        pre = anc;
        anc = anc.right;
      }
    }
    // return pre and suc
    return null;
  }
}
