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
class BSTIterator {
    List<TreeNode> al;
    int pointer;
    public BSTIterator(TreeNode root) {
        al = new ArrayList<>();
        pointer = 0;
        inorderTraversal(root);
    }
    
    public int next() {
        if(pointer<al.size()){
            int x = al.get(pointer).val;
            pointer++;
            return x;
        }
        return -1;
    }
    
    public boolean hasNext() {
        if(pointer<al.size()){
            return true;
        }
        return false;
    }
    
    public void inorderTraversal(TreeNode root){
        if(root==null)
            return;
        inorderTraversal(root.left);
        al.add(root);
        inorderTraversal(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */