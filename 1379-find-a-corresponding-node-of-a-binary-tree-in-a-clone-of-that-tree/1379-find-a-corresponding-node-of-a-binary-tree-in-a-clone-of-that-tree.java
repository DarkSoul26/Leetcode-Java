class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(target == null || original == null || cloned == null) return null;
        
        if(original == target)return cloned;
        
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if(right != null)return right;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        return left;
    }
}