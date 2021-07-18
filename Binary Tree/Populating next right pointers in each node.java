class Solution {
    public Node connect(Node root) {
        dfs(root, null);        
        return root;
    }
    
    private void dfs(Node curr, Node next) {
        if (curr == null) return;
        curr.next = next;
        dfs(curr.left, curr.right);
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }
}
