class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) return null;
        
        int mid = startIndex + (endIndex - startIndex) / 2;
        
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = sortedArrayToBST(nums, startIndex, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, endIndex);
        
        return node;
    }
}