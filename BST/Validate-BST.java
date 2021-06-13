// 1 method using min and max constraints

class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return true;
        if (min != null && node.val <= min || max != null && node.val >= max)
            return false;
        return valid(node.left, min, node.val) && valid(node.right, node.val, max);
    }
}

// 2 method using inorder traversal to generate a sorted array and then check if array is sorted or not.

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list;

    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<Integer>();
        return valid(root);
    }

    private boolean valid(TreeNode root) {
        inorder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i))
                return false;
        }
        return true;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

}

