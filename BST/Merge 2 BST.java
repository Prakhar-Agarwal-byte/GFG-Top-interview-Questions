import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    Stack<TreeNode> st1 = new Stack<>();
    Stack<TreeNode> st2 = new Stack<>();
    ArrayList<Integer> ans = new ArrayList<>();
    pushAll(root1, st1);
    pushAll(root2, st2);
    while (!st1.isEmpty() && !st2.isEmpty()) {
      if (st1.peek().val < st2.peek().val) {
        TreeNode node = st1.pop();
        ans.add(node.val);
        pushAll(node.right, st1);
      } else {
        TreeNode node = st2.pop();
        ans.add(node.val);
        pushAll(node.right, st2);
      }
    }
    while (!st1.isEmpty()) {
      TreeNode node = st1.pop();
      ans.add(node.val);
      pushAll(node.right, st1);
    }
    while (!st2.isEmpty()) {
      TreeNode node = st2.pop();
      ans.add(node.val);
      pushAll(node.right, st2);
    }
    return ans;
  }

  private void pushAll(TreeNode node, Stack<TreeNode> st) {
    while (node != null) {
      st.push(node);
      node = node.left;
    }
  }
}
