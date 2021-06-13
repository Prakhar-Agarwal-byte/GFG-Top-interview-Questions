class Solution {

    public Node inorderSuccessor(Node root, Node node) {
        if (node.right != null) {
            Node cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            Node successor = null;
            Node ancestor = root;
            while (ancestor != node) {
                if (ancestor.data > node.data) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
    }
}
