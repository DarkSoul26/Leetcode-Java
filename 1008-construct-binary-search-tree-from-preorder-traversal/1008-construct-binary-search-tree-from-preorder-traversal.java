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
    public TreeNode bst(int[] preorder, int start, int end){
        if(start==end)
            return new TreeNode(preorder[start]);
        if(start>end)
            return null;
        TreeNode newN = new TreeNode(preorder[start]);
        int i = start;
        while(i<=end){
            if(preorder[i]>preorder[start])
                break;
            i++;
        }
        newN.left = bst(preorder, start+1, i-1);
        newN.right = bst(preorder, i, end);

        return newN;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, 0, preorder.length-1);
    }
}