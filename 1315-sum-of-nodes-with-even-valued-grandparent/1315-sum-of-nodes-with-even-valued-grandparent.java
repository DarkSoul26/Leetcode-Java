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
    int sum = 0;
    public void sumIt(TreeNode root, int parent, int grandParent){
        if(root == null)
            return;
        sum += grandParent == -1?0:(grandParent%2!=0?0:root.val);
        // System.out.println(grandParent == -1?0:(grandParent%2==0?0:root.val));
        sumIt(root.left, root.val, parent);
        sumIt(root.right, root.val, parent);
    }
    public int sumEvenGrandparent(TreeNode root) {
        sumIt(root, -1, -1);
        return sum;
    }
}