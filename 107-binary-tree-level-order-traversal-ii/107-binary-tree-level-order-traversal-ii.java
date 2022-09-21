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
    public void levelIt(TreeNode root, int h, Map<Integer, List<Integer>> hm){
        if(root == null)
            return;
        
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        while(!q.isEmpty()){
            Pair<TreeNode, Integer> p = q.poll();  
            if(p.getKey().left != null)
                q.offer(new Pair<>(p.getKey().left, p.getValue()+1));
            if(hm.containsKey(p.getValue())){
                List<Integer> al = hm.get(p.getValue());
                al.add(p.getKey().val);
                hm.put(p.getValue(), al);
            }
            else{
                List<Integer> al = new ArrayList<>();
                al.add(p.getKey().val);
                hm.put(p.getValue(), al);
            }
            if(p.getKey().right != null)
                q.offer(new Pair<>(p.getKey().right, p.getValue()+1));
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> hm = new TreeMap<>();
        levelIt(root, 0, hm);
        List<List<Integer>> al = new ArrayList<>();
        int i = hm.size()-1;
        // System.out.println(i);
        for(int j=0;j<=i;j++)
            al.add(new ArrayList<>());
        for(Map.Entry el: hm.entrySet()){
            // System.out.println(el.getKey());
            // for(int j=0;j<(List)el.getValue().size();j++)
            //     System.out.print((List)el.getValue().get(j));
            // System.out.println();
            al.set(i--, (List)el.getValue());
        }
        
        return al;
    }
}