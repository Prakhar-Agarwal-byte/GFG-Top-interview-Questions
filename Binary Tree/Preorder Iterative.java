import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

  public List<Integer> preorderTraversal(TreeNode root) {
    Stack<TreeNode> st = new Stack<>();
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    st.push(root);
    while (!st.isEmpty()) {
      TreeNode tempNode = st.pop();
      res.add(tempNode.val);
      if (tempNode.right != null) {
        st.push(tempNode.right);
      }
      if (tempNode.left != null) {
        st.push(tempNode.left);
      }
    }
    return res;
  }
}
