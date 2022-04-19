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
    TreeNode first;
    TreeNode prev;
    TreeNode midd;
    TreeNode last;
    public void inorderTrav(TreeNode root){
        if(root == null)
            return;
        
        inorderTrav(root.left);
        if(prev!=null && (root.val<prev.val)){
            if(first==null){
                first = prev;
                midd = root;
            }
            else{
                last = root;
            }
        }
        prev = root;
        inorderTrav(root.right);
    }
    public void recoverTree(TreeNode root) {
        last = null;
        inorderTrav(root);
        if(last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else{
            int temp = first.val;
            first.val = midd.val;
            midd.val = temp;
        }
    }
}