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
    public String treeIt(TreeNode root){
        if(root == null)
            return "";
        if(root.left == null && root.right == null)
            return "("+root.val+")";
        else if(root.left == null)
            return "("+root.val+"()"+treeIt(root.right)+")";
        return "("+root.val+treeIt(root.left)+treeIt(root.right)+")";
    }
    public String tree2str(TreeNode root) {
        String x = treeIt(root);
        return x.substring(1, x.length()-1);
    }
}