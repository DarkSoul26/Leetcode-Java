/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public void check(TreeNode root, int low, int high){
        if(root == null)
            return;
        if(low>root.val)
            low = root.val;
        if(high<root.val)
            high = root.val;
        
        max = Math.max(max, Math.abs(low - high));
        check(root.left, low, high);
        check(root.right, low, high);
    }
    
    public int maxAncestorDiff(TreeNode root) {
        check(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return max;
    }
}