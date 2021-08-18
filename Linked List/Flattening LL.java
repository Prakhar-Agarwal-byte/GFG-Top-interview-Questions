class GfG {
  Node flatten(Node root) {
    if (root == null || root.next == null)
      return root;
    root.next = flatten(root.next);
    root = merge(root, root.next);
    return root;
  }

  private Node merge(Node root1, Node root2) {
    Node temp = new Node(0);
    Node tCur = temp;
    Node cur1 = root1;
    Node cur2 = root2;
    while (cur1 != null && cur2 != null) {
      if (cur1.data < cur2.data) {
        tCur.bottom = cur1;
        cur1 = cur1.bottom;
      } else {
        tCur.bottom = cur2;
        cur2 = cur2.bottom;
      }
      tCur = tCur.bottom;
    }
    if (cur1 == null)
      tCur.bottom = cur2;
    else
      tCur.bottom = cur1;
    return temp.bottom;
  }
}
