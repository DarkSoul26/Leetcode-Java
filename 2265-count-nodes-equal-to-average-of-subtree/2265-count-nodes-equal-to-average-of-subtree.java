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
    public void findSum(TreeNode root, int[] a){
        if(root == null)
            return;
        a[0]+=root.val;
        a[1]++;
        findSum(root.left, a);
        findSum(root.right, a);
    }
    int ans = 0;
    public void traverse(TreeNode root){
        if(root == null)
            return;
        int[] a = new int[2];
        findSum(root, a);
        if(a[1] != 0){
            
        if(root.val == a[0]/a[1])
            ans++;
        }
        traverse(root.left);
        traverse(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        traverse(root);
        return ans;
    }
}