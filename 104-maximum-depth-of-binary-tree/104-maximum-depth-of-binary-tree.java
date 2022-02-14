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
    public int maxD(TreeNode root, int h){
        if(root == null)
            return h;
        return Math.max(maxD(root.left, h+1), maxD(root.right, h+1));
    }
    public int maxDepth(TreeNode root) {
        return maxD(root,0);
    }
}