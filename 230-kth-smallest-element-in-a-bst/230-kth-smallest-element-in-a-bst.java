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
    public void trav(TreeNode root, List<Integer> al){
        if(root == null)
            return;
        al.add(root.val);
        trav(root.left, al);
        trav(root.right, al);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> al = new ArrayList<>();
        trav(root, al);
        Collections.sort(al);
        return al.get(k-1);
    }
}