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
    
    public int findPath(TreeNode root, long tar){
        if(root == null)
            return 0;

        return ((long)root.val == tar ? 1 : 0)+findPath(root.left, tar-(long)root.val)+findPath(root.right, tar-(long)root.val);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        
        return findPath(root, (long)targetSum)+pathSum(root.left, targetSum)+pathSum(root.right, targetSum);
    }
}