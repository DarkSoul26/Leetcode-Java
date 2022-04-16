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
    int totSum = 0;
    public void trav(TreeNode root){
        if(root == null)
            return;
        trav(root.right);
        root.val += totSum;
        totSum = root.val;
        trav(root.left);
    }
    public TreeNode convertBST(TreeNode root) {
        trav(root);
        return root;
    }
}