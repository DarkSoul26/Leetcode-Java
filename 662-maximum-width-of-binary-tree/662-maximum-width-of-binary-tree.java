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
    public int widthOfBinaryTree(TreeNode root) {
    return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
}
  public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
    if(root == null)return 0;
    if(start.size() == level){
        start.add(order);
        end.add(order);
    }
    else end.set(level, order);
    int cur = end.get(level) - start.get(level) + 1;
    int left = dfs(root.left, level + 1, 2*order, start, end);
    int right = dfs(root.right, level + 1, 2*order + 1, start, end);
    return Math.max(cur, Math.max(left, right));
}
}