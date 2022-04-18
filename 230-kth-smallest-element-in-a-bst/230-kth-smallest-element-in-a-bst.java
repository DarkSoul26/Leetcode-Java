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
    int ans = -1, count = 0;
    public void travInorder(TreeNode root, int k){
        if(root == null)
            return;
        
        travInorder(root.left, k);
        count++;
        if(count == k && ans == -1){
            ans = root.val;
            return;
        }
        travInorder(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        travInorder(root, k);
        return ans;
        
    }
}