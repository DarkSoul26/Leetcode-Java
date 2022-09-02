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
    public void vertTrav(TreeNode root, Map<Integer, Map<Integer, PriorityQueue<Integer>>> tm, int vertLevel, int horLevel){
        if(root == null)
            return;
        
        if(tm.containsKey(vertLevel)){
            Map<Integer, PriorityQueue<Integer>> tm1 = tm.get(vertLevel);
            if(tm1.containsKey(horLevel)){
                // tm1.get(horLevel).add(root.val);
                PriorityQueue<Integer> pq = tm1.get(horLevel);
                pq.add(root.val);
                tm1.put(horLevel, pq);
            }
            else{
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.offer(root.val);
                tm1.put(horLevel, pq);
            }
            tm.put(vertLevel, tm1);
        }
        else{
            Map<Integer, PriorityQueue<Integer>> tm1 = new TreeMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(root.val);
            tm1.put(horLevel, pq);
            tm.put(vertLevel, tm1);
        }
        vertTrav(root.left, tm, vertLevel-1, horLevel+1);
        vertTrav(root.right, tm, vertLevel+1, horLevel+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> tm = new TreeMap<>();
        vertTrav(root, tm, 0, 0);
        for(int i=0;i<tm.size();i++)
            al.add(new ArrayList<>());
        // System.out.println(tm.size());
        int i = 0;
        for(Map.Entry el: tm.entrySet()){
            // System.out.println(tm.size());
            Map<Integer, PriorityQueue<Integer>> tm1 = (Map)el.getValue();
            List<Integer> al1 = al.get(i);
            for(Map.Entry el1: tm1.entrySet()){
                PriorityQueue<Integer> pq = (PriorityQueue)el1.getValue();
                while(!pq.isEmpty())
                    al1.add(pq.poll());
            }
            i++;
        }
        return al;
    }
}