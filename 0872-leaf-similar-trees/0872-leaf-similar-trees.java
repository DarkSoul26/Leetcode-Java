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
    
    public void callRoots(TreeNode root, List<Integer> al){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            al.add(root.val);
            return;
        }
        callRoots(root.left, al);
        callRoots(root.right, al);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        callRoots(root1, al1);
        callRoots(root2, al2);
        if(al1.size() != al2.size())
            return false;
        for(int i=0;i<al1.size();i++){
            if(al1.get(i) != al2.get(i))
                return false;
        }
        
        return true;
    }
}