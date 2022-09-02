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
    // public void bfs(TreeNode root, List<Double> ans, Queue<TreeNode> q){
    //     if(root == null)
    //         return;
    //     q.offer(root);
    //     int s = q.size(), sum = 0;
    //     while(q.size()!=0){
    //         TreeNode x = q.poll();
    //         if(x.left!=null){
    //             sum+=x.left.val;
    //             q.offer(x.left);
    //         }
    //         if(x.right!=null){
    //             sum+=x.right.val;
    //             q.offer(x.right);
    //         }
    //     }
    // }
    Map<Integer, Pair<Long, Integer>> hm = new HashMap<>();
    public void trav(TreeNode root, int h){
        if(root == null)
            return;
        
        if(hm.containsKey(h)){
            // Pair<Integer, Integer> p = hm.get(h);
            Pair<Long, Integer> p = new Pair<>(hm.get(h).getKey()+(long)root.val, hm.get(h).getValue()+1);
            hm.put(h, p);
        }
        else{
            Pair<Long, Integer> p = new Pair<>((long)root.val, 1);
            hm.put(h, p);
        }
        trav(root.left, h+1);
        trav(root.right, h+1);
        
    }
    public List<Double> averageOfLevels(TreeNode root) {
        trav(root, 0);
        List<Double> ans = new ArrayList<>();
        for(Map.Entry el: hm.entrySet()){
            Pair<Long, Integer> p = (Pair)el.getValue();
            ans.add((double)p.getKey()/(double)p.getValue());
        }
        return ans;
    }
}