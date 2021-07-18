import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    Stack<TreeNode> st1 = new Stack<>();
    Stack<TreeNode> st2 = new Stack<>();
    List<Integer> res = new ArrayList<>();
    if (root == null)
      return res;
    st1.push(root);
    while (!st1.isEmpty()) {
      TreeNode tempNode = st1.pop();
      st2.push(tempNode);
      if (tempNode.left != null) {
        st1.push(tempNode.left);
      }
      if (tempNode.right != null) {
        st1.push(tempNode.right);
      }
    }
    while (!st2.isEmpty()) {
      res.add(st2.pop().val);
    }
    return res;
  }
}
