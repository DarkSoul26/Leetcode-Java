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
    int ans = 0;
    public void checkIt(TreeNode root, int path){
        if(root == null)
            return;
        
        path = path*10+root.val;
        if(root.left == null && root.right == null){
            ans+=path;
        }
        else{
            checkIt(root.left, path);
            checkIt(root.right, path);
        }
        path = path/10;
        
    }
    public int sumNumbers(TreeNode root) {
        checkIt(root, 0);
        
        return ans;
    }
}