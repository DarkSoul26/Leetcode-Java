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
    int maxDia = Integer.MIN_VALUE;
    public int dia(TreeNode root){
        if(root == null) return 0;
        
        int leftLvl = dia(root.left);
        int rightLvl = dia(root.right);
        
        maxDia = Math.max(maxDia, leftLvl + rightLvl);
        return 1+Math.max(leftLvl, rightLvl);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int lvl = dia(root);
        return maxDia;
    }
}