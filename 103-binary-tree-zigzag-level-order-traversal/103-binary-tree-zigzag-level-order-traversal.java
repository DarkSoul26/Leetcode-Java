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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        Map<Integer, List<Integer>> m = new TreeMap<>();
        zigzag(root, 0, m);
        for(Map.Entry el: m.entrySet()){
            al.add((List<Integer>)el.getValue());
        }
        return al;
        
    }
    public void zigzag(TreeNode root, int h, Map<Integer, List<Integer>> m){
        if(root == null)
            return;
        
        if(m.containsKey(h)){
            if(h%2==0)
                m.get(h).add(root.val);
            else
                m.get(h).add(0,root.val);
        }
        else{
            List<Integer> al1 = new ArrayList<>();
            al1.add(root.val);
            m.put(h, al1);
        }
        zigzag(root.left, h+1, m);
        zigzag(root.right, h+1, m);
    }
}