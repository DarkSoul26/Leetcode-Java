/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return new ArrayList<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.offer(new Pair<>(root, 0));
        List<Integer> al1 = new ArrayList<>();
        al1.add(root.val);
        ans.add(al1);
        while(!q.isEmpty()){
            Pair<Node, Integer> p = q.poll();
            Node r = p.getKey();
            int level = p.getValue();
            List<Node> child = r.children;
            for(Node c: child){
                q.offer(new Pair<>(c, level+1));  
                if(ans.size()<=level+1){
                    List<Integer> al = new ArrayList<>();
                    al.add(c.val);
                    ans.add(al);
                }
                else{
                    // List<Integer> al = ans.get(level+1);
                    // al.add(c.val);
                    ans.get(level+1).add(c.val);
                    // ans.set(level+1, al);
                }
            }
        }
        return ans;
    }
}