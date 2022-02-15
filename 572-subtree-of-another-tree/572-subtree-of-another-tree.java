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
    
    public boolean travHere(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;
        if(root.val != subRoot.val)
            return false;
        return travHere(root.left, subRoot.left) && travHere(root.right,subRoot.right);
    }
    boolean finalAns = false;
    public void trav(TreeNode root, TreeNode subRoot){
        if(root == null)
            return;
        if(root.val == subRoot.val){
            if(!finalAns)
                finalAns = travHere(root, subRoot);
            // return;
        }
        trav(root.left, subRoot);
        trav(root.right, subRoot);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        trav(root, subRoot);
        return finalAns;
    }
}