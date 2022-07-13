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

public class treeQueue{
  TreeNode a[] = new TreeNode[2001];
  int front = 0;
  int rear = 0;
  public void enque(TreeNode item){
    this.a[rear] = item;
    this.rear++;
  }
  public TreeNode deque(){
      TreeNode temp = this.a[front];
      this.front++;
      return temp;
  }
  public boolean isEmpty(){
    if(this.front == this.rear)
      return true;
    return false;
  }
}

class Solution {
    List<List<Integer>> al = new ArrayList<>(20);
    public void levelOrderNextLevel(treeQueue q, int lvl){
        if(q.isEmpty())
            return;
        TreeNode temp = q.deque();
        if(al.size()<=lvl){
            List<Integer> al1 = new ArrayList<>();
            al1.add(temp.val);
            al.add(al1);
        }
        else{
            List<Integer> al1 = al.get(lvl);
            al1.add(temp.val);
        }
        if(temp.left!=null){
            q.enque(temp.left);
            levelOrderNextLevel(q,lvl+1);
        }
        if(temp.right!=null){
            q.enque(temp.right);
            levelOrderNextLevel(q,lvl+1);
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return al;
        treeQueue q = new treeQueue();
        q.enque(root);
        levelOrderNextLevel(q,0);
        return al;
    }
}