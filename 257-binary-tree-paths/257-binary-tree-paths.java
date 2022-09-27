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
    List<String> ans = new ArrayList<>();
    public void travPaths(TreeNode root, List<Integer> al){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<al.size();i++)
                sb.append(al.get(i)+"->");
            sb.append(root.val);
            ans.add(sb.toString());
        }
        al.add(root.val);
        travPaths(root.left, al);
        travPaths(root.right, al);
        al.remove(al.size()-1);
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        travPaths(root, new ArrayList<>());
        return ans;
    }
}