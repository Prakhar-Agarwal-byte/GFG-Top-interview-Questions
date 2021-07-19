// 1st method: Recursive TC O(n^2) 

class Solution {
  public void flatten(TreeNode root) {
    if (root == null)
      return;
    TreeNode left = root.left;
    TreeNode right = root.right;
    root.left = null;
    flatten(left);
    flatten(right);
    root.right = left;
    TreeNode cur = root;
    while (cur != null)
      cur = cur.right;
    cur.right = right;
  }
}

// 2nd method: Iterative TC O(n) Uses Morris Traversal

public void flatten(TreeNode root) {
	TreeNode cur = root;
	while (cur != null) {
		if (cur.left != null) {
			TreeNode last = cur.left;
			while (last.right != null) last = last.right;
			last.right = cur.right;
			cur.right = cur.left;
			cur.left = null;
		}
		cur = cur.right;
	}
}

