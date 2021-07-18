class Solution {
  Stack<TreeNode> st;

  public List<Integer> inorderTraversal(TreeNode root) {
    st = new Stack();
    List<Integer> res = new ArrayList<>();
    pushAll(root);
    while (!st.isEmpty()) {
      TreeNode tempNode = st.pop();
      res.add(tempNode.val);
      pushAll(tempNode.right);
    }
    return res;
  }

  private void pushAll(TreeNode node) {
    while (node != null) {
      st.push(node);
      node = node.left;
    }
  }
}
