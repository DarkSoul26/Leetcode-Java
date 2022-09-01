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
    int globalCount = 0;
    public void goodOnes(TreeNode root, int max){
        if(root == null)
            return;
        
        if(root.val>=max){
            globalCount++;
            max = root.val;
        }
        goodOnes(root.left, max);
        goodOnes(root.right, max);
    }
    public int goodNodes(TreeNode root) {
        goodOnes(root, Integer.MIN_VALUE);
        return globalCount;
    }
}