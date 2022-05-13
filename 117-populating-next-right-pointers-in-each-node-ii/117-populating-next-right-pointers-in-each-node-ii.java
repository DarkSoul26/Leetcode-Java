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
    public Node connect(Node root) {
        if(root == null)return root;
        
        Node node = root;
        Node dummy = new Node(0);
        Node temp = dummy;
        
        while(node != null){
            if(node.left != null){
                temp.next = node.left;
                temp = temp.next;
            }    
            if(node.right != null){
                temp.next = node.right;
                temp = temp.next;
            }
            node = node.next;
            if(node == null){
                node = dummy.next;
                temp = dummy;
                dummy.next = null;
            }
        }
        
        return root;
    }
}