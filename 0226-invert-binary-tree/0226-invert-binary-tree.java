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
    public void invertIt(TreeNode root, TreeNode copy){
        copy.val = root.val;
        if(root.right!=null){
            copy.left = new TreeNode();
            invertIt(root.right, copy.left);
        }
        if(root.left!=null){
            copy.right = new TreeNode();
            invertIt(root.left, copy.right);
        } 
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode copy = new TreeNode();
        invertIt(root, copy);
        return copy;
    }
}