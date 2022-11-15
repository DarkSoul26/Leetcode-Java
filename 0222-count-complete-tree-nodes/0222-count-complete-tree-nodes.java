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
    public int length(TreeNode root){
        if(root == null)
            return 0;
        return 1+length(root.left)+length(root.right);
    }
    public int countNodes(TreeNode root) {
        return length(root);
    }
}