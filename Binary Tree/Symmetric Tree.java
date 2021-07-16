// Recursive
class Solution {
  public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
  }

  public boolean isMirror(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null)
      return true;
    if (node1 == null || node2 == null)
      return false;
    return (node1.val == node2.val) && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
  }
}


// Iterative
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}
