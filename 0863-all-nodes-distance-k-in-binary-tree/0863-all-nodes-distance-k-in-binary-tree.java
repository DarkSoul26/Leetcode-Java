/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new LinkedList<>();
        depth(root, target, result, K);
        return result;
    }
    private int depth(TreeNode root, TreeNode target, List<Integer> result, int K) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            add(root, result, K);
            return 1;
        }
        int left = depth(root.left, target, result, K);
        int right = depth(root.right, target, result, K);
        if (left == K || right == K) {
            result.add(root.val);
        } else {
            if (left > -1) {
                add(root.right, result, K - left - 1);
                return left + 1;
            }
            if (right > -1) {
                add(root.left, result, K - right - 1);
                return right + 1;
            }
        }
        return -1;
    }
    private void add(TreeNode root, List<Integer> result, int K) {
        if (K < 0 || root == null) {
            return;
        }
        if (K == 0) {
            result.add(root.val);
            return;
        }
        add(root.left, result, K - 1);
        add(root.right, result, K - 1);
    }
}