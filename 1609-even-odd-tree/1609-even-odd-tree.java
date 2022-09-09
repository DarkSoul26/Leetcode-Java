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
    boolean flag = true;
    public void checkIt(TreeNode root, Map<Integer, Integer> hm, int h){
        if(root == null)
            return;
        
        checkIt(root.left, hm, h+1);
        if(hm.containsKey(h)){
            if(h%2!=0){
                if(hm.get(h)>root.val && root.val%2==0)
                    hm.put(h, root.val);
                else{
                    flag = false;
                    return;
                }
            }
            else{
                if(hm.get(h)<root.val && root.val%2!=0)
                    hm.put(h, root.val);
                else{
                    flag = false;
                    return;
                }
            }
        }
        else{
            if((h%2==0 && root.val%2==0) || (h%2!=0 && root.val%2!=0)){
                flag = false;
                return;
            }
            hm.put(h, root.val);
        }
        
        
        checkIt(root.right, hm, h+1);
    }
    public boolean isEvenOddTree(TreeNode root) {
        checkIt(root, new HashMap<>(), 0);
        return flag;
    }
}