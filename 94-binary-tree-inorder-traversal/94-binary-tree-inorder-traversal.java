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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ino = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while(true){
            if(root!=null){
                stk.push(root);
                root = root.left;
            }
            else{
                if(stk.isEmpty())
                    break;
                TreeNode x = stk.pop();
                ino.add(x.val);
                root = x.right;
            }
        }
        return ino;
    }
}