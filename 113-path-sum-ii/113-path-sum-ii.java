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
    List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return list;
        
        dfs(root, new ArrayList<Integer>(), targetSum);         
        return list;
    }
    
    void dfs(TreeNode root, List<Integer> l, int targetSum){
        if(root==null)
            return;
        
        l.add(root.val);
        
        if(root.right==null && root.left==null){
            if(root.val == targetSum){
                list.add(new ArrayList<>(l));
            }
        }        
        dfs(root.left, l, targetSum-root.val);
        dfs(root.right, l,  targetSum-root.val);
        
        l.remove(l.size()-1);
        
        return ;
    }
    
}