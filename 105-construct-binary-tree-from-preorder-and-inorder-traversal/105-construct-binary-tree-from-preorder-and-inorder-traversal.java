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
    public TreeNode buildTree(int[] P, int[] I) {
        Map<Integer, Integer> MA = new HashMap<>();
        for (int i = 0; i < I.length; i++)
            MA.put(I[i], i);
        return splitTree(P, MA, 0, 0, I.length-1);
    }
    
    private TreeNode splitTree(int[] P, Map<Integer, Integer> MA, int pix, int il, int ir) {
        int rval = P[pix], imid = MA.get(rval);
        TreeNode root = new TreeNode(rval);            
        if (imid > il)
            root.left = splitTree(P, MA, pix+1, il, imid-1);
        if (imid < ir)
            root.right = splitTree(P, MA, pix+imid-il+1, imid+1, ir);
        return root;
    }
}