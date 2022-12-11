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
    int maxAns = Integer.MIN_VALUE;
    public int maxPath(TreeNode root){
        if(root == null) return 0;
        
        int leftP = maxPath(root.left);
        int rightP = maxPath(root.right);
        
        if(leftP<0)
            leftP = 0;
        if(rightP<0)
            rightP = 0;
        maxAns = Math.max(maxAns, root.val + leftP + rightP);
        return root.val + Math.max(leftP, rightP);
    }
    public int maxPathSum(TreeNode root) {
        int maxP = maxPath(root);
        return maxAns;
    }
}