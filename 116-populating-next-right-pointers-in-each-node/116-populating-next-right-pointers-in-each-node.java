/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node bfs(Node root, Queue<Pair<Node, Integer>> q, Map<Integer, List<Node>> hm){
        Node ans = root;
        // Node parent = ans;
        q.add(new Pair(ans, 0));
        while(!q.isEmpty()){
            Pair<Node, Integer> x = q.poll();
            if(x.getKey().left!=null)
                q.add(new Pair(x.getKey().left, x.getValue()+1));
            if(x.getKey().right!=null)
                q.add(new Pair(x.getKey().right, x.getValue()+1));
            if(hm.containsKey(x.getValue())){
                List<Node> temp = hm.get(x.getValue());
                Node h = temp.get(temp.size()-1);
                h.next = x.getKey();
                x.getKey().next = null;
                temp.add(x.getKey());
                hm.put(x.getValue(), temp);
            }
            else{
                List<Node> temp = new ArrayList<>();
                // Node h = temp.get(temp.size()-1);
                // h.next = x.getKey();
                x.getKey().next = null;
                temp.add(x.getKey());
                hm.put(x.getValue(), temp);
            }
        }
        return ans;
    }
    public Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        Map<Integer, List<Node>> hm = new HashMap<>();
        return bfs(root, q, hm);
    }
}