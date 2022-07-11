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
    List<Integer> al = new ArrayList<>();
    int max_level = 0;
    void rightViewNextLvl(TreeNode q, int lvl){
        if(q==null)
          return;
        if(max_level<lvl){
          al.add(q.val);
          max_level = lvl;
        }
        if(q.right!=null){
          rightViewNextLvl(q.right,lvl+1);
        }
        if(q.left!=null){
          rightViewNextLvl(q.left,lvl+1);
        }
        
    }
    public List<Integer> rightSideView(TreeNode root) {
        rightViewNextLvl(root,1);
        return al;
    }
}