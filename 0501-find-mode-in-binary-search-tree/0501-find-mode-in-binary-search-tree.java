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
   /*Use a dictionary to store the frequency of each interger. Then simply find the largest frequency and return all the associated keys.*/
    private Map<Integer, Integer> map = new HashMap();
    private int maxCount = 0;
    
    private void initializeMap(TreeNode root) {
        if (root == null) {
            return;
        }
        int values = map.getOrDefault(root.val, 0);
        values++;
        map.put(root.val, values);

        if (root.left != null) {
            initializeMap(root.left);
        }
        if (root.right != null) {
            initializeMap(root.right);
        }
    }

    public int[] findMode (TreeNode root)
    {
        initializeMap(root);
        for (Integer value : map.values()) {
            if (value > maxCount) {
                maxCount = value;
            }
        }
        int[] result = new int[100];
        int index = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCount) {
                result[index++] = key;
            }
        }
        int[] data = new int[index];
        System.arraycopy(result, 0, data, 0, index);

        return data;
    }
}