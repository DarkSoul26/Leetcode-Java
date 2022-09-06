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
    List<TreeNode>find(int n){
        List<TreeNode>list=new ArrayList<>();
        if(n==1){list.add(new TreeNode(0));return list;}
        n=n-1;
        for(int i=1;i<=n;i+=2){
            List<TreeNode>left=find(i);
            List<TreeNode>right=find(n-i);
            for(TreeNode l : left)
                for(TreeNode r : right){
                    TreeNode root=new TreeNode(0,l,r);
                    list.add(root);
                }
        }
        return list;
    }
    public List<TreeNode> allPossibleFBT(int n) {
       if(n%2==0)return new ArrayList<>();
        return find(n);
        
    }
}