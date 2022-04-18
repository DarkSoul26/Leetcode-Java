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
    TreeNode ans;
    public void trav(TreeNode root){
        if(root == null){
            return;
        }
        
        trav(root.left);
        ans.val = root.val;
        ans.right = new TreeNode();
        ans.left = null;
        ans = ans.right;
        trav(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        ans = new TreeNode();
        TreeNode finalA = ans;
        TreeNode ans2 = finalA;
        trav(root);
        while(finalA.right.val != 0){
            finalA = finalA.right;
        }
        finalA.right = null;
        return ans2;
    }
}