/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if((left == p && right == q) || (left == q && right == p))
            return root;
        if(left!=null)
            return left;
        if(right!=null)
            return right;
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p, q);
    }
}