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
    List<TreeNode> result;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // List del_nodes = Arrays.asList(to_delete);
        boolean[] del_nodes = new boolean[1001];
        for(int i: to_delete)
            del_nodes[i] = true;
        result = new ArrayList<>();            
        solveIt(root, del_nodes);
        if(root.val != -1)
            result.add(root);
        return result;
    }
    
    public void solveIt(TreeNode root, boolean[] del_nodes){
        if(root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(del_nodes[root.val]){
            root.val = -1;;
        }
        
        solveIt(left, del_nodes);
        if(root != null && root.left != null && root.left.val == -1)
            root.left = null;
        solveIt(right, del_nodes);
        if(root != null && root.right != null && root.right.val == -1)
            root.right = null;
        if(root.val == -1){
            if(left != null && left.val != -1)
                result.add(left);
            if(right != null && right.val != -1)
                result.add(right);
        }
    }
}