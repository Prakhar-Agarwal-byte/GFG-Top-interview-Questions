class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return util(0, nums.length - 1, nums);
    }

    private TreeNode util(int start, int end, int[] nums) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = util(start, mid - 1, nums);
        root.right = util(mid + 1, end, nums);
        return root;
    }
}
