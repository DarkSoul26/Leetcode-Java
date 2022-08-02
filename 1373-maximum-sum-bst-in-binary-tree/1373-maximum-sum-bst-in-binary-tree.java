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
    
    int res = Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        maxS(root);
        return res < 0 ? 0 : res;
    }

    public int[] maxS(TreeNode root) {
        if (root == null) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        
        int[] left = maxS(root.left);
        int[] right = maxS(root.right);
        if (left[1] >= root.val || right[0] <= root.val) {
            return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int sum = left[2] + root.val + right[2];
        res = Math.max(res, sum);
        
        return new int[] {Math.min(root.val, left[0]), Math.max(root.val, right[1]), sum};
        
    }
}