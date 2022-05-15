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
    public int deepestLeavesSum(TreeNode root) {
    int height = getHeight(root);
	return getSum(root, height);
    }
    
    private int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right)+1;
    }
    
    private int getSum(TreeNode root, int level) {
		if(root==null) {
			return 0;
		}
		if(level==1) {
			return root.val;
		}
		int left = getSum(root.left, level - 1);
        int right = getSum(root.right, level - 1);
        return left+right;
	}
}