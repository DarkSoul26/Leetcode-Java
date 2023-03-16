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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0;i<inorder.length;i++){
            hm.put(inorder[i], i);
        }
        
        return buildIt(postorder, 0, postorder.length-1, 0, inorder.length-1, hm);
    }
    
    public TreeNode buildIt(int[] postorder, int ps, int pe, int is, int ie, Map<Integer, Integer> hm){
        if(ps>pe || is>ie)
            return null;
            
        int inRoot = hm.get(postorder[pe]);
        TreeNode root = new TreeNode(postorder[pe]);
        root.left = buildIt(postorder, ps, ps+inRoot-is-1, is, inRoot-1, hm);
        root.right = buildIt(postorder, ps+(inRoot-is), pe-1, inRoot+1, ie, hm);
        return root;
    }
}