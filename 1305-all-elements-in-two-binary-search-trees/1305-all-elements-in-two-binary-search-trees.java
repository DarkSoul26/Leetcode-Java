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
    public void traverseIt(TreeNode root1, List<Integer> al){
        if(root1 == null)
            return;
        al.add(root1.val);
        traverseIt(root1.left, al);
        traverseIt(root1.right, al);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> al = new ArrayList<>();
        traverseIt(root1,al);
        traverseIt(root2,al);
        Collections.sort(al);
        return al;
    }
}