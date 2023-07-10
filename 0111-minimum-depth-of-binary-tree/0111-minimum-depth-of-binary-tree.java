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
    int min = Integer.MAX_VALUE;
    public void h(TreeNode root, int height){
        if(root == null){
            //min = Math.min(min, height);
            return;
            }
        if(root.left==null && root.right==null){
            min= Math.min(min, height);
            return;
        }
        h(root.left, height+1);
        h(root.right, height+1);
        }
    public int minDepth(TreeNode root) {
        h(root, 1);
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
    }
}